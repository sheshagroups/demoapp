package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class C1A_Home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,classwork,homework,dpp,fees,diary,notification,studentdetail,aboutschool,schoolalbum,contactus,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_ahome);
        drawerLayout = findViewById(R.id.drawableLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        classwork = findViewById(R.id.classwork);
        homework = findViewById(R.id.homework);
        dpp = findViewById(R.id.dPP);
        fees = findViewById(R.id.fee);
        notification = findViewById(R.id.notification);
        diary = findViewById(R.id.diary);
        studentdetail = findViewById(R.id.studentdetail);
        aboutschool = findViewById(R.id.aboutschool);
        schoolalbum = findViewById(R.id.schoolalbum);
        contactus = findViewById(R.id.contactus);
        logout = findViewById(R.id.logout);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        studentdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_StudentDetail.class);
            }

        });
        classwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_Classwork.class);
            }
        });
        homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_Homework.class);
            }
        });
        dpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_DPP.class);}
            });
        fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_Fees.class);
            }
        });
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_Diary.class);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,C1A_Notification.class);
            }
        });

        aboutschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,AboutSchool.class);
            }
        });
        schoolalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,School_Album.class);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(C1A_Home.this,ContactUs.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(C1A_Home.this,LoginPage.class);
                startActivity(logout);
                finish();
            }
        });
    }

    public static void openDrawer(DrawerLayout drawerLayout){

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
    }