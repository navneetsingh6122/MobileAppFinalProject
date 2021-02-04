package com.example.hiitfit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShoulderAdapter extends RecyclerView.Adapter<ShoulderAdapter.myViewHolder> {
Context mcontext;
ArrayList<ShoulderModel> datalist;

    public ShoulderAdapter(Context mcontext, ArrayList<ShoulderModel> datalist) {
        this.mcontext = mcontext;
        this.datalist = datalist;
    }

    public ShoulderAdapter(ArrayList<ShoulderModel> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoulder,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.T1.setText(datalist.get(position).getName());
       // holder.T2.setText(datalist.get(position).getExecution());
       // holder.T3.setText(datalist.get(position).getExecution());
        Picasso.get().load(datalist.get(position).getImageUrl()).into(holder.img);
holder.cd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(holder.cd.getContext(), ShoulderDescription.class);
        intent.putExtra("fullname", datalist.get(position).getName());
        intent.putExtra("ins",datalist.get(position).getInstructions());
        intent.putExtra("exe",datalist.get(position).getExecution());
        intent.putExtra("img",datalist.get(position).getImageUrl());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        holder.cd.getContext().startActivity(intent);
    }
});/*
       holder.T1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(holder.T1.getContext(),ShoulderDescription.class);
               holder.
           }
       }); */
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
ImageView img;
TextView T1,T2,T3;
CardView cd;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);
            T1 = itemView.findViewById(R.id.t1);
           // T2 = itemView.findViewById(R.id.t2);
            //T3 = itemView.findViewById(R.id.t3);
cd = itemView.findViewById(R.id.cardv);
        }
    }

}
