package com.example.hiitfit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AdminProfileFragment extends Fragment {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private CollectionReference usersRef = db.collection("users");
    private RecyclerView recyclerView;

    private  users_view_adapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V= inflater.inflate(R.layout.fragment_profile_admin, container, false);

        recyclerView = V.findViewById(R.id.view_users_recyclerview);
        setUpRecyclerView();
        return V;
    }

    private void setUpRecyclerView()
    {
        Query query = usersRef.orderBy("LastDate", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<users> options = new FirestoreRecyclerOptions.Builder<users>().setQuery(query,users.class).build();
        adapter = new users_view_adapter(options);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);


    }



    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
