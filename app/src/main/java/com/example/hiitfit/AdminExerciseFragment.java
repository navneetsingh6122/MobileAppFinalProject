package com.example.hiitfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdminExerciseFragment extends Fragment {
    TextView exerciseActivity, chestActivity;
    int nb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exercise_admin, container, false);
        exerciseActivity = (TextView)view.findViewById(R.id.shoulder);
        chestActivity = (TextView)view.findViewById(R.id.chest);

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
        return view;
    }
}
