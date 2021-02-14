package com.example.hiitfit;

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

public class ProgressAdapter extends FirestoreRecyclerAdapter<ProgressModel,ProgressAdapter.myViewHolder> {




    public ProgressAdapter(@NonNull FirestoreRecyclerOptions<ProgressModel> options) {
        super(options);
    }




    @NonNull
    @Override
    public ProgressAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_progress,parent,false);
        return new ProgressAdapter.myViewHolder(view);


    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ProgressModel model) {
        holder.Tn.setText(model.getName());
        holder.Tec.setText(model.getCategory());
        holder.Ten.setText(model.getExerciseName());
        holder.Ted.setText(model.getDuration());
        holder.Tedate.setText(model.getDateAndTime());

    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView Tn,Tec,Ten,Ted,Tedate;
        CardView cd;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
Tn = itemView.findViewById(R.id.textView_userName);
            Tec = itemView.findViewById(R.id.textView_exerciseCategory);
            Ten = itemView.findViewById(R.id.textView_exerciseName);
            Ted = itemView.findViewById(R.id.textView_exerciseDuration);
            Tedate = itemView.findViewById(R.id.textView_exerciseDate);

        }
    }

}
