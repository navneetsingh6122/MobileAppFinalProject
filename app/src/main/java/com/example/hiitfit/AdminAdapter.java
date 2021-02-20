package com.example.hiitfit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import pl.droidsonroids.gif.GifImageView;

public class AdminAdapter extends FirestoreRecyclerAdapter<AdminModel, AdminAdapter.myViewHolder> {


    public AdminAdapter(@NonNull FirestoreRecyclerOptions<AdminModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull AdminModel model) {
        holder.textView.setText(model.getName());
       Picasso.get().load(model.getImageUrl()).fit().into(holder.img);

        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.cd.getContext(), AdminExerciseDiscription.class);
                intent.putExtra("fullname", model.getName());
                intent.putExtra("ins",model.getInstructions());
                intent.putExtra("exe",model.getExecution());
                intent.putExtra("img",model
                        .getImageUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.cd.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.admincardview,parent,false);
        return new myViewHolder(v);
    }
public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
}
    class myViewHolder extends RecyclerView.ViewHolder{
TextView textView;
GifImageView img, imgdel;
CardView cd;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.name);
        img = itemView.findViewById(R.id.image_admin_exercise);

        cd = itemView.findViewById(R.id.cardv);
    }
}
}
