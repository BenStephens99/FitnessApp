package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Routine extends AppCompatActivity implements View.OnClickListener{

    int routineSize;
    int exerciseLength;
    int exerciseCounter;
    int restLength;

    TextView timeLeft;
    TextView activityLengthText;
    TextView restLengthText;
    TextView intervalsText;
    TextView currentActivity;
    TextView currentText;

    String TAG;

    ArrayList<Exercise> RoutineList;

    int intervals;
    int intervalCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        TAG = "Debug";

        RoutineList = getIntent().getParcelableArrayListExtra(Exercise.TYPE);
        routineSize = RoutineList.size();
        exerciseLength = 30000;
        exerciseCounter = 0;
        timeLeft = findViewById(R.id.time_text);
        activityLengthText = findViewById(R.id.work_time_text);
        restLengthText = findViewById(R.id.rest_time_text);
        intervalsText = findViewById(R.id.interval_num);
        currentActivity = findViewById(R.id.current_exercise_text);
        currentText = findViewById(R.id.current_text);
        intervals = 4;
        intervalCounter = 0;
        restLength = 10000;

        activityLengthText.setText(String.valueOf(exerciseLength/1000));
        restLengthText.setText(String.valueOf(restLength/1000));
        intervalsText.setText(String.valueOf(intervals));

        if (RoutineList != null) {
            ExerciseAdapter exerciseAdapter = new ExerciseAdapter(this, RoutineList);
            ListView listView = findViewById(R.id.current_routine);
            listView.setAdapter(exerciseAdapter);

        }
        findViewById(R.id.start_button).setOnClickListener(this);

        findViewById(R.id.work_time_minus).setOnClickListener(this);
        findViewById(R.id.work_time_plus).setOnClickListener(this);

        findViewById(R.id.rest_time_minus).setOnClickListener(this);
        findViewById(R.id.rest_time_plus).setOnClickListener(this);

        findViewById(R.id.intervals_plus).setOnClickListener(this);
        findViewById(R.id.intervals_minus).setOnClickListener(this);
    }

    private void StartCountdown() {
        final CountDownTimer restTimer = new CountDownTimer(restLength, 1000) {
            public void onTick(long millisUntilFinished) {
                int sec = (int) Math.round((millisUntilFinished / (double) 1000) % 60);
                timeLeft.setText("" + sec);
                currentActivity.setText("Up Next: " + RoutineList.get(exerciseCounter).getExerciseName());
                currentText.setText("Rest");
                currentActivity.setBackgroundColor(Color.YELLOW);
            }
            public void onFinish() {
                startRoutine();
                exerciseCounter++;
            }
        };

        final CountDownTimer exerciseTimer = new CountDownTimer(exerciseLength, 1000) {
            public void onTick(long millisUntilFinished) {
                int sec = (int) Math.round((millisUntilFinished / (double) 1000) % 60);
                timeLeft.setText("" + sec);
                currentActivity.setText(RoutineList.get(exerciseCounter).getExerciseName());
                currentText.setText("Work  ");
                currentActivity.setBackgroundColor(Color.GREEN);
            }
            public void onFinish() {
                restTimer.start();
            }
        }.start();
    }

    private void startRoutine() {
        Log.d(TAG, "startRoutine: " + exerciseCounter);
        if (exerciseCounter < routineSize - 1) {
            Log.d(TAG, "startRoutine: if ec > rs");
            StartCountdown();
            
        } else if (intervalCounter < intervals - 1) {
            Log.d(TAG, "startRoutine: el if");
            exerciseCounter = 0;
            intervalCounter++;
            StartCountdown();
        } else {
            currentActivity.setText("Routine Complete!");
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_time_minus:
                exerciseLength -= 5000;
                activityLengthText.setText(String.valueOf(exerciseLength/1000));
                break;
            case R.id.work_time_plus:
                exerciseLength += 5000;
                activityLengthText.setText(String.valueOf(exerciseLength/1000));
                break;

            case R.id.rest_time_minus:
                restLength -= 1000;
                restLengthText.setText(String.valueOf(restLength/1000));
                break;
            case R.id.rest_time_plus:
                restLength += 1000;
                restLengthText.setText(String.valueOf(restLength/1000));
                break;

            case R.id.intervals_minus:
                intervals -= 1;
                intervalsText.setText(String.valueOf(intervals));
                break;
            case R.id.intervals_plus:
                intervals += 1;
                intervalsText.setText(String.valueOf(intervals));
                break;
            case R.id.start_button:
                startRoutine();
                break;
        }
    }
}