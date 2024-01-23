package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class C6B_Diary extends AppCompatActivity {
    RecyclerView diaryview;
    ArrayList<DiaryData> dataList;
    DiaryAdapter adapter;
    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Uploaded Diary C6B");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c6_bdiary);
        diaryview = findViewById(R.id.diaryview);
        diaryview.setHasFixedSize(true);
        diaryview.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        adapter = new DiaryAdapter(dataList,this);
        diaryview.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    DiaryData dataClass = dataSnapshot.getValue(DiaryData.class);
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}