package com.example.karen.cinema;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNewSeans extends AppCompatActivity {

    EditText filmNameEdit;
    Hall[] halls;
    Hall currentHall;
    Button addBtnFromFilmActivity;
    EditText seansPriceFromActivity;
    String takedSeansPriceFromActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seansPriceFromActivity = findViewById(R.id.seansPriceFromActivity);

        setContentView(R.layout.activity_add_new_seans);
        halls = new Hall[]{
                Hall.HALL_1,
                Hall.HALL_1,
                Hall.HALL_2,
                Hall.HALL_3,
                Hall.VIP_HALL
        };


        String[] data = {"SELECT HALL", "Hall_1", "Hall_2","HALL_3","VIP_HALL"};

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        Spinner spinner = (Spinner) findViewById(R.id.chooseHallSpinner);

        spinner.setAdapter(adapter);

        spinner.setPrompt("Title");

        spinner.setSelected(false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                currentHall = halls[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        addBtnFromFilmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("currentHall",currentHall);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
