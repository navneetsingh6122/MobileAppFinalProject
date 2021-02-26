package com.example.hiitfit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hiitfit.MessageActivity;
import com.example.hiitfit.Model.Chat;
import com.example.hiitfit.Model.User;
import com.example.hiitfit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.myViewHolder> {
public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;


    private Context mContext;
    private List<Chat> mChat;
private String imageurl;

FirebaseUser firebaseUser;
    public MessageAdapter(Context mContext,List<Chat> mChat, String imageUrl){
        this.mContext = mContext;
        this.mChat = mChat;
        this.imageurl = imageUrl;
    }

    @NonNull
    @Override
    public MessageAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == MSG_TYPE_RIGHT) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false);
            return new MessageAdapter.myViewHolder(v);
        }
        else{
            View v = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false);
            return new MessageAdapter.myViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.myViewHolder holder, int position) {
       Chat chat = mChat.get(position);

       holder.message.setText(chat.getMessage());

    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        public TextView message;
        public ImageView profileImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            message = itemView.findViewById(R.id.show_message);
            profileImage = itemView.findViewById(R.id.profile_image_user);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(mChat.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_TYPE_RIGHT;
        }
        else {
            return MSG_TYPE_LEFT;
        }
    }
}
