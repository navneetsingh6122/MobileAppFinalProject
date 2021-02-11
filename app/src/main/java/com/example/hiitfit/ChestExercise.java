package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ChestExercise extends AppCompatActivity {

    private FirebaseFirestore ref = FirebaseFirestore.getInstance();
    private CollectionReference hello = ref.collection("Chest");
    private ShoulderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercise);
setChestRecyclerView();

    }

   private void setChestRecyclerView() {
        Query query = hello.orderBy("Name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<ShoulderModel> options = new FirestoreRecyclerOptions.Builder<ShoulderModel>().
                setQuery(query,ShoulderModel.class).build();

        adapter = new ShoulderAdapter(options);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.chestRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    }
