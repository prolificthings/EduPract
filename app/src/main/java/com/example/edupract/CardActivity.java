package com.example.edupract;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yalantis.library.Koloda;

import java.util.ArrayList;


public class CardActivity extends AppCompatActivity {

    CardAdapter adapter;
    Koloda koloda;
    ArrayList cardList;
    ImageView left,right;

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        database = FirebaseDatabase.getInstance();
        cardList = new ArrayList<CardModel>();

       koloda = findViewById(R.id.koloda);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);

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

        adapter = new CardAdapter(this,cardList);

        koloda.setAdapter(adapter);

    }

}