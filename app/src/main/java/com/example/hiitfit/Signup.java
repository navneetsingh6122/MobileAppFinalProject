package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    TextView textForLogin;
    EditText mName,mEmail, mPassword;
    FirebaseAuth mAuth;
    Button register;
    FirebaseFirestore fstore;
    String userID;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textForLogin = (TextView)findViewById(R.id.textView_LoginActivity);
        mName = (EditText)findViewById(R.id.name_signup);
        mEmail = (EditText)findViewById(R.id.email_signup);
        mPassword = (EditText)findViewById(R.id.password_signup);
        register =(Button) findViewById(R.id.button_signup);
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String fullName = mName.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password id required");
                    return;
                }
                if(password.length()<6){
                    mPassword.setError("Password should be greater than 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this , "User created" , Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName", fullName);
                            user.put("email", email);
                            // specifying user as a user not as an admin
                            user.put("isUser","0");

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user profile is created for" + userID);
                                }
                            });
                          ref = FirebaseDatabase.getInstance().getReference("users").child(userID);
                          HashMap<String,String> hash = new HashMap<>();
                          hash.put("id",userID);
                            hash.put("fName", fullName);
                            hash.put("email", email);
                            hash.put("isUser","0");
                            hash.put("profileImageUrl","");
                            ref.setValue(hash).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Signup.this,"User data successfully stored in database",Toast.LENGTH_SHORT).show();

                                    }
                                    else{
                                        Toast.makeText(Signup.this,"Error:-" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                            Intent intent = new Intent (Signup.this, Login.class);
                            startActivity(intent);

                        }else {
                            Toast.makeText(Signup.this , "Error!! :-" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        textForLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }


        });
    }
}