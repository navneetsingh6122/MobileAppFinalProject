package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
TextView textForSignUp;
    EditText mEmail, mPassword;
    FirebaseAuth mAuth;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textForSignUp = (TextView)findViewById(R.id.textView_signupActivity);



        mEmail = (EditText)findViewById(R.id.email_login);
        mPassword = (EditText)findViewById(R.id.password_login);
        login =(Button) findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    mPassword.setError("Password id required");
                    return;
                }
                if(Password.length()<6){
                    mPassword.setError("Password should be greater than 6 characters");
                    return;
                }
                mAuth.signInWithEmailAndPassword(Email , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this , "User successfully Logged In" , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent (Login.this, HomeActivity.class);
                            startActivity(intent);

                        }else {
                            Toast.makeText(Login.this , "Error!! :- " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }

        });
        textForSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , Signup.class);
                startActivity(intent);
            }
        });
    }
}