package com.example.hiitfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExerciseFragment extends Fragment {

    TextView exerciseActivity, chestActivity , TrapsActivity,Abductors,Abs,Biceps,Calves,ForeArm,Obliques,Triceps,Quads;
int nb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_exercises,container,false);
        exerciseActivity = (TextView)v.findViewById(R.id.shoulder_u);
        chestActivity = (TextView)v.findViewById(R.id.chest_u);
        TrapsActivity = (TextView)v.findViewById(R.id.Traps_u);
        Abductors = (TextView)v.findViewById(R.id.Abductors_u);
        Abs = (TextView)v.findViewById(R.id.Abs_u);
        Biceps = (TextView)v.findViewById(R.id.Biceps_u);
        Calves = (TextView)v.findViewById(R.id.calves_u);
        ForeArm = (TextView)v.findViewById(R.id.Forearms_u);
        Obliques = (TextView)v.findViewById(R.id.Obliques_u);
        Triceps = (TextView)v.findViewById(R.id.Triceps_u);
        Quads = (TextView)v.findViewById(R.id.Quads_u);

        exerciseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShoulderExercise.class);
                nb = 0;
                intent.putExtra("ID", nb);
                startActivity(intent);
            }
        });
   chestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent (getActivity(), ShoulderExercise.class);
                nb = 1;
                next.putExtra("ID", nb);

                startActivity(next);
            }
        });


        TrapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 2;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });

        Abductors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 3;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });

        Abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 4;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 5;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Calves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 6;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        ForeArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 7;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Obliques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 8;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 9;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Quads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 10;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        return v;
    }
}
