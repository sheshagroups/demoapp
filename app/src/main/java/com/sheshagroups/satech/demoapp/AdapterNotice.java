package com.sheshagroups.satech.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterNotice extends RecyclerView.Adapter<AdapterNotice.ViewHolder> {

    ArrayList<Model> arrayList;
    Context context;

    public AdapterNotice(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_notice,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model=arrayList.get(position);
        holder.date.setText(model.getDate());
        holder.notice.setText(model.getNotice());
        holder.noticecard.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_1));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView date,notice;
        CardView noticecard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date_noti);
            notice=itemView.findViewById(R.id.notice_noti);
            noticecard=itemView.findViewById(R.id.noticecard);
        }
    }
}
