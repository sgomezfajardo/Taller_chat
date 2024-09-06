package com.example.chatplannercitizen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonCitizen;
    private Button buttonPlanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCitizen = findViewById(R.id.buttonCitizen);
        buttonPlanner = findViewById(R.id.buttonPlanner);

        buttonCitizen.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CitizenActivity.class);
            startActivity(intent);
        });

        buttonPlanner.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlannerActivity.class);
            startActivity(intent);
        });
    }
}
