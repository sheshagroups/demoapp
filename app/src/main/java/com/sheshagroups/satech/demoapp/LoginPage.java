package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText userid,password;
    Button loginButton;
    TextView teacherlogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        teacherlogin = findViewById(R.id.teacherlogin);
        loginButton = findViewById(R.id.loginButton);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        Intent class1A = new Intent(LoginPage.this,C1A_JPS_Login.class);
        if(sharedPreferences.contains("userid")&&sharedPreferences.contains("password")){
            startActivity(class1A);
            finish();
        }

        teacherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherlogin = new Intent(LoginPage.this,TeacherLogin.class);
                startActivity(teacherlogin);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((userid.getText().toString().equals("1") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("1") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class1A);
                    finish();
                } else
                {
                    Toast.makeText(LoginPage.this,"Invalid Credintials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}