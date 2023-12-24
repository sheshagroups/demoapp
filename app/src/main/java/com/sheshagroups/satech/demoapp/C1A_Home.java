package com.sheshagroups.satech.demoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
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
    DrawerLayout drawerLayout;
    ImageView menu;

    LinearLayout home,classwork,homework,dpp,fees,diary,notification,studentdetail,aboutschool,schoolalbum,contactus,logout;
    CardView student_detail,student_cw,student_hw,student_dpp,student_diary,student_notification,student_fees,student_logout;


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
        student_detail=findViewById(R.id.addstudent);
        student_cw=findViewById(R.id.upload_cw);
        student_hw=findViewById(R.id.upload_hw);
        student_dpp=findViewById(R.id.upload_dpp);
        student_diary=findViewById(R.id.add_diary);
        student_notification=findViewById(R.id.add_notification);
        student_fees=findViewById(R.id.fees);
        student_logout=findViewById(R.id.logout_teacher);



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
                Intent studentdetail = new Intent(C1A_Home.this,C1A_StudentDetail.class);
                startActivity(studentdetail);

            }

        });
        classwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (C1A_Home.this,C1A_Classwork.class));
            }
        });
        homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (C1A_Home.this,C1A_Homework.class));
            }
        });
        dpp.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    startActivity(new Intent (C1A_Home.this,C1A_DPP.class));
                }
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

        student_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentdetail = new Intent(C1A_Home.this,C1A_StudentDetail.class);
                startActivity(studentdetail);
            }
        });
        student_cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,C1A_Classwork.class);
                startActivity(cwpdf);
            }
        });
        student_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,C1A_Homework.class);
                startActivity(cwpdf);
            }
        });
        student_dpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,C1A_DPP.class);
                startActivity(cwpdf);
            }
        });
        student_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,C1A_Diary.class);
                startActivity(cwpdf);
            }
        });
        student_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,C1A_Notification.class);
                startActivity(cwpdf);
            }
        });

        student_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C1A_Home.this,LoginPage.class);
                startActivity(cwpdf);
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