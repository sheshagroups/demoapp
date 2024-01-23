package com.sheshagroups.satech.dseschool;

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

public class C2B_Addstudent extends AppCompatActivity {
    FirebaseAuth auth;
    EditText name,Sclass,section,rollno,fname,mname,mobile,fee,address,studentid,studentpass,sstudentteacherid,sstudentteacherpassword,attendance;
    Button add;
    ImageView upload;
    String imageURL;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_baddstudent);
        name = findViewById(R.id.C1BName);
        Sclass = findViewById(R.id.C1Bclass);
        section = findViewById(R.id.C1Bsection);
        rollno = findViewById(R.id.C1BRollNo);
        fname = findViewById(R.id.C1BFatherName);
        mname = findViewById(R.id.C1BMotherName);
        mobile = findViewById(R.id.C1BMobileNo);
        fee = findViewById(R.id.C1BFeeSubmitted);
        address = findViewById(R.id.C1BAddress);
        studentid = findViewById(R.id.C1BStudentId);
        studentpass = findViewById(R.id.C1BStudentPassword);
        sstudentteacherpassword = findViewById(R.id.C1BStudentTeacherPassword);
        attendance = findViewById(R.id.C1Battendance);
        add = findViewById(R.id.C1BaddButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addstudent();
            }
        });
    }
    public boolean validation(){
        String Name=name.getText().toString();
        String Class=Sclass.getText().toString();
        String Section=section.getText().toString();
        String Rollno=rollno.getText().toString();
        String Studentid=studentid.getText().toString();
        String Studentpass=studentpass.getText().toString();
        String FName=fname.getText().toString();
        String MName=mname.getText().toString();
        String Mobile=mobile.getText().toString();
        String Address=address.getText().toString();
        String Teacherpass=sstudentteacherpassword.getText().toString();
        if (Name.isEmpty()){
            name.setError("NAme can't be Empty");
        } else if (Class.isEmpty()) {
            Sclass.setError("Class can't be Empty");
        }else if (Section.isEmpty()) {
            section.setError("Class can't be Empty");
        }else if (Rollno.isEmpty()) {
            rollno.setError("Class can't be Empty");
        }else if (Studentid.isEmpty()) {
            studentid.setError("Class can't be Empty");
        }else if (Studentpass.isEmpty()) {
            studentpass.setError("Class can't be Empty");
        }else if (FName.isEmpty()) {
            fname.setError("Class can't be Empty");
        }else if (MName.isEmpty()) {
            mname.setError("Class can't be Empty");
        }else if (Mobile.isEmpty()) {
            mobile.setError("Class can't be Empty");
        }else if (Address.isEmpty()) {
            address.setError("Class can't be Empty");
        }else if (Teacherpass.isEmpty()) {
            sstudentteacherpassword.setError("Class can't be Empty");
        }
        return false;
    }
    public void addstudent(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Class 2B");
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
        String SstudentTeacherPassword = sstudentteacherpassword.getText().toString();
        String SAttendance = attendance.getText().toString();

        HelperClass1 helperClass1 = new HelperClass1(Sname,SSclass,Ssection,Srollno,Sfname,Smname,Smobile,Sfee,Saddress,Sstudentid,Sstudentpass,SstudentTeacherPassword,SAttendance);
        reference.child(Sstudentid).setValue(helperClass1);
        Toast.makeText(C2B_Addstudent.this,"Student Added",Toast.LENGTH_SHORT).show();
        empty();

    }
    public void empty(){
        name.setText("");
        Sclass.setText("");
        section.setText("");
        rollno.setText("");
        studentid.setText("");
        studentpass.setText("");
        fname.setText("");
        mname.setText("");
        mobile.setText("");
        address.setText("");
        sstudentteacherpassword.setText("");
        fee.setText("");
        attendance.setText("");
    }
}