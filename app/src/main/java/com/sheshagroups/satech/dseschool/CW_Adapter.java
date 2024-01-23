package com.sheshagroups.satech.dseschool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CW_Adapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ItemClickListerner listerner;
    private final Context context;
    public TextView pdfTitle;
    public CW_Adapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        pdfTitle = itemView.findViewById(R.id.pdf_name);

    }

    @Override
    public void onClick(View view) {
        listerner.onClick(view, getAdapterPosition(),false);

    }
}
