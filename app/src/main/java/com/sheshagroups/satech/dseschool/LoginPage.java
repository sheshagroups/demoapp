package com.sheshagroups.satech.dseschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText userid,password;
    Button loginButton;
    TextView teacherlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        teacherlogin = findViewById(R.id.teacherlogin);
        loginButton = findViewById(R.id.loginButton);
        SharedPreferences sharedPreferences1=getSharedPreferences("login1",MODE_PRIVATE);
        SharedPreferences sharedPreferences2=getSharedPreferences("login2",MODE_PRIVATE);
        SharedPreferences sharedPreferences3=getSharedPreferences("login3",MODE_PRIVATE);
        SharedPreferences sharedPreferences4=getSharedPreferences("login4",MODE_PRIVATE);
        SharedPreferences sharedPreferences5=getSharedPreferences("login5",MODE_PRIVATE);
        SharedPreferences sharedPreferences6=getSharedPreferences("login6",MODE_PRIVATE);
        SharedPreferences sharedPreferences7=getSharedPreferences("login7",MODE_PRIVATE);
        SharedPreferences sharedPreferences8=getSharedPreferences("login8",MODE_PRIVATE);
        SharedPreferences sharedPreferences9=getSharedPreferences("login9",MODE_PRIVATE);
        SharedPreferences sharedPreferences10=getSharedPreferences("login10",MODE_PRIVATE);
        SharedPreferences sharedPreferences11=getSharedPreferences("login11",MODE_PRIVATE);
        SharedPreferences sharedPreferences12=getSharedPreferences("login12",MODE_PRIVATE);
        SharedPreferences sharedPreferences13=getSharedPreferences("login13",MODE_PRIVATE);
        SharedPreferences sharedPreferences14=getSharedPreferences("login14",MODE_PRIVATE);
        SharedPreferences sharedPreferences15=getSharedPreferences("login15",MODE_PRIVATE);
        SharedPreferences sharedPreferences16=getSharedPreferences("login16",MODE_PRIVATE);
        SharedPreferences sharedPreferences17=getSharedPreferences("login17",MODE_PRIVATE);
        SharedPreferences sharedPreferences18=getSharedPreferences("login18",MODE_PRIVATE);
        SharedPreferences sharedPreferences19=getSharedPreferences("login19",MODE_PRIVATE);
        SharedPreferences sharedPreferences20=getSharedPreferences("login20",MODE_PRIVATE);
        SharedPreferences sharedPreferences21=getSharedPreferences("login21",MODE_PRIVATE);
        SharedPreferences sharedPreferences22=getSharedPreferences("login22",MODE_PRIVATE);
        SharedPreferences sharedPreferences23=getSharedPreferences("login23",MODE_PRIVATE);
        SharedPreferences sharedPreferences24=getSharedPreferences("login24",MODE_PRIVATE);
        SharedPreferences sharedPreferences25=getSharedPreferences("login25",MODE_PRIVATE);
        SharedPreferences sharedPreferences26=getSharedPreferences("login26",MODE_PRIVATE);
        Intent class1A = new Intent(LoginPage.this, C1A_DSE_Login.class);
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
        Intent class11A = new Intent(LoginPage.this,C11A_DSE_Login.class);
        Intent class11B = new Intent(LoginPage.this,C11B_DSE_Login.class);
        Intent class11C = new Intent(LoginPage.this,C11C_DSE_Login.class);
        Intent class12A = new Intent(LoginPage.this,C12A_DSE_Login.class);
        Intent class12B = new Intent(LoginPage.this,C12B_DSE_Login.class);
        Intent class12C = new Intent(LoginPage.this,C12C_DSE_Login.class);
        if(sharedPreferences1.contains("userid")&&sharedPreferences1.contains("password")){
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
                    SharedPreferences.Editor editor=sharedPreferences1.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class1A);
                    finish();
                } else if((userid.getText().toString().equals("1") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("1") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences2.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class1B);
                    finish();
                } else if((userid.getText().toString().equals("2") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("2") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences3.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class2A);
                    finish();
                } else if((userid.getText().toString().equals("2") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("2") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences4.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class2B);
                    finish();
                } else if((userid.getText().toString().equals("3") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("3") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences5.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class3A);
                    finish();
                } else if((userid.getText().toString().equals("3") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("3") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences6.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class3B);
                    finish();
                } else if((userid.getText().toString().equals("4") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("4") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences7.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class4A);
                    finish();
                } else if((userid.getText().toString().equals("4") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("4") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences8.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class4B);
                    finish();
                } else if((userid.getText().toString().equals("5") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("5") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences9.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class5A);
                    finish();
                } else if((userid.getText().toString().equals("5") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("5") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences10.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class5B);
                    finish();
                } else if((userid.getText().toString().equals("6") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("6") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences11.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class6A);
                    finish();
                } else if((userid.getText().toString().equals("6") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("6") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences12.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class6B);
                    finish();
                } else if((userid.getText().toString().equals("7") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("7") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences13.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class7A);
                    finish();
                } else if((userid.getText().toString().equals("7") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("7") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences14.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class7B);
                    finish();
                } else if((userid.getText().toString().equals("8") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("8") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences15.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class8A);
                    finish();
                } else if((userid.getText().toString().equals("8") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("8") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences16.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class8B);
                    finish();
                } else if((userid.getText().toString().equals("9") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("9") && password.getText().toString().equals("A"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences17.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class9A);
                    finish();
                } else if((userid.getText().toString().equals("9") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("9") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences18.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class9B);
                    finish();
                } else if((userid.getText().toString().equals("10") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("10") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences19.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class10A);
                    finish();
                } else if((userid.getText().toString().equals("10") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("10") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences20.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class10B);
                    finish();
                } else if((userid.getText().toString().equals("11") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("11") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences21.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class11A);
                    finish();
                } else if((userid.getText().toString().equals("11") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("11") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences22.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class11B);
                    finish();
                } else if((userid.getText().toString().equals("11") && password.getText().toString().equals("C") )|| (userid.getText().toString().equals("11") && password.getText().toString().equals("c"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences23.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class11C);
                    finish();
                } else if((userid.getText().toString().equals("12") && password.getText().toString().equals("A") )|| (userid.getText().toString().equals("12") && password.getText().toString().equals("a"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences24.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class12A);
                    finish();
                } else if((userid.getText().toString().equals("12") && password.getText().toString().equals("B") )|| (userid.getText().toString().equals("12") && password.getText().toString().equals("b"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences25.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class12B);
                    finish();
                } else if((userid.getText().toString().equals("12") && password.getText().toString().equals("C") )|| (userid.getText().toString().equals("12") && password.getText().toString().equals("c"))){
                    Toast.makeText(LoginPage.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences26.edit();
                    editor.putString("userid", String.valueOf(userid));
                    editor.putString("password",String.valueOf(password));
                    editor.commit();
                    startActivity(class12C);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginPage.this,"Invalid Credintials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}