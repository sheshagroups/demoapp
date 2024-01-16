package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class C12B_EditStudent extends AppCompatActivity {
    String sname,sstudentid,sclass,ssection,srollno,sfname,smname,smobile,saddress,sfee,sattendance;
    TextView name,fname,mname,studentid;
    EditText Class,section,rolno,mobileno,address,fee,attendance;
    DatabaseReference reference;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c12_bedit_student);
        name=findViewById(R.id.studentname);
        studentid=findViewById(R.id.editstudentid);
        Class=findViewById(R.id.editClass);
        section=findViewById(R.id.editSection);
        rolno=findViewById(R.id.editroll);
        fname=findViewById(R.id.editfname);
        mname=findViewById(R.id.editmname);
        mobileno=findViewById(R.id.editmobile);
        address=findViewById(R.id.editaddress);
        fee=findViewById(R.id.editfees);
        attendance=findViewById(R.id.editattendance);
        back=findViewById(R.id.backbutton);
        reference = FirebaseDatabase.getInstance().getReference("Class 12B");
        showAllData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(C12B_EditStudent.this,C12BStudentTeacherLogin.class);
                startActivity(back);
                finish();
            }
        });
    }
    public void showAllData(){
        Intent ihome = getIntent();
        sname = ihome.getStringExtra("name");
        sstudentid = ihome.getStringExtra("studentid");
        sclass = ihome.getStringExtra("class");
        ssection = ihome.getStringExtra("section");
        srollno = ihome.getStringExtra("rollno");
        sfname = ihome.getStringExtra("fname");
        smname = ihome.getStringExtra("mname");
        smobile = ihome.getStringExtra("mobile");
        saddress = ihome.getStringExtra("address");
        sfee = ihome.getStringExtra("fee");
        sattendance = ihome.getStringExtra("attendance");

        name.setText(sname);
        studentid.setText(sstudentid);
        Class.setText(sclass);
        section.setText(ssection);
        rolno.setText(srollno);
        fname.setText(sfname);
        mname.setText(smname);
        mobileno.setText(smobile);
        address.setText(saddress);
        fee.setText(sfee);
        attendance.setText(sattendance);
    }

    public void update(View view){

        if (isClassChanged() || isSectionChanged() || isAddressChanged() || isAttendanceChanged() || isRollnoChanged() || isMobilenoChanged()
                || isAttendanceChanged() || isFeeChanged()){

            Toast.makeText(this,"Data has been updated",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data is same and can't be changed",Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isClassChanged() {
        if (!sclass.equals(Class.getText().toString())){
            reference.child(sstudentid).child("sclass").setValue(Class.getText().toString());
            sclass = Class.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isSectionChanged() {
        if (!ssection.equals(section.getText().toString())){
            reference.child(sstudentid).child("ssection").setValue(section.getText().toString());
            ssection = section.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isRollnoChanged() {
        if (!srollno.equals(rolno.getText().toString())){
            reference.child(sstudentid).child("srollno").setValue(rolno.getText().toString());
            srollno = rolno.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isMobilenoChanged() {
        if (!smobile.equals(mobileno.getText().toString())){
            reference.child(sstudentid).child("smobile").setValue(mobileno.getText().toString());
            smobile = mobileno.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isAddressChanged() {
        if (!saddress.equals(address.getText().toString())){
            reference.child(sstudentid).child("saddress").setValue(address.getText().toString());
            saddress = address.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isFeeChanged() {
        if (!sfee.equals(fee.getText().toString())){
            reference.child(sstudentid).child("sfee").setValue(fee.getText().toString());
            sfee = fee.getText().toString();
            return true;
        }else {
            return false;
        }
    }
    private boolean isAttendanceChanged() {
        if (!sattendance.equals(attendance.getText().toString())){
            reference.child(sstudentid).child("sattendance").setValue(attendance.getText().toString());
            sattendance = attendance.getText().toString();
            return true;
        }else {
            return false;
        }
    }
}