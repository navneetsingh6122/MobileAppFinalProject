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
import com.example.hiitfit.Model.User;
import com.example.hiitfit.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.myViewHolder> {

    private Context mContext;
    private List<User> mUser;

    public UserAdapter(Context mContext,List<User> mUser){
        this.mContext = mContext;
        this.mUser = mUser;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.user_chat_item,parent,false);
        return new UserAdapter.myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
User user = mUser.get(position);
holder.username.setText(user.getfName());
if(user.getProfileImageUrl().equals("")){
    holder.profileImage.setImageResource(R.drawable.ic_launcher);
}
else {
    Glide.with(mContext).load(user.getProfileImageUrl()).into(holder.profileImage);
}
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, MessageActivity.class);
        intent.putExtra("userId", user.getId());
        mContext.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

public TextView username;
public ImageView profileImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.userlist_username);
            profileImage = itemView.findViewById(R.id.profile_image_user);
        }
    }

}
