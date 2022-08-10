package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;


public class PreMadeActivities extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Exercise> preMadeRoutine1;
    private ArrayList<Exercise> preMadeRoutine2;
    private ArrayList<Exercise> preMadeRoutine3;
    private ArrayList<Exercise> preMadeRoutine4;
    private ArrayList<Exercise> preMadeRoutine5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pre_made_activities);
        findViewById(R.id.premade_1_button).setOnClickListener(this);
        findViewById(R.id.premade_2_button).setOnClickListener(this);
        findViewById(R.id.premade_3_button).setOnClickListener(this);
        findViewById(R.id.premade_4_button).setOnClickListener(this);
        findViewById(R.id.premade_5_button).setOnClickListener(this);

        preMadeRoutine1 = new ArrayList<Exercise>();
        preMadeRoutine1.add(new Exercise("Upper Body", "Press Ups", R.drawable.people_exercising));
        preMadeRoutine1.add(new Exercise("Upper Body", "Sit Ups", R.drawable.people_exercising));
        preMadeRoutine1.add(new Exercise("Upper Body", "Squats", R.drawable.people_exercising));
        preMadeRoutine1.add(new Exercise("Upper Body", "Curls", R.drawable.people_exercising));

        preMadeRoutine2 = new ArrayList<Exercise>();
        preMadeRoutine2.add(new Exercise("Upper Body", "2 ", R.drawable.people_exercising));


        preMadeRoutine3 = new ArrayList<Exercise>();
        preMadeRoutine3.add(new Exercise("Upper Body", " 3", R.drawable.people_exercising));


        preMadeRoutine4 = new ArrayList<Exercise>();
        preMadeRoutine4.add(new Exercise("Upper Body", " 4", R.drawable.people_exercising));
 ;

        preMadeRoutine5 = new ArrayList<Exercise>();
        preMadeRoutine5.add(new Exercise("Upper Body", "5", R.drawable.people_exercising));


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Routine.class);
        switch (view.getId()) {
            case R.id.premade_1_button:
                intent.putParcelableArrayListExtra(Exercise.TYPE, preMadeRoutine1);
                startActivity(intent);
                break;

            case R.id.premade_2_button:
                intent.putParcelableArrayListExtra(Exercise.TYPE, preMadeRoutine2);
                startActivity(intent);
                break;

            case R.id.premade_3_button:
                intent.putParcelableArrayListExtra(Exercise.TYPE, preMadeRoutine3);
                startActivity(intent);
                break;

            case R.id.premade_4_button:
                intent.putParcelableArrayListExtra(Exercise.TYPE, preMadeRoutine4);
                startActivity(intent);
                break;

            case R.id.premade_5_button:
                intent.putParcelableArrayListExtra(Exercise.TYPE, preMadeRoutine5);
                startActivity(intent);
                break;
        }
    }
}
