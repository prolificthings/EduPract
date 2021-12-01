package com.example.edupract;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class CardAdapter extends BaseAdapter {

    Context context;
    ArrayList<CardModel> cardList;

    public CardAdapter(Context context, ArrayList<CardModel> list) {
        this.context = context;
        cardList = list;
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.homecard_item,parent,false);
        ImageView imageView;
        TextView textView;
        CardView cardView;
        imageView = view.findViewById(R.id.cardImg);
        textView = view.findViewById(R.id.cardTxt);
        cardView = view.findViewById(R.id.card);

        cardView.setCardBackgroundColor(getRandomColor());


        CardModel model = cardList.get(position);
        textView.setText(model.getText());
        Picasso.get().load(model.getUri()).into(imageView);

        return view;
    }

    public static int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }


}
