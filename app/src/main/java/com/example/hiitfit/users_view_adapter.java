package com.example.hiitfit;

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

    }

    @NonNull
    @Override
    public users_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    class users_view_holder extends RecyclerView.ViewHolder{
        TextView textView_title, textView_email, textView_priority;

        public users_view_holder(@NonNull View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.users_view_title);
            textView_email = itemView.findViewById(R.id.users_view_email);
            textView_priority = itemView.findViewById(R.id.users_view_priority);
        }
    }
}
