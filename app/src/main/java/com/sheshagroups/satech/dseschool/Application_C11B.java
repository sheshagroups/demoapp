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

public class Application_C11B extends AppCompatActivity {
    RecyclerView diaryview;
    ArrayList<ApplicationData> dataList;
    ApplicationAdapter adapter;
    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Uploaded Application C11B");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_c11_b);
        diaryview = findViewById(R.id.diaryview1);
        diaryview.setHasFixedSize(true);
        diaryview.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        adapter = new ApplicationAdapter(dataList,this);
        diaryview.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ApplicationData dataClass = dataSnapshot.getValue(ApplicationData.class);
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