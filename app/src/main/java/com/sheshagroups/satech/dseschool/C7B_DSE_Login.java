package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class C7B_DSE_Login extends AppCompatActivity {
    EditText StudentId, StudentPassword;
    TextView class_section;
    Button Login;
    SharedPreferences sharedPreferences,sharedPreferences1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c7_bdse_login);
        StudentId = findViewById(R.id.studentid1b);
        StudentPassword = findViewById(R.id.studentpassword1b);
        Login = findViewById(R.id.loginC1B);
        class_section = findViewById(R.id.class_section);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("student",MODE_PRIVATE);
        FirebaseApp.initializeApp(this);
        Intent home = new Intent(C7B_DSE_Login.this,C7B_Home.class);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateStudentPass() | !validateStudentId()){

                }else{
                    final String studentid = StudentId.getText().toString().trim();
                    final String studentpass = StudentPassword.getText().toString().trim();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Class 7B");
                    Query checkUserDatabase = reference.orderByChild("sstudentid").equalTo(studentid);
                    checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                StudentId.setError(null);
                                String passwordFromDB = snapshot.child(studentid).child("sstudentpass").getValue(String.class);
                                if(passwordFromDB.equals(studentpass)){
                                    StudentPassword.setError(null);
                                    String nameFromDatabase = snapshot.child(studentid).child("sname").getValue(String.class);
                                    String classFromDatabase = snapshot.child(studentid).child("sclass").getValue(String.class);
                                    String sectionFromDatabase = snapshot.child(studentid).child("ssection").getValue(String.class);
                                    String studentidFromDatabase = snapshot.child(studentid).child("sstudentid").getValue(String.class);
                                    String rollnoFromDatabase = snapshot.child(studentid).child("srollno").getValue(String.class);
                                    String fnameFromDatabase = snapshot.child(studentid).child("sfname").getValue(String.class);
                                    String mnameFromDatabase = snapshot.child(studentid).child("smname").getValue(String.class);
                                    String mobileFromDatabase = snapshot.child(studentid).child("smobile").getValue(String.class);
                                    String addressFromDatabase = snapshot.child(studentid).child("saddress").getValue(String.class);
                                    String feeFromDatabase = snapshot.child(studentid).child("sfee").getValue(String.class);
                                    String attendanceFromDatabase = snapshot.child(studentid).child("sattendance").getValue(String.class);
                                    home.putExtra("name",nameFromDatabase);
                                    home.putExtra("class",classFromDatabase);
                                    home.putExtra("section",sectionFromDatabase);
                                    home.putExtra("studentid",studentidFromDatabase);
                                    home.putExtra("rollno",rollnoFromDatabase);
                                    home.putExtra("fname",fnameFromDatabase);
                                    home.putExtra("mname",mnameFromDatabase);
                                    home.putExtra("mobile",mobileFromDatabase);
                                    home.putExtra("address",addressFromDatabase);
                                    home.putExtra("fee",feeFromDatabase);
                                    home.putExtra("attendance",attendanceFromDatabase);
                                    startActivity(home);
                                    finish();
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
        });
        class_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent login = new Intent(C7B_DSE_Login.this, LoginPage.class);
                startActivity(login);
                finish();
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
}