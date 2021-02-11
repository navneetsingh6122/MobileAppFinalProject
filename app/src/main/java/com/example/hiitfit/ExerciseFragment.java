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
    TextView exerciseActivity , chestActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_exercises,container,false);
        exerciseActivity = (TextView)v.findViewById(R.id.shoulder);
        chestActivity = (TextView)v.findViewById(R.id.chest);
        exerciseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShoulderExercise.class);
                startActivity(intent);
            }
        });
chestActivity.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent che = new Intent(getActivity(),ChestExercise.class);
        startActivity(che);
    }
});
        return v;
    }
}
