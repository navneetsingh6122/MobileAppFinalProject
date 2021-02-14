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
String Category;
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
                Category = "Shoulder";
                intent.putExtra("ID", nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
   chestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent (getActivity(), ShoulderExercise.class);
                nb = 1;
                Category = "Chest";
                next.putExtra("ID", nb);
                next.putExtra("exercisecat",Category);
                startActivity(next);
            }
        });


        TrapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 2;
                Category = "Traps";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });

        Abductors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 3;
                Category = "Abductors";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });

        Abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 4;
                Category = "Abs";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        Biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 5;
                Category = "Biceps";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        Calves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 6;
                Category = "Calves";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        ForeArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 7;
                Category = "ForeArms";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        Obliques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 8;
                Category = "Obliques";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        Triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 9;
                Category = "Triceps";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        Quads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoulderExercise.class);
                nb = 10;
                Category = "Quads";
                intent.putExtra("ID",nb);
                intent.putExtra("exercisecat",Category);
                startActivity(intent);
            }
        });
        return v;
    }
}
