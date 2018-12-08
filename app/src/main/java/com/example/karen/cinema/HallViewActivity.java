package com.example.karen.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HallViewActivity extends AppCompatActivity {

    private List<Place> placesList;
    private Hall hall;
    private RecyclerView hallViewRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall__view);



        Intent intent = getIntent();
        hall = (Hall) intent.getSerializableExtra("currentHall");
        placesList = hall.getPlaces();

        hallViewRecycler = findViewById(R.id.hallViewRecycle);

        LinearLayoutManager manager = new GridLayoutManager(this, hall.getSeatCount());
        hallViewRecycler.setLayoutManager(manager);



        final HallViewAdapter adapter = new HallViewAdapter(placesList,HallViewActivity.this);
        hallViewRecycler.setAdapter(adapter);


    }
}
