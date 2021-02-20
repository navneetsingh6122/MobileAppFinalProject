package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class BMI extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;
    private TextView resultmeaning;
    Button bmicalculate;



    FirebaseAuth fauth;
    FirebaseUser muser;
    String UID;
    FirebaseFirestore fstore;
    CollectionReference mref;
    DocumentReference documentReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
fauth = FirebaseAuth.getInstance();
muser = fauth.getCurrentUser();
UID = muser.getUid();

fstore = FirebaseFirestore.getInstance();
mref = fstore.collection("users");
        setContentView(R.layout.activity_b_m_i);
        height = (EditText) findViewById(R.id.heightinput);
        weight = (EditText) findViewById(R.id.weightInput);
        result = (TextView) findViewById(R.id.imcValue);
        resultmeaning =(TextView) findViewById(R.id.imcViewText);
        bmicalculate = (Button)findViewById(R.id.calculatebmi);

        bmicalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();

                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null  &&  !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);

                    float bmi = weightValue / (heightValue * heightValue);

                    displayBMI(bmi);


                }
            }

            private void displayBMI(float bmi) {
                String bmiLabel = "";

                if (Float.compare(bmi, 15f) <= 0) {
                    bmiLabel = getString(R.string.very_severely_underweight);
                } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
                    bmiLabel = getString(R.string.severely_underweight);
                } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
                    bmiLabel = getString(R.string.underweight);
                } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
                    bmiLabel = getString(R.string.normal);
                } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
                    bmiLabel = getString(R.string.overweight);
                } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
                    bmiLabel = getString(R.string.obese_class_i);
                } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
                    bmiLabel = getString(R.string.obese_class_ii);
                } else {
                    bmiLabel = getString(R.string.obese_class_iii);
                }
                resultmeaning.setText(bmiLabel);

                result.setText(Float.toString(bmi));

documentReference = mref.document(UID);
               Map<String,String>map =new HashMap<>();
               map.put("BMI",bmiLabel);

               documentReference.set(map, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(BMI.this,"Bmi result successfully uploaded",Toast.LENGTH_SHORT).show();
                       }
                   }
               });

            }
        });


    }

}
