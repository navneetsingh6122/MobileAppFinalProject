package com.example.hiitfit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UsersForProgress extends Fragment {
private UsersProgressAdapter madapter;
private FirebaseFirestore db = FirebaseFirestore.getInstance();
private CollectionReference mref = db.collection("users");
private RecyclerView rc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress,container,false);
        rc =  v.findViewById(R.id.ProgressRecycler);
        setUpRecyclerView();

        return v;
    }

    private void setUpRecyclerView() {

        Query query = mref.orderBy("fName",Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<UsersModel> options = new FirestoreRecyclerOptions.Builder<UsersModel>().setQuery(query,UsersModel.class).build();
        madapter = new UsersProgressAdapter(options);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        rc.setAdapter(madapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        madapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        madapter.stopListening();
    }
}
