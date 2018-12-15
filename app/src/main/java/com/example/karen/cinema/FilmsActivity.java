package com.example.karen.cinema;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmsActivity extends AppCompatActivity {

    private boolean isAdmin;
    private List<Film> films;
    private RecyclerView filmsRecycler;
    private Hall resultHall;
    private String resultFilmName;
    private Film resultFilm;
    private Button addFilmBtn;
    private FilmsAdapter adapter;
    private String mainSeansPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        addFilmBtn =  findViewById(R.id.addFilmBtn);

        final Intent intent = getIntent();
        isAdmin = intent.getBooleanExtra("isAdmin",false);
        if(isAdmin){
            Toast.makeText(this,"you are Admin",Toast.LENGTH_SHORT).show();
            addFilmBtn.setVisibility(View.VISIBLE);

        }else{
            Toast.makeText(this,"you are User",Toast.LENGTH_SHORT).show();
        }

        addFilmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FilmsActivity.this,AddFilm.class);
                startActivityForResult(intent1,1);
            }
        });


        films = new ArrayList<>();



        filmsRecycler = findViewById(R.id.filmrecycler);

        Film film1 = new Film("Sherlok Holms","");
        film1.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                "4000"));
        film1.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                "3000"));

        films.add(film1);
        Film film2 = new Film("The number 21","");
        film2.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                "2000"));
        film2.addSeans(new Seans(Hall.HALL_2,
                new Date(2018,12,25,18,0,0),
                "1000"));
        films.add(film2);



        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        filmsRecycler.setLayoutManager(manager);

        adapter = new FilmsAdapter(films,FilmsActivity.this,isAdmin);
        filmsRecycler.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                mainSeansPrice = data.getStringExtra("filmSeansPrice");
                resultFilmName = data.getStringExtra("filmName");
                resultHall = (Hall) data.getSerializableExtra("currentHall");
                resultFilm = new Film(resultFilmName,"");
                resultFilm.addSeans(new Seans(resultHall, new Date(2018,12,25,18,0,0),
                        mainSeansPrice));
                films.add(resultFilm);
                Toast.makeText(FilmsActivity.this,"size" + " " + "RESULT_OK" + " " + films.size(),Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(FilmsActivity.this,"not Result",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
