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
Button bmi,chat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.fragment_help,container,false);
        bmi = (Button)v.findViewById(R.id.button_bmi);
        chat = (Button)v.findViewById(R.id.user_helpFrag_chat);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getActivity(),BMI.class);
                startActivity(b);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ChatActivity.class);
                startActivity(i);
            }
        });
return v;
    }
}
