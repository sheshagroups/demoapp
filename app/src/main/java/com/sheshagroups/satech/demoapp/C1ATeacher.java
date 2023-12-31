package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class C1ATeacher extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    CardView addstudent,uploadcw,uploadhw,uploaddpp,uploaddiary,addnotification,attendance,logout,updatestudent,application,library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1a_teacher);

        addstudent=findViewById(R.id.addstudent);
        uploadcw=findViewById(R.id.upload_cw);
        uploadhw=findViewById(R.id.upload_hw);
        uploaddpp=findViewById(R.id.upload_dpp);
        uploaddiary=findViewById(R.id.add_diary);
        addnotification=findViewById(R.id.add_notification);
        attendance=findViewById(R.id.attendance);
        updatestudent=findViewById(R.id.updatestudent);
        logout=findViewById(R.id.logout_teacher);
        application = findViewById(R.id.application);
        library = findViewById(R.id.upload_library);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C1ATeacher.this,AddStudentC1A.class);
                startActivity(intent);
            }
        });
        uploadcw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_UploadCW.class);
                startActivity(cwpdf);
            }
        });
        uploadhw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_UploadHW.class);
                startActivity(cwpdf);
            }
        });
        uploaddpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_UploadDpp.class);
                startActivity(cwpdf);
            }
        });
        uploaddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_UploadDiary.class);
                startActivity(cwpdf);
            }
        });
        addnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_AddNotification.class);
                startActivity(cwpdf);
            }
        });

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent website;
                website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://z26zdgx6moybzk8aqvacew.on.drv.tw/class9b_attendance/"));
                startActivity(website);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent cwpdf = new Intent(C1ATeacher.this,TeacherLogin.class);
                startActivity(cwpdf);
                finish();
            }
        });
        updatestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,StudentTeacherLogin.class);
                startActivity(cwpdf);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,Application_C1A.class);
                startActivity(cwpdf);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1ATeacher.this,C1A_Upload_Library.class);
                startActivity(cwpdf);
            }
        });
    }
}