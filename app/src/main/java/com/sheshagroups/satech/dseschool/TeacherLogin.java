package com.sheshagroups.satech.dseschool;

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
    SharedPreferences sharedPreferences, sharedPreferences1, sharedPreferences2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        TeacherId = findViewById(R.id.teacherid);
        TeacherPassword = findViewById(R.id.teacherpassword);
        Login = findViewById(R.id.loginTeacher);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("login1",MODE_PRIVATE);
        sharedPreferences2=getSharedPreferences("login2",MODE_PRIVATE);
        Intent teacherlogin = new Intent(TeacherLogin.this, C1ATeacher.class);
        Intent teacherlogin1 = new Intent(TeacherLogin.this, C1BTeacher.class);
        Intent teacherloginadmin = new Intent(TeacherLogin.this, Admin.class);
        if(sharedPreferences.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")){
            startActivity(teacherlogin);
            finish();
        } else if (sharedPreferences1.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin1);
            finish();
        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TeacherId.getText().toString().equals("teacher@c1a") && TeacherPassword.getText().toString().equals("teacher@c1a")){
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin);
                    finish();
            } else if(TeacherId.getText().toString().equals("teacher@c1b") && TeacherPassword.getText().toString().equals("teacher@c1b")){
                    SharedPreferences.Editor editor=sharedPreferences1.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin1);
                    finish();
                }

                else if(TeacherId.getText().toString().equals("admin@dsebst") && TeacherPassword.getText().toString().equals("admin")){
                    SharedPreferences.Editor editor=sharedPreferences2.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherloginadmin);
                    finish();
            }
        }
        });
    }}