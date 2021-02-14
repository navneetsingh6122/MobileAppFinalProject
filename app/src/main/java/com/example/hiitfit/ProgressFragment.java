package com.example.hiitfit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ProgressFragment extends Fragment {

private FirebaseFirestore db = FirebaseFirestore.getInstance();
private CollectionReference progressRef = db.collection("Progress");
private ProgressAdapter madapter;
    RecyclerView rc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View v = inflater.inflate(R.layout.fragment_progress,container,false);
      rc =  v.findViewById(R.id.ProgressRecycler);
      setUpRecyclerView();
        return v;
    }

    private void setUpRecyclerView() {
        Query query = progressRef.orderBy("DateAndTime",Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<ProgressModel> options = new FirestoreRecyclerOptions.Builder<ProgressModel>().setQuery(query,ProgressModel.class).build();
   madapter = new ProgressAdapter(options);
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
