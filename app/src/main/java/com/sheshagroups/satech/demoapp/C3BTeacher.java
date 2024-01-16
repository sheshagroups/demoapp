package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class C3BTeacher extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    CardView addstudent,uploadcw,uploadhw,uploaddpp,uploaddiary,addnotification,attendance,logout,updatestudent,application,library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_bteacher);
        addstudent=findViewById(R.id.addstudent);
        uploadcw=findViewById(R.id.upload_cw);
        uploadhw=findViewById(R.id.upload_hw);
        uploaddpp=findViewById(R.id.upload_dpp);
        uploaddiary=findViewById(R.id.add_diary);
        addnotification=findViewById(R.id.add_notification);
        updatestudent=findViewById(R.id.updatestudent);
        logout=findViewById(R.id.logout_teacher);
        application = findViewById(R.id.application);
        library = findViewById(R.id.upload_library);
        sharedPreferences=getSharedPreferences("login1",MODE_PRIVATE);

        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3BTeacher.this,C3B_Addstudent.class);
                startActivity(intent);
            }
        });
        uploadcw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_UploadCW.class);
                startActivity(cwpdf);
            }
        });
        uploadhw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_UploadHW.class);
                startActivity(cwpdf);
            }
        });
        uploaddpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_UploadDpp.class);
                startActivity(cwpdf);
            }
        });
        uploaddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_UploadDiary.class);
                startActivity(cwpdf);
            }
        });
        addnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_AddNotification.class);
                startActivity(cwpdf);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent cwpdf = new Intent(C3BTeacher.this,TeacherLogin.class);
                startActivity(cwpdf);
                finish();
            }
        });
        updatestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3BStudentTeacherLogin.class);
                startActivity(cwpdf);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,Application_C3B.class);
                startActivity(cwpdf);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C3BTeacher.this,C3B_Upload_Library.class);
                startActivity(cwpdf);
            }
        });
    }
}
