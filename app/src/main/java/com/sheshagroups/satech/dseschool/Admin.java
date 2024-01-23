package com.sheshagroups.satech.dseschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {
    CardView doc,imp,log;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        doc = findViewById(R.id.uploaddoc);
        imp = findViewById(R.id.uploadimp);
        log = findViewById(R.id.adminlogout);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc = new Intent(Admin.this,Upload_Doc.class);
                startActivity(doc);
            }
        });
        imp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc = new Intent(Admin.this,Upload_Imp.class);
                startActivity(doc);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent doc = new Intent(Admin.this,TeacherLogin.class);
                startActivity(doc);
                finish();
            }
        });
    }
}