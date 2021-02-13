package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AdminShoulder extends AppCompatActivity {
    int number;
   private FirebaseFirestore db = FirebaseFirestore.getInstance();

   private CollectionReference exerciseref;

   private AdminAdapter adapter;

TextView ExerciseName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoulder);
        ExerciseName = (TextView)findViewById(R.id.TextView_Admin_Shoulder);
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



setUpRecyclerView();



        }

    private void setUpRecyclerView() {
        Query query = exerciseref.orderBy("Name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<AdminModel> options = new FirestoreRecyclerOptions.Builder<AdminModel>().setQuery(query,AdminModel.class).build();


        adapter = new AdminAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.adminShoulderRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
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