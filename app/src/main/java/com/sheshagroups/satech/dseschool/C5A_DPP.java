package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class C5A_DPP extends AppCompatActivity {
    RecyclerView pdfRecyclerView;
    private DatabaseReference pRef;
    Query query;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c5_adpp);
        displayPdfs();
    }
    private void displayPdfs(){

        pRef = FirebaseDatabase.getInstance().getReference().child("Uploaded DPP C5A");
        pdfRecyclerView = findViewById(R.id.cwrecycler);
        pdfRecyclerView.setHasFixedSize(true);
        pdfRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        query = pRef.orderByChild("uploadET");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    progressBar.setVisibility(View.GONE);
                    showPdf();
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(C5A_DPP.this,":",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showPdf() {
        FirebaseRecyclerOptions<CWFileModel> options = new FirebaseRecyclerOptions.Builder<CWFileModel>()
                .setQuery(query, CWFileModel.class)
                .build();
        FirebaseRecyclerAdapter<CWFileModel, CW_Adapter> adapter = new FirebaseRecyclerAdapter<CWFileModel, CW_Adapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CW_Adapter holder, int position, @NonNull CWFileModel cwFileModel) {

                progressBar.setVisibility(View.GONE);
                holder.pdfTitle.setText(cwFileModel.getUploadET());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setType("application/pdf");
                        intent.setData(Uri.parse(cwFileModel.getUploadURL()));
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public CW_Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_items,parent,false);
                CW_Adapter holder = new CW_Adapter(view);
                return holder;
            }
        };

        pdfRecyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
}
}
