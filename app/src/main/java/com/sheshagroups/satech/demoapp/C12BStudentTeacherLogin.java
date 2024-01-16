package com.sheshagroups.satech.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class C12BStudentTeacherLogin extends AppCompatActivity {
    EditText StudentId, StudentPassword;
    TextView class_section;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c12_bstudent_teacher_login);
        StudentId = findViewById(R.id.studentid1a);
        StudentPassword = findViewById(R.id.studentpassword1a);
        Login = findViewById(R.id.loginC1A);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateStudentPass() | !validateStudentId()){

                }else{
                    checkStudent();
                }
            }
        });
    }public Boolean validateStudentId(){
        String val = StudentId.getText().toString();
        if (val.isEmpty()){
            StudentId.setError("StudentId can't be Empty");
            return false;
        } else{
            StudentId.setError(null);
            return true;
        }}

    public Boolean validateStudentPass(){
        String val = StudentPassword.getText().toString();
        if (val.isEmpty()){
            StudentPassword.setError("Password can't be Empty");
            return false;
        } else{
            StudentPassword.setError(null);
            return true;
        }}


    public void checkStudent(){
        String studentid = StudentId.getText().toString().trim();
        String studentpass = StudentPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Class 12B");
        Query checkUserDatabase = reference.orderByChild("sstudentid").equalTo(studentid);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    StudentPassword.setError(null);
                    String passwordFromDB = dataSnapshot.child(studentid).child("sstudentTeacherPassword").getValue(String.class);
                    if(passwordFromDB.equals(studentpass)){
                        StudentPassword.setError(null);
                        String nameFromDatabase = dataSnapshot.child(studentid).child("sname").getValue(String.class);
                        String classFromDatabase = dataSnapshot.child(studentid).child("sclass").getValue(String.class);
                        String sectionFromDatabase = dataSnapshot.child(studentid).child("ssection").getValue(String.class);
                        String studentidFromDatabase = dataSnapshot.child(studentid).child("sstudentid").getValue(String.class);
                        String rollnoFromDatabase = dataSnapshot.child(studentid).child("srollno").getValue(String.class);
                        String fnameFromDatabase = dataSnapshot.child(studentid).child("sfname").getValue(String.class);
                        String mnameFromDatabase = dataSnapshot.child(studentid).child("smname").getValue(String.class);
                        String mobileFromDatabase = dataSnapshot.child(studentid).child("smobile").getValue(String.class);
                        String addressFromDatabase = dataSnapshot.child(studentid).child("saddress").getValue(String.class);
                        String feeFromDatabase = dataSnapshot.child(studentid).child("sfee").getValue(String.class);
                        String attendanceFromDatabase = dataSnapshot.child(studentid).child("sattendance").getValue(String.class);
                        Intent ihome = new Intent(C12BStudentTeacherLogin.this, C12B_EditStudent.class);
                        ihome.putExtra("name",nameFromDatabase);
                        ihome.putExtra("class",classFromDatabase);
                        ihome.putExtra("section",sectionFromDatabase);
                        ihome.putExtra("studentid",studentidFromDatabase);
                        ihome.putExtra("rollno",rollnoFromDatabase);
                        ihome.putExtra("fname",fnameFromDatabase);
                        ihome.putExtra("mname",mnameFromDatabase);
                        ihome.putExtra("mobile",mobileFromDatabase);
                        ihome.putExtra("address",addressFromDatabase);
                        ihome.putExtra("fee",feeFromDatabase);
                        ihome.putExtra("attendance",attendanceFromDatabase);
                        startActivity(ihome);

                    }else{
                        StudentPassword.setError("Invalid Credentials");
                        StudentPassword.requestFocus();
                    }
                } else{
                    StudentId.setError("User does not exist");
                    StudentId.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
