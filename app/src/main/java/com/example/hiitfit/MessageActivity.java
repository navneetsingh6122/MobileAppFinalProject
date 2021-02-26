package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hiitfit.Adapter.MessageAdapter;
import com.example.hiitfit.Model.Chat;
import com.example.hiitfit.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageActivity extends AppCompatActivity {
CircleImageView messageprofile;
TextView username;
FirebaseUser firebaseUser;
DatabaseReference reference;
Intent intent;


ImageButton btn_send;
EditText text_send;

MessageAdapter messageAdapter;
List<Chat> mChat;
RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

       /* Toolbar toolbar = findViewById(R.id.toolbar_chat);
        if(toolbar!=null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
*/

        rc = findViewById(R.id.message_recyclerView);
        rc.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MessageActivity.this);
        linearLayoutManager.setStackFromEnd(true);
        rc.setLayoutManager(linearLayoutManager);

        username = findViewById(R.id.chat_userName);
        messageprofile = findViewById(R.id.chat_profile_image);
        btn_send = findViewById(R.id.button_message_send);
        text_send = findViewById(R.id.text_message_send);

        intent = getIntent();
        String userId = intent.getStringExtra("userId");
btn_send.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String msg = text_send.getText().toString().trim();
        if(!msg.equals("")){
            sendMessage(firebaseUser.getUid(),userId,msg);
        }

        else{
            Toast.makeText(MessageActivity.this,"You cannot send empty message",Toast.LENGTH_SHORT).show();
        }
        text_send.setText("");
    }
});
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users").child(userId);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                username.setText(user.getfName());
                if(user.getProfileImageUrl().equals("")){
                  messageprofile.setImageResource(R.drawable.ic_launcher);
                }
                else {
                        Glide.with(MessageActivity.this).load(user.getProfileImageUrl()).into(messageprofile);
                }
                readMessage(firebaseUser.getUid(),userId,user.getProfileImageUrl());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void sendMessage(String sender,String receiver,String message){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("sender",sender);
        hashMap.put("receiver",receiver);
        hashMap.put("message",message);

        reference.child("Chats").push().setValue(hashMap);

    }

    private void readMessage(String myid,String userid,String imageurl ){
        mChat = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mChat.clear();

                for(DataSnapshot snap:snapshot.getChildren()){
                    Chat chat = snap.getValue(Chat.class);
                    if(chat.getReceiver().equals(myid) && chat.getSender().equals(userid)  || chat.getReceiver().equals(userid) && chat.getSender().equals(myid)){
                        mChat.add(chat);
                    }


                }
                messageAdapter  = new MessageAdapter(MessageActivity.this,mChat,imageurl);
                rc.setAdapter(messageAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}