package com.example.hiitfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class AdminHelpFragment extends Fragment {
    Button chat,bmi;
    Button logout_admin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admin_help,container,false);
        chat = (Button)v.findViewById(R.id.button_admin_chat);
        bmi = (Button)v.findViewById(R.id.button_admin_bmi);
        logout_admin = (Button) v.findViewById(R.id.logout_admin);

        logout_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(),"Admin Logged out Successfully!!!", Toast.LENGTH_SHORT).show();
                Intent v = new Intent(getActivity(), Login.class);
                startActivity(v);
                getActivity().finishAffinity();
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i = new Intent(getActivity(),ChatActivity.class);
startActivity(i);
            }
        });


        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }
}
