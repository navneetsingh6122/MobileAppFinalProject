package com.example.hiitfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelpFragment extends Fragment {
Button bmi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.fragment_help,container,false);
        bmi = (Button)v.findViewById(R.id.button_bmi);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getActivity(),BMI.class);
                startActivity(b);
            }
        });
return v;
    }
}
