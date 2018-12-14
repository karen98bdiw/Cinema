package com.example.karen.cinema;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button userBtn;
    Button adminBtn;
    EditText adminPassword;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userBtn = findViewById(R.id.goToSeans);
        adminBtn = findViewById(R.id.adminBtn);
        adminPassword = findViewById(R.id.adminPassword);

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilmsActivity.class);
                intent.putExtra("isAdmin",false);
                startActivity(intent);
            }
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adminPassword.getText().toString().equals("admin")){
                Intent intent = new Intent(MainActivity.this,FilmsActivity.class);
                intent.putExtra("isAdmin",true);
                startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
