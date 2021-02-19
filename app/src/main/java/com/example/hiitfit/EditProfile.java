package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class EditProfile extends AppCompatActivity {

    private static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    private TextView emailTextView, nameTextView;
    ImageView userImageView;
    private FirebaseFirestore fstore;
    String userID;
    FirebaseAuth mAuth;
    Button save_button, photo_button, gallery_button;

    private static final int pick = 3;
    public Uri image;
    String imageurl;
    private FirebaseStorage storage;
    private StorageReference str;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nameTextView = findViewById(R.id.name_textview2);
        emailTextView = findViewById(R.id.email_textview2);
        userImageView = findViewById(R.id.user_imageView2);
        fstore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        photo_button = findViewById(R.id.photo_button);
        save_button = findViewById(R.id.save_button);
        gallery_button = findViewById(R.id.gallery_button);
        storage = FirebaseStorage.getInstance();
        str = storage.getReference();
        fetchdata();

        gallery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(gallery, pick);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> users = new HashMap<>();
                users.put("ProfileImageUrl",imageurl);
                DocumentReference document = fstore.collection("users").document(userID);
document.set(users, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){
            Toast.makeText(EditProfile.this,"Image successfully Uploaded",Toast.LENGTH_SHORT).show();


        }
        else{
            Toast.makeText(EditProfile.this,"Image uploading failed",Toast.LENGTH_SHORT).show();

        }
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(EditProfile.this,"Something went Wrong",Toast.LENGTH_SHORT).show();

    }
});
            }
        });
    }


    public void fetchdata() {
        DocumentReference document = fstore.collection("users").document(userID);
        document.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                nameTextView.setText(documentSnapshot.getString("fName"));
                emailTextView.setText(documentSnapshot.getString("email"));
                Picasso.get().load(documentSnapshot.getString("ProfileImageUrl")).fit().into(userImageView);

            } else {
                Toast.makeText(getApplicationContext(), "Row not found", Toast.LENGTH_LONG).show();
            }
        })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to fetch data", Toast.LENGTH_LONG).show());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pick && resultCode == RESULT_OK && data != null) {
            image = data.getData();
            final String randomKey = UUID.randomUUID().toString();
                StorageReference ref = str.child("ProfilePic/" + randomKey);
            ref.putFile(image).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    task.getResult().getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            imageurl = uri.toString();

                            // get.setText(imageurl);
                        }
                    });
                }
            });

        }
    }
}