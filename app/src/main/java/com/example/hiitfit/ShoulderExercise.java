package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShoulderExercise extends AppCompatActivity {
/*RecyclerView sh;
ArrayList<ShoulderModel> detailList;
FirebaseFirestore db;
ShoulderAdapter madapter;*/
private FirebaseFirestore db = FirebaseFirestore.getInstance();
private CollectionReference exerciseref;
String Category;
private ShoulderAdapter madapter;
int number;
TextView ExerciseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_exercise);
        ExerciseName = (TextView)findViewById(R.id.user_exercise_name);
        number = getIntent().getExtras().getInt("ID");


        switch(number){
            case(0):exerciseref = db.collection("Shoulder");
                ExerciseName.setText("Shoulder");
                break;
            case(1):exerciseref = db.collection("Chest");
                ExerciseName.setText("Chest");
                break;
            case(2):exerciseref = db.collection("Traps");
                ExerciseName.setText("Traps");
                break;
            case(3):exerciseref = db.collection("Abductors");
                ExerciseName.setText("Abductors");
                break;
            case(4):exerciseref = db.collection("Abs");
                ExerciseName.setText("Abs");
                break;
            case(5):exerciseref = db.collection("Biceps");
                ExerciseName.setText("Biceps");
                break;
            case(6):exerciseref = db.collection("Calves");
                ExerciseName.setText("Calves");
                break;
            case(7):exerciseref = db.collection("ForeArms");
                ExerciseName.setText("ForeArms");
                break;
            case(8):exerciseref = db.collection("Obliques");
                ExerciseName.setText("Obliques");
                break;
            case(9):exerciseref = db.collection("Triceps");
                ExerciseName.setText("Triceps");
                break;
            case(10):exerciseref = db.collection("Quads");
                ExerciseName.setText("Quads");
                break;

        }



        // exerciseRef =  db.collection("Shoulder");
        setUpRecyclerView();



    }



    private void setUpRecyclerView() {
        Query query = exerciseref.orderBy("Name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<ShoulderModel> options = new FirestoreRecyclerOptions.Builder<ShoulderModel>().
                setQuery(query,ShoulderModel.class).build();

        madapter = new ShoulderAdapter(options);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.Shoulderrecycler);
        recyclerView.setHasFixedSize(true);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(madapter);*/
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(madapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        madapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        madapter.stopListening();
    }
}