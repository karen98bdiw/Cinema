package com.example.karen.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seanses extends AppCompatActivity {

    private List<Seans> data;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seanses);
        data = new ArrayList<>();

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra("currentFilm");
        data = film.getSeanses();

        recyclerView = findViewById(R.id.seansRecycle);

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);



        final SeansesAdapter adapter = new SeansesAdapter(data,Seanses.this);
        recyclerView.setAdapter(adapter);

    }
}
