package com.example.hiitfit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
EditText search;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress,container,false);
        rc =  v.findViewById(R.id.ProgressRecycler);
        search =(EditText)v.findViewById(R.id.editText_searchName);
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


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               Query query;
               if(s.toString().isEmpty()){
                   query = mref.orderBy("fName",Query.Direction.ASCENDING);

               }else{
                   query = mref.orderBy("fName",Query.Direction.ASCENDING).startAt(s.toString()).endAt(s.toString()+"\uf8ff");
               }

                FirestoreRecyclerOptions<UsersModel> options = new FirestoreRecyclerOptions.Builder<UsersModel>()
                        .setQuery(query,UsersModel.class).build();
               madapter.updateOptions(options);
            }
        });
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
