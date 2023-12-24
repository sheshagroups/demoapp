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

       showStudentData();

    }
    public void showStudentData(){
        Intent intent = getIntent();
        String sname = intent.getStringExtra("name");
        String sclass = intent.getStringExtra("Class");
        String ssection = intent.getStringExtra("section");
        String sstudentid = intent.getStringExtra("studentid");
        String sfname = intent.getStringExtra("fname");
        String smname = intent.getStringExtra("mname");
        String smobile = intent.getStringExtra("mobile");
        String saddress = intent.getStringExtra("address");
        String sfee = intent.getStringExtra("fee");
        String srollno = intent.getStringExtra("rollno");
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