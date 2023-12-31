package com.sheshagroups.satech.demoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class C1A_Home extends AppCompatActivity {
    SharedPreferences sharedPreferences, sharedPreferences1;
    CardView student_detail, student_cw, student_hw, student_dpp, student_diary,
            student_notification, student_fees, student_logout, aboutschool, contactus, library,application;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_ahome);
        student_detail = findViewById(R.id.addstudent);
        student_cw = findViewById(R.id.upload_cw);
        student_hw = findViewById(R.id.upload_hw);
        student_dpp = findViewById(R.id.upload_dpp);
        student_diary = findViewById(R.id.add_diary);
        student_notification = findViewById(R.id.add_notification);
        student_fees = findViewById(R.id.fees);
        student_logout = findViewById(R.id.logout_teacher);
        aboutschool = findViewById(R.id.aboutschool);
        contactus = findViewById(R.id.contactus);
        library = findViewById(R.id.library);
        application = findViewById(R.id.upload_application);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sharedPreferences1 = getSharedPreferences("student", MODE_PRIVATE);


        student_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStudentData();
            }
        });
        student_cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_Classwork.class);
                startActivity(cwpdf);
            }
        });
        student_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_Homework.class);
                startActivity(cwpdf);
            }
        });
        student_dpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_DPP.class);
                startActivity(cwpdf);
            }
        });
        student_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_Diary.class);
                startActivity(cwpdf);
            }
        });

        student_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_Fees.class);
                startActivity(cwpdf);
            }
        });
        student_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, C1A_Notification.class);
                startActivity(cwpdf);
            }
        });

        student_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor.clear();
                editor.commit();
                editor1.clear();
                editor1.commit();
                Intent logout = new Intent(C1A_Home.this, LoginPage.class);
                startActivity(logout);
                finish();
            }
        });

        aboutschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, AboutSchool.class);
                startActivity(cwpdf);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, ContactUs.class);
                startActivity(cwpdf);
            }
        });

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, Library_C1A.class);
                startActivity(cwpdf);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this, Upload_Application_C1A.class);
                startActivity(cwpdf);
            }
        });
    }
    public void showStudentData(){

        Intent ihome = getIntent();
        String sname = ihome.getStringExtra("name");
        String sclass = ihome.getStringExtra("class");
        String ssection = ihome.getStringExtra("section");
        String srollno = ihome.getStringExtra("rollno");
        String sstudentid = ihome.getStringExtra("studentid");
        String sfname = ihome.getStringExtra("fname");
        String smname = ihome.getStringExtra("mname");
        String smobile = ihome.getStringExtra("mobile");
        String sfee = ihome.getStringExtra("fee");
        String saddress = ihome.getStringExtra("address");
        String sattendance = ihome.getStringExtra("attendance");

        Intent profile = new Intent(C1A_Home.this,C1A_StudentDetail.class);
        profile.putExtra("Name",sname);
        profile.putExtra("Class",sclass);
        profile.putExtra("Section",ssection);
        profile.putExtra("Studentid",sstudentid);
        profile.putExtra("Rollno",srollno);
        profile.putExtra("Fname",sfname);
        profile.putExtra("Mname",smname);
        profile.putExtra("Mobile",smobile);
        profile.putExtra("Address",saddress);
        profile.putExtra("Fee",sfee);
        profile.putExtra("Attendance",sattendance);
        startActivity(profile);
    }
}