package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.w3c.dom.Text;

public class ProgressActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference progressRef = db.collection("Progress");
    private ProgressAdapter madapter;
    RecyclerView rc;
    String nameu ;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        rc =  (RecyclerView)findViewById(R.id.progressrc);
        tv = (TextView)findViewById(R.id.name_text_progress_username);
        nameu = getIntent().getExtras().getString("userName");
        tv.setText(nameu + "'s Progress");
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
       // Query query = progressRef.orderBy("DateAndTime",Query.Direction.DESCENDING);
Query query = progressRef.whereEqualTo("Name",nameu).orderBy("DateAndTime",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<ProgressModel> options = new FirestoreRecyclerOptions.Builder<ProgressModel>().setQuery(query,ProgressModel.class).build();
        madapter = new ProgressAdapter(options);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(madapter);
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