package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRoutinesButton();
        AllExercisesButton();
        PreMadeButton();
    }

    private void MyRoutinesButton() {
        Button MyRoutinesButton = findViewById(R.id.button);
        MyRoutinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMyRoutines();
            }
        });
    }
    public void OpenMyRoutines () {
        Intent intent = new Intent (this, MyRoutines.class);
        startActivity(intent);
    }

    private void AllExercisesButton() {
        Button MyRoutinesButton = findViewById(R.id.button2);
        MyRoutinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCreateRoutines();
            }
        });
    }
    public void OpenCreateRoutines () {
        Intent intent = new Intent (this, AllExercises.class);
        startActivity(intent);
    }

    private void PreMadeButton() {
        Button MyRoutinesButton = findViewById(R.id.button3);
        MyRoutinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPreMadeRoutines();
            }
        });
    }
    public void OpenPreMadeRoutines () {
        Intent intent = new Intent (this, PreMadeActivities.class);
        startActivity(intent);
    }

}