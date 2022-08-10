package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AllExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);


        final ArrayList<Exercise> allExercises = new ArrayList<>();

        allExercises.add(new Exercise( "Upper Body", "Push Ups", R.drawable.people_exercising));
        allExercises.add(new Exercise("Abdominal", "Sit ups", R.drawable.people_exercising));;
        allExercises.add(new Exercise("Lower Body", "Squats", R.drawable.people_exercising));;

        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(this, allExercises);
        ListView listView = findViewById(R.id.listview_exercises);
        listView.setAdapter(exerciseAdapter);

    }
}
