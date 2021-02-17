package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_admin_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminExerciseFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.navigation_admin_exercises:
                    selectedFragment = new AdminExerciseFragment();
                    break;
                case R.id.navigation_admin_help:
                    selectedFragment = new AdminHelpFragment();
                    break;
                case R.id.navigation_admin_profile:
                    selectedFragment = new AdminProfileFragment();
                    break;
                case R.id.navigation_admin_progress:
                    selectedFragment = new UsersForProgress();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };}