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
        Query checkUserDatabase1 = reference.orderByChild("sstudentpass").equalTo(studentpass);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    StudentId.setError(null);
                    String passwordFromDB = dataSnapshot.child(studentid).child("sstudentpass").getValue(String.class);
                    if (!Objects.equals(passwordFromDB,studentpass)){
                        StudentPassword.setError(null);
                        /*
                        // Pass data by intent

                        String studentidFromDB = dataSnapshot.child(studentid).child("sstudentid").getValue(String.class);
                        String studentnameFromDB = dataSnapshot.child(studentid).child("sname").getValue(String.class);
                        String studentclassFromDB = dataSnapshot.child(studentid).child("sclass").getValue(String.class);
                        String studentsectionFromDB = dataSnapshot.child(studentid).child("ssection").getValue(String.class);
                        String studentfnameFromDB = dataSnapshot.child(studentid).child("sfname").getValue(String.class);
                        String studentmnameFromDB = dataSnapshot.child(studentid).child("smname").getValue(String.class);
                        String studentmobileFromDB = dataSnapshot.child(studentid).child("smobile").getValue(String.class);
                        String studentaddressFromDB = dataSnapshot.child(studentid).child("saddress").getValue(String.class);
                        String studentfeeFromDB = dataSnapshot.child(studentid).child("sfee").getValue(String.class);


                        ihome.putExtra("sstudentid",studentidFromDB);
                        ihome.putExtra("sname",studentnameFromDB);
                        ihome.putExtra("sclass",studentclassFromDB);
                        ihome.putExtra("ssection",studentsectionFromDB);
                        ihome.putExtra("sfname",studentfnameFromDB);
                        ihome.putExtra("smname",studentmnameFromDB);
                        ihome.putExtra("smobile",studentmobileFromDB);
                        ihome.putExtra("saddress",studentaddressFromDB);
                        ihome.putExtra("sfee",studentfeeFromDB); */
                        Intent ihome = new Intent(C1A_JPS_Login.this,C1A_Home.class);
                        startActivity(ihome);
                        finish();
                    }else{
                        StudentPassword.setError("Invalid Credentials");
                        StudentPassword.requestFocus();
                    }
                }

                else{
                    StudentId.setError("User does not exist");
                    StudentId.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent home = new Intent(C1A_JPS_Login.this,C1A_Home.class);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(home);
            finish();
        }}
}