package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class ShoulderDescription extends AppCompatActivity {
TextView n,i,e;
String s1,s2,s3,category;
GifImageView img;
String url;
Button Timer,Progress;
Picasso p;
private FirebaseAuth fauth;
String UserId;
private FirebaseFirestore db = FirebaseFirestore.getInstance();
private CollectionReference userref = db.collection("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_description);
fauth = FirebaseAuth.getInstance();
UserId = fauth.getCurrentUser().getUid();
        n = (TextView)findViewById(R.id.tv_name);
        i = (TextView)findViewById(R.id.tv_instructions);
        e = (TextView)findViewById(R.id.tv_execution);
        img = (GifImageView) findViewById(R.id.img_ex);
        Timer = (Button)findViewById(R.id.button_timer);
Progress = (Button)findViewById(R.id.button_progress);
        s1 = getIntent().getExtras().getString("fullname");
        s2 = getIntent().getExtras().getString("ins");
        s3 = getIntent().getExtras().getString("exe");
        category = getIntent().getExtras().getString("category");
url = getIntent().getStringExtra("img");
//Picasso.get().load(url).fit().into(img);
        Glide.with(this)
                .load(url)

                //.override(1000, 600)
                .centerCrop()

                .into(img);
        n.setText(s1);
        i.setText(s2);
        e.setText(s3);

        Progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference doc = userref.document(UserId);
                doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists())
                        {
                            String uName = documentSnapshot.getString("fName");
                            Intent i = new Intent(ShoulderDescription.this, ProgressActivity.class);
                            i.putExtra("userName",uName);
                            startActivity(i);
                        }
                else {
                            Toast.makeText(ShoulderDescription.this, "row not found", Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

            }
        });
        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShoulderDescription.this, TimerActivity.class);
                i.putExtra("Name", s1);
                i.putExtra("Execution",s3);
                i.putExtra("category",category);
                startActivity(i);
            }
        });
    }
}