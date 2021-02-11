package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdminAddShoulder extends AppCompatActivity {
TextView view;
    EditText name;
    EditText instruction;
    EditText execution;
    String imageurl;
public Uri image;
    Button add,chooseImage;
 private FirebaseStorage storage;
    private StorageReference str;
    FirebaseFirestore fstore;
    private static final int pick = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_shoulder);
        storage = FirebaseStorage.getInstance();
        str = storage.getReference();



        name = (EditText)findViewById(R.id.editText_name);
        instruction = (EditText)findViewById(R.id.editText_Instructions);
        execution = (EditText)findViewById(R.id.editText_execution);
view = (TextView)findViewById(R.id.text_getString);
        chooseImage = (Button)findViewById(R.id.button_imagechoose);
        fstore = FirebaseFirestore.getInstance();
        add = (Button)findViewById(R.id.button_AddExercise);

view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AdminAddShoulder.this, AdminShoulder.class);
        startActivity(intent);
    }
});
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent gallery = new Intent();
                    gallery.setType("image/*");
                    gallery.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(gallery,pick);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString().trim();
                String Instructions = instruction.getText().toString().trim();
                String Execution = execution.getText().toString().trim();


                Map<String,String> exercise = new HashMap<>();
                exercise.put("Name", Name);
                exercise.put("Instructions", Instructions);
                exercise.put("Execution", Execution);
                exercise.put("ImageUrl", imageurl);

                fstore.collection("Abs").add(exercise).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AdminAddShoulder.this, "Exercise added to firestore ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AdminAddShoulder.this,"Error: " + e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==pick && resultCode ==RESULT_OK && data!=null ){
             image = data.getData();

final String randomKey = UUID.randomUUID().toString();
StorageReference ref = str.child("Image/" + randomKey);
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