package com.example.edupract.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edupract.Adapter.SearchAdapter;
import com.example.edupract.Model.GridModel;
import com.example.edupract.R;
import com.example.edupract.databinding.FragmentSearchBinding;

import java.util.ArrayList;


public class searchFragment extends Fragment {
    FragmentSearchBinding binding;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList searchList;

    public searchFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false);

        searchList = new ArrayList<GridModel>();

        searchList.add(new GridModel(R.drawable.pic1));
        searchList.add(new GridModel(R.drawable.pic2));
        searchList.add(new GridModel(R.drawable.pic3));
        searchList.add(new GridModel(R.drawable.pic4));
        searchList.add(new GridModel(R.drawable.pic5));
        searchList.add(new GridModel(R.drawable.pic6));
        searchList.add(new GridModel(R.drawable.pic7));
        searchList.add(new GridModel(R.drawable.pic8));
        searchList.add(new GridModel(R.drawable.pic9));
        searchList.add(new GridModel(R.drawable.pic10));
        searchList.add(new GridModel(R.drawable.pic11));
        searchList.add(new GridModel(R.drawable.pic12));

        SearchAdapter adapter = new SearchAdapter(getContext(),searchList);
        binding.searchRecycle.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        binding.searchRecycle.setLayoutManager(layoutManager);
        binding.searchRecycle.setAdapter(adapter);






        return binding.getRoot();
    }
}