package com.example.edupract.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edupract.Model.GridModel;
import com.example.edupract.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.viewHolder>{
    Context context;
    ArrayList<GridModel> gridList;

    public SearchAdapter(Context context, ArrayList<GridModel> list) {
        this.context = context;
        gridList = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GridModel model = gridList.get(position);
        holder.grid.setImageResource(model.getGridImg());

    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView grid;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            grid = itemView.findViewById(R.id.gridImg);
        }
    }
}
