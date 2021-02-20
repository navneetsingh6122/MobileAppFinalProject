package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdminExerciseDiscription extends AppCompatActivity {
    TextView n,i,e;
    GifImageView img;
    String url;
    String s1,s2,s3,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_exercise_discription);
        n = (TextView)findViewById(R.id.admin_description_name);
        i = (TextView)findViewById(R.id.admin_decription_instructions);
        e = (TextView)findViewById(R.id.admin_description_execution);
        img = (GifImageView) findViewById(R.id.admin_description_image);

        s1 = getIntent().getExtras().getString("fullname");
        s2 = getIntent().getExtras().getString("ins");
        s3 = getIntent().getExtras().getString("exe");
        url = getIntent().getStringExtra("img");

        Glide.with(this)
                .load(url)

                //.override(1000, 600)
                .centerCrop()

                .into(img);
        n.setText(s1);
        i.setText(s2);
        e.setText(s3);
    }
}