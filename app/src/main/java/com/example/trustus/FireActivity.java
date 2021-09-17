package com.example.trustus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class FireActivity extends AppCompatActivity {



    ViewPager2 firePager;
    FireAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        firePager = findViewById(R.id.vp);

        int[] images = {R.drawable.cooking,R.drawable.oven_fire, R.drawable.oil_cooking, R.drawable.oil_fire, R.drawable.child_safety};
        String[] fire = getResources().getStringArray(R.array.fire_txts);

        adapter = new FireAdapter(images,fire);
        firePager.setAdapter(adapter);

        firePager.setClipToPadding(false);
        firePager.setClipChildren(false);
        firePager.setOffscreenPageLimit(3);
    }
}