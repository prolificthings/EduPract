package com.example.trustus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int[] icons = {
            R.drawable.study,
            R.drawable.tour,
            R.drawable.habits,
            R.drawable.entrnmnt,
            R.drawable.read,
            R.drawable.decor,
            R.drawable.foodies,
            R.drawable.fashion,
            R.drawable.tech
    };

    String[] names = {
            "Education","Tour n Travel","Healthy habits","Entertainment","Bookreads","Home decor",
            "Eateries","Fashion","Technology"
    };

    GridView grid;

    LinearLayout fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.gridView);
        grid.setAdapter(new gridAdapter(names,icons,this));

        fire = findViewById(R.id.fireLayout);
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fireIntent = new Intent(MainActivity.this,FireActivity.class);
                startActivity(fireIntent);
                finish();
            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 4){
                    Intent bookIntent = new Intent(MainActivity.this, BookActivity.class);
                    startActivity(bookIntent);
                    finish();
                }
            }
        });

    }
}