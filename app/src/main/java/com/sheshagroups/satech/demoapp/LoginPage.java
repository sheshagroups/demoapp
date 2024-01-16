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
        Intent class1B = new Intent(LoginPage.this,C1B_DSE_Login.class);
        Intent class2A = new Intent(LoginPage.this, C2A_DSE_Login.class);
        Intent class2B = new Intent(LoginPage.this, C2B_DSE_Login.class);
        Intent class3A = new Intent(LoginPage.this,C3A_DSE_Login.class);
        Intent class3B = new Intent(LoginPage.this,C3B_DSE_Login.class);
        Intent class4A = new Intent(LoginPage.this,C4A_DSE_Login.class);
        Intent class4B = new Intent(LoginPage.this,C4B_DSE_Login.class);
        Intent class5A = new Intent(LoginPage.this,C5A_DSE_Login.class);
        Intent class5B = new Intent(LoginPage.this, C5A_DSE_Login.class);
        Intent class6A = new Intent(LoginPage.this,C6A_DSE_Login.class);
        Intent class6B = new Intent(LoginPage.this,C6B_DSE_Login.class);
        Intent class7A = new Intent(LoginPage.this,C7A_DSE_Login.class);
        Intent class7B = new Intent(LoginPage.this,C7B_DSE_Login.class);
        Intent class8A = new Intent(LoginPage.this,C8A_DSE_Login.class);
        Intent class8B = new Intent(LoginPage.this,C8B_DSE_Login.class);
        Intent class9A = new Intent(LoginPage.this,C9A_DSE_Login.class);
        Intent class9B = new Intent(LoginPage.this,C9B_DSE_Login.class);
        Intent class10A = new Intent(LoginPage.this,C10A_DSE_Login.class);
        Intent class10B = new Intent(LoginPage.this,C10B_DSE_Login.class);
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
                } else if((userid.getText().toString().equals("1") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("1") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class1B);
                    finish();
                } else if((userid.getText().toString().equals("2") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("2") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class2A);
                    finish();
                } else if((userid.getText().toString().equals("2") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("2") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class2B);
                    finish();
                } else if((userid.getText().toString().equals("3") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("3") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class3A);
                    finish();
                } else if((userid.getText().toString().equals("3") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("3") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class3B);
                    finish();
                } else if((userid.getText().toString().equals("4") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("4") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class4A);
                    finish();
                } else if((userid.getText().toString().equals("4") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("4") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class4B);
                    finish();
                } else if((userid.getText().toString().equals("5") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("5") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class5A);
                    finish();
                } else if((userid.getText().toString().equals("5") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("5") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class5B);
                    finish();
                } else if((userid.getText().toString().equals("6") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("6") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class6A);
                    finish();
                } else if((userid.getText().toString().equals("6") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("6") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class6B);
                    finish();
                } else if((userid.getText().toString().equals("7") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("7") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class7A);
                    finish();
                } else if((userid.getText().toString().equals("7") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("7") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class7B);
                    finish();
                } else if((userid.getText().toString().equals("8") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("8") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class8A);
                    finish();
                } else if((userid.getText().toString().equals("8") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("8") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class8B);
                    finish();
                } else if((userid.getText().toString().equals("9") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("9") && password.getText().toString().equals("A"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class9A);
                    finish();
                } else if((userid.getText().toString().equals("9") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("9") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class9B);
                    finish();
                } else if((userid.getText().toString().equals("10") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("10") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class10A);
                    finish();
                } else if((userid.getText().toString().equals("10") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("10") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class10B);
                    finish();
                } else
                {
                    Toast.makeText(LoginPage.this,"Invalid Credintials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}