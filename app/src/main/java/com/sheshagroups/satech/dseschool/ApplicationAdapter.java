package com.sheshagroups.satech.dseschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.MyViewHolder> {
    private ArrayList<ApplicationData> dataList;
    private Context context;
    public ApplicationAdapter(ArrayList<ApplicationData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.application_layout,parent,false);
        return new ApplicationAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getApplicationURL()).into(holder.recyclerImage);
        holder.recyclerCaption.setText(dataList.get(position).getStudentcaption());
        holder.card.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_1));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView recyclerImage;
        TextView recyclerCaption;
        CardView card;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerImage = itemView.findViewById(R.id.recyclerImage1);
            recyclerCaption = itemView.findViewById(R.id.recyclerCaption1);
            card=itemView.findViewById(R.id.image_view1);
        }
    }
}
