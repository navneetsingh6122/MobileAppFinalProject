package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShoulderExercise extends AppCompatActivity {
RecyclerView sh;
ArrayList<ShoulderModel> detailList;
FirebaseFirestore db;
ShoulderAdapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercise);

        sh = (RecyclerView)findViewById(R.id.Shoulderrecycler);
        sh.setLayoutManager(new LinearLayoutManager(this));

        detailList = new ArrayList<>();
        madapter = new ShoulderAdapter(detailList);
        sh.setAdapter(madapter);
        db = FirebaseFirestore.getInstance();

        db.collection("Shoulder").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                List<DocumentSnapshot> list = documentSnapshots.getDocuments();
                for(DocumentSnapshot d:list){
                    ShoulderModel obj = d.toObject(ShoulderModel.class);
                    detailList.add(obj);
                }

                //update adapter
                madapter.notifyDataSetChanged();
            }
        });

    }
}