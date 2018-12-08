package com.example.karen.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmsActivity extends AppCompatActivity {
    private List<Film> films;
    private RecyclerView filmsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        films = new ArrayList<>();

        filmsRecycler = findViewById(R.id.filmrecycler);

        Film film1 = new Film("Sherlok Holms","");
        film1.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                2000));
        film1.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                1000));

        films.add(film1);
        Film film2 = new Film("The number 21","");
        film2.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                2000));
        film2.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                1000));
        films.add(film2);



        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        filmsRecycler.setLayoutManager(manager);

        final FilmsAdapter adapter = new FilmsAdapter(films,FilmsActivity.this);
        filmsRecycler.setAdapter(adapter);
    }
}
