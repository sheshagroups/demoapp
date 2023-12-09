package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    EditText studentid,password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        studentid = findViewById(R.id.studentid);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
    }
}