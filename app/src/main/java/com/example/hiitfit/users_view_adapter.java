package com.example.hiitfit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class users_view_adapter extends FirestoreRecyclerAdapter<users,users_view_adapter.users_view_holder>{


    public users_view_adapter(@NonNull FirestoreRecyclerOptions<users> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull users_view_holder holder, int position, @NonNull users model) {

        holder.textView_users.setText(model.getfName());
        holder.textView_email.setText(model.getEmail());
        holder.lastname.setText(model.getLastExercise());
        holder.lastdate.setText(model.getLastDate());
    }

    @NonNull
    @Override
    public users_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_item,parent,false);
        return new users_view_holder(v);
    }



    class users_view_holder extends RecyclerView.ViewHolder{
        TextView textView_users, textView_email,lastname,lastdate;

        public users_view_holder(@NonNull View itemView) {
            super(itemView);
            textView_users = itemView.findViewById(R.id.users_view_users);
            textView_email = itemView.findViewById(R.id.users_view_email);
            lastname = itemView.findViewById(R.id.lastActivityDone);
            lastdate = itemView.findViewById(R.id.lastActivityDate);
        }
    }
}
