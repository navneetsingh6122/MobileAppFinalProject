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

public class Signup extends AppCompatActivity {
TextView textForLogin;
EditText mName,mEmail, mPassword;
FirebaseAuth mAuth;
Button register;
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

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