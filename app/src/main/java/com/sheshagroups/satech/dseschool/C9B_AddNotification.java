package com.sheshagroups.satech.dseschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class C9B_AddNotification extends AppCompatActivity {
    EditText date,notice;
    Button update;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference= db.getReference("Notification C9B");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_aadd_notification);
        date=findViewById(R.id.date);
        notice=findViewById(R.id.notice);
        update=findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Date=date.getText().toString();
                String Notice=notice.getText().toString();

                HashMap<String,String> usermap=new HashMap<>();
                usermap.put("date",Date);
                usermap.put("notice",Notice);

                reference.push().setValue(usermap);
                Toast.makeText(C9B_AddNotification.this, "Notification Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}