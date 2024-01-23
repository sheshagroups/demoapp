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

public class Upload_Imp extends AppCompatActivity {
    EditText date,notice;
    Button update;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference= db.getReference("Notification");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_imp);
        date=findViewById(R.id.date12);
        notice=findViewById(R.id.notice12);
        update=findViewById(R.id.update12);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Date=date.getText().toString();
                String Notice=notice.getText().toString();

                HashMap<String,String> usermap=new HashMap<>();
                usermap.put("date",Date);
                usermap.put("notice",Notice);

                reference.push().setValue(usermap);
                Toast.makeText(Upload_Imp.this, "Notification Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}