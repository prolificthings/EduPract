package com.example.trustus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pl.droidsonroids.gif.GifImageView;

public class FireAdapter extends RecyclerView.Adapter<FireAdapter.viewHolder> {

    int[] images;
    String[] paras;

    public FireAdapter(int[] images, String[] paras) {
        this.images = images;
        this.paras = paras;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

         GifImageView gif;
         TextView txt;

         public viewHolder(@NonNull View itemView) {
             super(itemView);
             gif = (itemView).findViewById(R.id.fireGif);
             txt = (itemView).findViewById(R.id.txtFire);
         }
     }

    @NonNull
    @Override
    public FireAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fire_item,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FireAdapter.viewHolder holder, int position) {
        holder.gif.setImageResource(images[position]);
        holder.txt.setText(paras[position]);
    }

    @Override
    public int getItemCount() {
        return paras.length;
    }
}
