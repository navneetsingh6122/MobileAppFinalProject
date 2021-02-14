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

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShoulderAdapter extends FirestoreRecyclerAdapter<ShoulderModel,ShoulderAdapter.myViewHolder> {

    public ShoulderAdapter(@NonNull FirestoreRecyclerOptions<ShoulderModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ShoulderModel model) {
        holder.T1.setText(model.getName());
        Picasso.get().load(model.getImageUrl()).fit().into(holder.img);

        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.cd.getContext(), ShoulderDescription.class);
                intent.putExtra("fullname", model.getName());
                intent.putExtra("ins",model.getInstructions());
                intent.putExtra("exe",model.getExecution());
intent.putExtra("category",model.getCategory());
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
      /*  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoulder,parent,false);
        return new myViewHolder(view);*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewgridlayout,parent,false);
        return new myViewHolder(view);


    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView T1,T2,T3;
        CardView cd;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

          /*  img = itemView.findViewById(R.id.image_admin_exercise);
            T1 = itemView.findViewById(R.id.name);


            // T2 = itemView.findViewById(R.id.t2);
            //T3 = itemView.findViewById(R.id.t3);
            cd = itemView.findViewById(R.id.cardv);*/

            img = itemView.findViewById(R.id.imageView_grid);
            T1 = itemView.findViewById(R.id.textView_grid);


            // T2 = itemView.findViewById(R.id.t2);
            //T3 = itemView.findViewById(R.id.t3);
            cd = itemView.findViewById(R.id.cardview_grid);
        }
    }


}
