package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class C1A_StudentDetail extends AppCompatActivity {
    TextView name,Class,section,rollno,studentid,fname,mname,mobile,address,fee;
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

       // showStudentData();

    }
/*
    public void showStudentData(){
        Intent intent = getIntent();
        String Studentname = intent.getStringExtra("sname");
        String Studentclass = intent.getStringExtra("sclass");
        String Studentsection = intent.getStringExtra("ssection");
        String Studentid = intent.getStringExtra("sstudentid");
        String Studentfname = intent.getStringExtra("sfname");
        String Studentmname = intent.getStringExtra("smname");
        String Studentmobile = intent.getStringExtra("smobile");
        String Studentaddress = intent.getStringExtra("saddress");
        String Studentfee = intent.getStringExtra("sfee");
        String Studentrollno = intent.getStringExtra("srollno");

        name.setText(Studentname);
        Class.setText(Studentclass);
        section.setText(Studentsection);
        rollno.setText(Studentrollno);
        studentid.setText(Studentid);
        fname.setText(Studentfname);
        mname.setText(Studentmname);
        mobile.setText(Studentmobile);
        fee.setText(Studentfee);
        address.setText(Studentaddress);
    }

 */
}