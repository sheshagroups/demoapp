package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText userid,password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userid.getText().toString().equals("teacher245") && password.getText().toString().equals("teacher245")){
                    Toast.makeText(LoginPage.this,"Invalid Credintials", Toast.LENGTH_SHORT).show();
                    Intent teacher = new Intent(LoginPage.this,TeachersDashboard.class);
                    startActivity(teacher);
                    finish();
                } else{
                    Toast.makeText(LoginPage.this,"Invalid Credintials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}