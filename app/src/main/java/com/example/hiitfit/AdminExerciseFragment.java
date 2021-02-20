package com.example.hiitfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class AdminExerciseFragment extends Fragment {
    TextView exerciseActivity, chestActivity , TrapsActivity,Abductors,Abs,Biceps,Calves,ForeArm,Obliques,Triceps,Quads;

    int nb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exercise_admin, container, false);
        exerciseActivity = (TextView)view.findViewById(R.id.shoulder);
        chestActivity = (TextView)view.findViewById(R.id.chest);
        TrapsActivity = (TextView)view.findViewById(R.id.Traps);
        Abductors = (TextView)view.findViewById(R.id.Abductors);
        Abs = (TextView)view.findViewById(R.id.Abs);
        Biceps = (TextView)view.findViewById(R.id.Biceps);
        Calves = (TextView)view.findViewById(R.id.calves);
        ForeArm = (TextView)view.findViewById(R.id.Forearms);
        Obliques = (TextView)view.findViewById(R.id.Obliques);
        Triceps = (TextView)view.findViewById(R.id.Triceps);
        Quads = (TextView)view.findViewById(R.id.Quads);




        exerciseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(), AdminAddShoulder.class);
                nb=0;
                next.putExtra("ID", nb);

                startActivity(next);
            }
        });

        chestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent (getContext(), AdminAddShoulder.class);
                nb = 1;
                next.putExtra("ID", nb);

                startActivity(next);
            }
        });

        TrapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 2;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });

            Abductors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 3;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });

        Abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 4;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 5;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Calves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 6;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        ForeArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 7;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Obliques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 8;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 9;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        Quads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AdminAddShoulder.class);
                nb = 10;
                intent.putExtra("ID",nb);
                startActivity(intent);
            }
        });
        return view;
    }
}
