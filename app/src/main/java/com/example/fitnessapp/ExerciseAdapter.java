package com.example.fitnessapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    public ExerciseAdapter(Activity context, ArrayList<Exercise> exercises) {
        super(context, 0, exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.exercise_list_item, parent, false);
        }

        Exercise currentExercise = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.exercise_name);
        nameTextView.setText(currentExercise.getExerciseName());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.exercise_picture);
        iconView.setImageResource(currentExercise.getImageResourceID());

        return listItemView;
    }
}
