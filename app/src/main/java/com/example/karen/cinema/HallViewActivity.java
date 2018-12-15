package com.example.karen.cinema;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HallViewActivity extends AppCompatActivity {

    private List<Place> reservedPlaces;

    private List<Place> placesList;
    private Hall hall;
    private RecyclerView hallViewRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall__view);

        reservedPlaces = new ArrayList<>();

        Intent intent = getIntent();
        hall = (Hall) intent.getSerializableExtra("currentHall");
        placesList = hall.getPlaces();

        hallViewRecycler = findViewById(R.id.hallViewRecycle);

        LinearLayoutManager manager = new GridLayoutManager(this, hall.getSeatCount());
        hallViewRecycler.setLayoutManager(manager);



        final HallViewAdapter adapter = new HallViewAdapter(placesList,HallViewActivity.this);

        adapter.setOnPlaceClikedListener(new HallViewAdapter.OnPlaceClikedListener() {
            @Override
            public void onPlaceClick(Place place) {
                reservedPlaces.add(place);
                Toast.makeText(HallViewActivity.this,"size" + reservedPlaces.size(),Toast.LENGTH_SHORT).show();
            }
        });


        hallViewRecycler.setAdapter(adapter);


    }
}
