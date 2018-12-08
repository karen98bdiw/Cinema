package com.example.karen.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Film film = new Film("hey","");
        film.addSeans(new Seans(Hall.HALL_1,
                new Date(2018,12,8,11,0),
                2000));


    }
}
