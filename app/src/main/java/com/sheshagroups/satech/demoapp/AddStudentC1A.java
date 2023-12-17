package com.sheshagroups.satech.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentC1A extends AppCompatActivity {

    FirebaseAuth auth;
    EditText name,Sclass,section,rollno,fname,mname,mobile,fee,address,studentid,studentpass;
    Button add;
    ImageView upload;
    String imageURL;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_c1a);

        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.C1AName);
        Sclass = findViewById(R.id.C1Aclass);
        section = findViewById(R.id.C1Asection);
        rollno = findViewById(R.id.C1ARollNo);
        fname = findViewById(R.id.C1AFatherName);
        mname = findViewById(R.id.C1AMotherName);
        mobile = findViewById(R.id.C1AMobileNo);
        fee = findViewById(R.id.C1AFeeSubmitted);
        address = findViewById(R.id.C1AAddress);
        studentid = findViewById(R.id.C1AStudentId);
        studentpass = findViewById(R.id.C1AStudentPassword);
        add = findViewById(R.id.C1AaddButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Class 1A");
                String Sname = name.getText().toString();
                String SSclass = Sclass.getText().toString();
                String Ssection = section.getText().toString();
                String Srollno = rollno.getText().toString();
                String Sfname = fname.getText().toString();
                String Smname = mname.getText().toString();
                String Smobile = mobile.getText().toString();
                String Sfee = fee.getText().toString();
                String Saddress = address.getText().toString();
                String Sstudentid = studentid.getText().toString();
                String Sstudentpass = studentpass.getText().toString();


                HelperClass1 helperClass1 = new HelperClass1(Sname,SSclass,Ssection,Srollno,Sfname,Smname,Smobile,Sfee,Saddress,Sstudentid,Sstudentpass);
                reference.child(Sname).setValue(helperClass1);

                Toast.makeText(AddStudentC1A.this,"Student Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
}