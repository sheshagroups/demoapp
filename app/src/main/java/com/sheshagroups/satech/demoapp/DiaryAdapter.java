package com.sheshagroups.satech.demoapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.TextAttribute;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {

    private ArrayList<DiaryData> dataList;
    private Context context;

    public DiaryAdapter(ArrayList<DiaryData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getImageURL()).into(holder.recyclerImage);
        holder.recyclerCaption.setText(dataList.get(position).getCaption());
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
            recyclerImage = itemView.findViewById(R.id.recyclerImage);
            recyclerCaption = itemView.findViewById(R.id.recyclerCaption);
            card=itemView.findViewById(R.id.image_view);
        }
    }
}
