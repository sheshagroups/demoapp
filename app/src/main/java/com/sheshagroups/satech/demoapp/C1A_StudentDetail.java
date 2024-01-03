package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class C1A_StudentDetail extends AppCompatActivity {
    TextView name,Class,section,rollno,studentid,fname,mname,mobile,address,fee;
    CardView homecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_astudent_detail);

        name=findViewById(R.id.studentname);
        Class=findViewById(R.id.studentclass);
        section=findViewById(R.id.studentsection);
        rollno=findViewById(R.id.studentrollno);
        studentid=findViewById(R.id.studentid);
        fname=findViewById(R.id.studentfname);
        mname=findViewById(R.id.studentmname);
        mobile=findViewById(R.id.studentmobile);
        address=findViewById(R.id.studentaddress);
        fee=findViewById(R.id.studentfee);
        homecard=findViewById(R.id.homecard);
        showStudentData();
        homecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(C1A_StudentDetail.this,C1A_Home.class);
                startActivity(back);
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
       name.setText(sname);
        Class.setText(sclass);
        section.setText(ssection);
        rollno.setText(srollno);
        studentid.setText(sstudentid);
        fname.setText(sfname);
        mname.setText(smname);
        mobile.setText(smobile);
        fee.setText(sfee);
        address.setText(saddress);
    }
}