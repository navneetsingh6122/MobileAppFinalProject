package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShoulderDescription extends AppCompatActivity {
TextView n,i,e;
String s1,s2,s3;
ImageView img;
String url;
Picasso p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_description);

        n = (TextView)findViewById(R.id.tv_name);
        i = (TextView)findViewById(R.id.tv_Instruction);
        e = (TextView)findViewById(R.id.tv_execution);
        img = (ImageView)findViewById(R.id.img_ex);

        s1 = getIntent().getExtras().getString("fullname");
        s2 = getIntent().getExtras().getString("ins");
        s3 = getIntent().getExtras().getString("exe");
url = getIntent().getStringExtra("img");
Picasso.get().load(url).into(img);

        n.setText(s1);
        i.setText(s2);
        e.setText(s3);
    }
}