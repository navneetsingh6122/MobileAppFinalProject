package com.example.hiitfit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdminAdapter extends FirestoreRecyclerAdapter<AdminModel, AdminAdapter.myViewHolder> {


    public AdminAdapter(@NonNull FirestoreRecyclerOptions<AdminModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull AdminModel model) {
        holder.textView.setText(model.getName());
        Picasso.get().load(model.getImageUrl()).into(holder.img);
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
ImageView img, imgdel;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.name);
        img = itemView.findViewById(R.id.image_admin_exercise);
        imgdel = itemView.findViewById(R.id.delete_img);
    }
}
}
