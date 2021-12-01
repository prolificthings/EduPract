package com.example.edupract.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.edupract.CardAdapter;
import com.example.edupract.CardModel;
import com.example.edupract.R;
import com.example.edupract.databinding.FragmentHomeBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yalantis.library.Koloda;

import java.util.ArrayList;


public class homeFragment extends Fragment {

    FragmentHomeBinding binding;
    CardAdapter adapter;

    ArrayList cardList;

    FirebaseDatabase database;

    public homeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        cardList = new ArrayList<CardModel>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        database.getReference().child("person").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (int i=0; i<3; i++) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        CardModel model = dataSnapshot.getValue(CardModel.class);
                        cardList.add(model);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        adapter = new CardAdapter(getContext(),cardList);

        binding.koloda.setAdapter(adapter);

        return binding.getRoot();
    }
}