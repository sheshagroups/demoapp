package com.sheshagroups.satech.dseschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class C6B_StudentDetail extends AppCompatActivity {
    TextView name,Class,section,rollno,studentid,fname,mname,mobile,address,fee,attendance;
    CardView homecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c6_bstudent_detail);

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
        attendance = findViewById(R.id.attendance1);
        showStudentData();



    }
    public void showStudentData(){

        Intent ihome = getIntent();
        String sname = ihome.getStringExtra("Name");
        String sclass = ihome.getStringExtra("Class");
        String ssection = ihome.getStringExtra("Section");
        String srollno = ihome.getStringExtra("Rollno");
        String sstudentid = ihome.getStringExtra("Studentid");
        String sfname = ihome.getStringExtra("Fname");
        String smname = ihome.getStringExtra("Mname");
        String smobile = ihome.getStringExtra("Mobile");
        String sfee = ihome.getStringExtra("Fee");
        String saddress = ihome.getStringExtra("Address");
        String sattendance = ihome.getStringExtra("Attendance");

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
        attendance.setText(sattendance);
    }
}