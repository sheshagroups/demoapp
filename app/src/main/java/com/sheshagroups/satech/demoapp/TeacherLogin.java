package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeacherLogin extends AppCompatActivity {
    EditText TeacherId, TeacherPassword;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        TeacherId = findViewById(R.id.teacherid);
        TeacherPassword = findViewById(R.id.teacherpassword);
        Login = findViewById(R.id.loginTeacher);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TeacherId.getText().toString().equals("teacher@c1a") && TeacherPassword.getText().toString().equals("teacher@c1a")){
                Intent teacherlogin = new Intent(TeacherLogin.this, C1ATeacher.class);
                startActivity(teacherlogin);
                finish();
            }else if(TeacherId.getText().toString().equals("teacher") && TeacherPassword.getText().toString().equals("teacher")){
                    Intent teacherlogin = new Intent(TeacherLogin.this, TeachersDashboard.class);
                    startActivity(teacherlogin);
                    finish();
            }}
        });
    }
}