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
int number;
String Exercise;
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
   number = getIntent().getExtras().getInt("ID");


        name = (EditText)findViewById(R.id.editText_name);
        instruction = (EditText)findViewById(R.id.editText_Instructions);
        execution = (EditText)findViewById(R.id.editText_execution);
view = (TextView)findViewById(R.id.text_getString);
        chooseImage = (Button)findViewById(R.id.button_imagechoose);
        fstore = FirebaseFirestore.getInstance();
        add = (Button)findViewById(R.id.button_AddExercise);

        switch(number){
            case(0):view.setText("Click here to see shoulder exercises");
    Exercise = "Shoulder";
            break;
            case(1):view.setText("Click here to see Chest exercises");
    Exercise = "Chest";
                break;
            case(2):view.setText("Click here to see Traps exercises");
    Exercise = "Traps";
                break;
            case(3):view.setText("Click here to see Abductors exercises");
    Exercise = "Abductors";
                break;
            case(4):view.setText("Click here to see Abs exercises");
    Exercise = "Abs";
                break;
            case(5):view.setText("Click here to see Biceps exercises");
    Exercise = "Biceps";
                break;
            case(6):view.setText("Click here to see Calves exercises");
    Exercise = "Calves";
                break;
            case(7):view.setText("Click here to see ForeArms exercises");
    Exercise = "ForeArms";
                break;
            case(8):view.setText("Click here to see Obliques exercises");
    Exercise = "Obliques";
                break;
            case(9):view.setText("Click here to see Triceps exercises");
    Exercise = "Triceps";
                break;
            case(10):view.setText("Click here to see Quads exercises");
    Exercise = "Quads";
                break;

        }





     /*

if(number == 0){
    view.setText("Click here to see shoulder exercises");
    Exercise = "Shoulder";
}else if(number == 1){
    Exercise = "Chest";
    view.setText("Click here to see Chest exercises");

}else if(number == 2){
    Exercise = "Traps";
    view.setText("Click here to see Traps exercises");

}*/
view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        switch (number){

            case(0):Intent ExShoulder = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExShoulder.putExtra("ID", number);
                startActivity(ExShoulder);
                break;
            case(1):Intent ExChest = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExChest.putExtra("ID", number);
                startActivity(ExChest);
                break;
            case(2):Intent ExTraps = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            ExTraps.putExtra("ID", number);
            startActivity(ExTraps);
                break;
            case(3):Intent ExAbductors = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            ExAbductors.putExtra("ID", number);
            startActivity(ExAbductors);
                break;
            case(4):Intent ExAbs = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            ExAbs.putExtra("ID", number);
            startActivity(ExAbs);
                break;
            case(5):Intent ExBiceps = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            ExBiceps.putExtra("ID", number);
            startActivity(ExBiceps);
                break;
            case(6):Intent ExCalves = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExCalves.putExtra("ID", number);
                startActivity(ExCalves);
                break;
            case(7):Intent ExForearms = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExForearms.putExtra("ID", number);
                startActivity(ExForearms);
                break;
            case(8):Intent ExObliques = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExObliques.putExtra("ID", number);
                startActivity(ExObliques);
                break;
            case(9):Intent ExTriceps = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExTriceps.putExtra("ID", number);
                startActivity(ExTriceps);
                break;
            case(10):Intent ExQuads = new Intent(AdminAddShoulder.this, AdminShoulder.class);
                ExQuads.putExtra("ID", number);
                startActivity(ExQuads);
                break;
        }

        /*
        if(number==0) {
            Intent intent = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            intent.putExtra("ID", number);
            startActivity(intent);
        }else if(number==1){

            Intent intent = new Intent(AdminAddShoulder.this, AdminChest.class);
            startActivity(intent);
        }if(number==2) {
            Intent intent = new Intent(AdminAddShoulder.this, AdminShoulder.class);
            intent.putExtra("ID", number);
            startActivity(intent);
        }*/
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

                fstore.collection(Exercise).add(exercise).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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