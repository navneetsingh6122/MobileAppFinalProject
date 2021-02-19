package com.example.hiitfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ProfileFragment extends Fragment {
    private TextView nameTextView, emailTextView;
    private FirebaseFirestore fstore;
    String userID;
    FirebaseAuth mAuth;
    Button logout, changeprofile;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V= inflater.inflate(R.layout.fragment_profile,container,false);
        nameTextView = (TextView) V.findViewById(R.id.name_textview);
        emailTextView = (TextView) V.findViewById(R.id.email_textview);
        img = (ImageView) V.findViewById(R.id.user_imageView);
        logout = (Button) V.findViewById(R.id.logout_button);
        changeprofile = (Button) V.findViewById(R.id.profile_button);
        fstore=FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();


        fetchdata();
        changeprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(getActivity(), EditProfile.class);
                startActivity(v);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(),"User Logged out Successfully!!!", Toast.LENGTH_SHORT).show();
                Intent v = new Intent(getActivity(), Login.class);
                startActivity(v);
                getActivity().finishAffinity();
            }
        });
        return V ;
    }

    public void fetchdata()
    {
        DocumentReference document = fstore.collection("users").document(userID);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    nameTextView.setText(" " + documentSnapshot.getString("fName"));
                    emailTextView.setText(" " + documentSnapshot.getString("email"));
                    Picasso.get().load(documentSnapshot.getString("ProfileImageUrl")).fit().into(img);
                }
                else {
                    Toast.makeText(getContext(), "row not found", Toast.LENGTH_LONG).show();
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"Failed to fetch data", Toast.LENGTH_LONG).show();
                    }
                });
    }

};


