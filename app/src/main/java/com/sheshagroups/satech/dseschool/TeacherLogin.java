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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        TeacherId = findViewById(R.id.teacherid);
        TeacherPassword = findViewById(R.id.teacherpassword);
        Login = findViewById(R.id.loginTeacher);
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences sharedPreferences1=getSharedPreferences("login1",MODE_PRIVATE);
        SharedPreferences  sharedPreferences2=getSharedPreferences("login2",MODE_PRIVATE);
        SharedPreferences  sharedPreferences3=getSharedPreferences("login3",MODE_PRIVATE);
        SharedPreferences  sharedPreferences4=getSharedPreferences("login4",MODE_PRIVATE);
        SharedPreferences  sharedPreferences5=getSharedPreferences("login5",MODE_PRIVATE);
        SharedPreferences  sharedPreferences6=getSharedPreferences("login6",MODE_PRIVATE);
        SharedPreferences  sharedPreferences7=getSharedPreferences("login7",MODE_PRIVATE);
        SharedPreferences  sharedPreferences8=getSharedPreferences("login8",MODE_PRIVATE);
        SharedPreferences  sharedPreferences9=getSharedPreferences("login9",MODE_PRIVATE);
        SharedPreferences  sharedPreferences10=getSharedPreferences("login10",MODE_PRIVATE);
        SharedPreferences  sharedPreferences11=getSharedPreferences("login11",MODE_PRIVATE);
        SharedPreferences  sharedPreferences12=getSharedPreferences("login12",MODE_PRIVATE);
        SharedPreferences sharedPreferences13=getSharedPreferences("login13",MODE_PRIVATE);
        SharedPreferences sharedPreferences14=getSharedPreferences("login14",MODE_PRIVATE);
        SharedPreferences sharedPreferences15=getSharedPreferences("login15",MODE_PRIVATE);
        SharedPreferences sharedPreferences16=getSharedPreferences("login16",MODE_PRIVATE);
        SharedPreferences sharedPreferences17=getSharedPreferences("login17",MODE_PRIVATE);
        SharedPreferences sharedPreferences18=getSharedPreferences("login18",MODE_PRIVATE);
        SharedPreferences  sharedPreferences19=getSharedPreferences("login19",MODE_PRIVATE);
        SharedPreferences  sharedPreferences20=getSharedPreferences("login20",MODE_PRIVATE);
        SharedPreferences sharedPreferences21=getSharedPreferences("login21",MODE_PRIVATE);
        SharedPreferences  sharedPreferences22=getSharedPreferences("login22",MODE_PRIVATE);
        SharedPreferences   sharedPreferences23=getSharedPreferences("login23",MODE_PRIVATE);
        SharedPreferences  sharedPreferences24=getSharedPreferences("login24",MODE_PRIVATE);
        SharedPreferences  sharedPreferences25=getSharedPreferences("login25",MODE_PRIVATE);
        SharedPreferences  sharedPreferences26=getSharedPreferences("login26",MODE_PRIVATE);
        Intent teacherlogin = new Intent(TeacherLogin.this, C1ATeacher.class);
        Intent teacherlogin1 = new Intent(TeacherLogin.this, C1BTeacher.class);
        Intent teacherlogin2 = new Intent(TeacherLogin.this, C2ATeacher.class);
        Intent teacherlogin3 = new Intent(TeacherLogin.this, C2BTeacher.class);
        Intent teacherlogin4 = new Intent(TeacherLogin.this, C3ATeacher.class);
        Intent teacherlogin5 = new Intent(TeacherLogin.this, C3BTeacher.class);
        Intent teacherlogin6 = new Intent(TeacherLogin.this, C4ATeacher.class);
        Intent teacherlogin7 = new Intent(TeacherLogin.this, C4BTeacher.class);
        Intent teacherlogin8 = new Intent(TeacherLogin.this, C5ATeacher.class);
        Intent teacherlogin9 = new Intent(TeacherLogin.this, C5BTeacher.class);
        Intent teacherlogin10 = new Intent(TeacherLogin.this, C6ATeacher.class);
        Intent teacherlogin11 = new Intent(TeacherLogin.this, C6BTeacher.class);
        Intent teacherlogin12 = new Intent(TeacherLogin.this, C7ATeacher.class);
        Intent teacherlogin13 = new Intent(TeacherLogin.this, C7BTeacher.class);
        Intent teacherlogin14 = new Intent(TeacherLogin.this, C8ATeacher.class);
        Intent teacherlogin15 = new Intent(TeacherLogin.this, C8BTeacher.class);
        Intent teacherlogin16 = new Intent(TeacherLogin.this, C9ATeacher.class);
        Intent teacherlogin17 = new Intent(TeacherLogin.this, C9BTeacher.class);
        Intent teacherlogin18 = new Intent(TeacherLogin.this, C10ATeacher.class);
        Intent teacherlogin19 = new Intent(TeacherLogin.this, C10BTeacher.class);
        Intent teacherlogin20 = new Intent(TeacherLogin.this, C11ATeacher.class);
        Intent teacherlogin21 = new Intent(TeacherLogin.this, C11BTeacher.class);
        Intent teacherlogin22 = new Intent(TeacherLogin.this, C11CTeacher.class);
        Intent teacherlogin23 = new Intent(TeacherLogin.this, C12ATeacher.class);
        Intent teacherlogin24 = new Intent(TeacherLogin.this, C12BTeacher.class);
        Intent teacherlogin25 = new Intent(TeacherLogin.this, C12CTeacher.class);
        Intent teacherloginadmin = new Intent(TeacherLogin.this, Admin.class);
        if(sharedPreferences.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")){
            startActivity(teacherlogin);
            finish();
        } else if (sharedPreferences1.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin1);
            finish();
        }else if (sharedPreferences2.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin2);
            finish();
        }else if (sharedPreferences3.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin3);
            finish();
        }else if (sharedPreferences4.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin4);
            finish();
        }else if (sharedPreferences5.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin5);
            finish();
        }else if (sharedPreferences6.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin6);
            finish();
        }else if (sharedPreferences7.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin7);
            finish();
        }else if (sharedPreferences8.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin8);
            finish();
        }else if (sharedPreferences9.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin9);
            finish();
        }else if (sharedPreferences10.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin10);
            finish();
        }else if (sharedPreferences11.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin11);
            finish();
        }else if (sharedPreferences12.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin12);
            finish();
        }else if (sharedPreferences13.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin13);
            finish();
        }else if (sharedPreferences14.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin14);
            finish();
        }else if (sharedPreferences15.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin15);
            finish();
        }else if (sharedPreferences16.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin16);
            finish();
        }else if (sharedPreferences17.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin17);
            finish();
        }else if (sharedPreferences18.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin18);
            finish();
        }else if (sharedPreferences19.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin19);
            finish();
        }else if (sharedPreferences20.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin20);
            finish();
        }else if (sharedPreferences21.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin21);
            finish();
        }else if (sharedPreferences22.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin22);
            finish();
        }else if (sharedPreferences23.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin23);
            finish();
        }else if (sharedPreferences24.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherlogin24);
            finish();
        }else if (sharedPreferences25.contains("TeacherId")&&sharedPreferences.contains("TeacherPassword")) {
            startActivity(teacherloginadmin);
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
                }else if(TeacherId.getText().toString().equals("teacher@c2a") && TeacherPassword.getText().toString().equals("teacher@c2a")){
                    SharedPreferences.Editor editor=sharedPreferences2.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin2);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c2b") && TeacherPassword.getText().toString().equals("teacher@c2b")){
                    SharedPreferences.Editor editor=sharedPreferences3.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin3);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c3a") && TeacherPassword.getText().toString().equals("teacher@c3a")){
                    SharedPreferences.Editor editor=sharedPreferences4.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin4);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c3b") && TeacherPassword.getText().toString().equals("teacher@c3b")){
                    SharedPreferences.Editor editor=sharedPreferences5.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin5);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c4a") && TeacherPassword.getText().toString().equals("teacher@c4a")){
                    SharedPreferences.Editor editor=sharedPreferences6.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin6);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c4b") && TeacherPassword.getText().toString().equals("teacher@c4b")){
                    SharedPreferences.Editor editor=sharedPreferences7.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin7);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c5a") && TeacherPassword.getText().toString().equals("teacher@c5a")){
                    SharedPreferences.Editor editor=sharedPreferences8.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin8);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c5b") && TeacherPassword.getText().toString().equals("teacher@c5b")){
                    SharedPreferences.Editor editor=sharedPreferences9.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin9);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c6a") && TeacherPassword.getText().toString().equals("teacher@c6a")){
                    SharedPreferences.Editor editor=sharedPreferences10.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin10);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c6b") && TeacherPassword.getText().toString().equals("teacher@c6b")){
                    SharedPreferences.Editor editor=sharedPreferences11.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin11);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c7a") && TeacherPassword.getText().toString().equals("teacher@c7a")){
                    SharedPreferences.Editor editor=sharedPreferences12.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin12);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c7b") && TeacherPassword.getText().toString().equals("teacher@c7b")){
                    SharedPreferences.Editor editor=sharedPreferences13.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin13);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c8a") && TeacherPassword.getText().toString().equals("teacher@c8a")){
                    SharedPreferences.Editor editor=sharedPreferences14.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin14);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c8b") && TeacherPassword.getText().toString().equals("teacher@c8b")){
                    SharedPreferences.Editor editor=sharedPreferences15.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin15);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c9a") && TeacherPassword.getText().toString().equals("teacher@c9a")){
                    SharedPreferences.Editor editor=sharedPreferences16.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin16);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c9b") && TeacherPassword.getText().toString().equals("teacher@c9b")){
                    SharedPreferences.Editor editor=sharedPreferences17.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin17);
                    finish();
                }
                else if(TeacherId.getText().toString().equals("teacher@c10a") && TeacherPassword.getText().toString().equals("teacher@c10a")){
                    SharedPreferences.Editor editor=sharedPreferences18.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin18);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c10b") && TeacherPassword.getText().toString().equals("teacher@c10b")){
                    SharedPreferences.Editor editor=sharedPreferences19.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin19);
                    finish();
                } else if(TeacherId.getText().toString().equals("teacher@c11a") && TeacherPassword.getText().toString().equals("teacher@c11a")){
                    SharedPreferences.Editor editor=sharedPreferences20.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin20);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c11b") && TeacherPassword.getText().toString().equals("teacher@c11b")){
                    SharedPreferences.Editor editor=sharedPreferences21.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin21);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c11c") && TeacherPassword.getText().toString().equals("teacher@c11c")){
                    SharedPreferences.Editor editor=sharedPreferences22.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin22);
                    finish();
                }  else if(TeacherId.getText().toString().equals("teacher@c12a") && TeacherPassword.getText().toString().equals("teacher@c12a")){
                    SharedPreferences.Editor editor=sharedPreferences23.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin23);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c12b") && TeacherPassword.getText().toString().equals("teacher@c12b")){
                    SharedPreferences.Editor editor=sharedPreferences24.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin24);
                    finish();
                }else if(TeacherId.getText().toString().equals("teacher@c12c") && TeacherPassword.getText().toString().equals("teacher@c12c")){
                    SharedPreferences.Editor editor=sharedPreferences25.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherlogin25);
                    finish();
                }

                else if(TeacherId.getText().toString().equals("admin@dsebst") && TeacherPassword.getText().toString().equals("admin")){
                    SharedPreferences.Editor editor=sharedPreferences26.edit();
                    editor.putString("TeacherId", String.valueOf(TeacherId));
                    editor.putString("TeacherPassword",String.valueOf(TeacherPassword));
                    editor.commit();
                    startActivity(teacherloginadmin);
                    finish();
            }
        }
        });
    }}