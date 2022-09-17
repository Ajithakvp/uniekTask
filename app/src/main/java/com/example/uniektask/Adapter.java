package com.example.uniektask;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Activity activity;
   // DbHelper DB;
   // Cursor cursor=DB.getdata();
 private ArrayList tvName,tvPhone;

    public Adapter(Activity activity, ArrayList tvName, ArrayList tvPhone) {
        this.activity = activity;
        this.tvName = tvName;
        this.tvPhone = tvPhone;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appbar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.tvName.setText(String.valueOf(tvName.get(position)));
        holder.tvPhone.setText(String.valueOf(tvPhone.get(position)));




    }

    @Override
    public int getItemCount() {
        return tvName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvPhone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvPhone=itemView.findViewById(R.id.tvPhone);


        }
    }
}
