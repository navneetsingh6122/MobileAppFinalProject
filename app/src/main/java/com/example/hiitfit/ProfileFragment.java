package com.example.hiitfit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    Button logout, changeprofile, deleteaccount;
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
        deleteaccount = (Button) V.findViewById(R.id.delete_button);
        fstore=FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();

        final FirebaseUser user = mAuth.getCurrentUser();

        deleteaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Are you sure?");
                dialog.setMessage("Delete this account will result in completely removing your account from the system and you won't be" +
                        "able to access the app.");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(),"Account is deleted", Toast.LENGTH_LONG).show();
                                    Intent v = new Intent(getActivity(), Login.class);
                                    startActivity(v);
                                    getActivity().finishAffinity();
                                }
                                else{
                                    Toast.makeText(getActivity(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
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


