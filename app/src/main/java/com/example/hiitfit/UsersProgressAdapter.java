package com.example.hiitfit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UsersProgressAdapter extends FirestoreRecyclerAdapter<UsersModel,UsersProgressAdapter.myViewHolder> {

    public UsersProgressAdapter(@NonNull FirestoreRecyclerOptions<UsersModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull UsersModel model) {
        holder.name.setText(model.getfName());
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.cd.getContext(),ProgressActivity.class);
                i.putExtra("userName",model.getfName());
                holder.cd.getContext().startActivity(i);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_cardview,parent,false);
        return new myViewHolder(v);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
TextView name;
CardView cd;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.admin_view_user_progress);
            cd = itemView.findViewById(R.id.user_cardview);
        }
    }
}
