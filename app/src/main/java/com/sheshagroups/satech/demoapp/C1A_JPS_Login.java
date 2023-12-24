package com.sheshagroups.satech.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class C1A_JPS_Login extends AppCompatActivity {



    EditText StudentId, StudentPassword;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1a_jps_login);

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
    }

    public Boolean validateStudentId(){
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
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Class 1A");
        Query checkUserDatabase = reference.orderByChild("sstudentid").equalTo(studentid);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    StudentPassword.setError(null);
                    String passwordFromDB = dataSnapshot.child(studentid).child("sstudentpass").getValue(String.class);
                    if(!Objects.equals(passwordFromDB,studentpass)){
                        StudentPassword.setError(null);
                        Intent ihome = new Intent(C1A_JPS_Login.this,C1A_Home.class);
                        startActivity(ihome);
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