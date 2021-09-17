package com.example.trustus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class gridAdapter extends BaseAdapter {

    public String[] names;
    public int[] images;
    Context context;

    public gridAdapter(String[] names, int[] images, Context context) {
        this.names = names;
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.singleframe,null);

        ImageView img = view.findViewById(R.id.img);
        TextView tv = view.findViewById(R.id.txt);

        img.setImageResource(images[i]);
        tv.setText(names[i]);

        return view;
    }
}
