package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
TextView textForSignUp;
    EditText mEmail, mPassword;
    FirebaseAuth mAuth;
    Button login;
    TextView forget_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textForSignUp = (TextView)findViewById(R.id.textView_signupActivity);



        mEmail = (EditText)findViewById(R.id.email_login);
        mPassword = (EditText)findViewById(R.id.password_login);
        login =(Button) findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        forget_password = (TextView) findViewById(R.id.forgot_password);


        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter Your Email to Receive Reset Link");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this,"Reset Link Sent To Your Email",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,"Error! Reset Link is Not Sent" + e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                passwordResetDialog.create().show();
            }
        });
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
                        if(Email.equals("ad") && Password.equals("admin123")){
                            Intent i = new Intent(Login.this, AdminHome.class);
                            startActivity(i);
                        }
                        else if(task.isSuccessful()){
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