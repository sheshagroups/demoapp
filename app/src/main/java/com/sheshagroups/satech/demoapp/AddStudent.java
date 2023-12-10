package com.sheshagroups.satech.demoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.checkerframework.checker.units.qual.C;

public class AddStudent extends AppCompatActivity {
    FirebaseAuth auth;
    EditText name,Sclass,section,rollno,fname,mname,mobile,fee,address;
    Button add;
    ImageView upload;
    String imageURL;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.Name);
        Sclass = findViewById(R.id.Sclass);
        section = findViewById(R.id.section);
        rollno = findViewById(R.id.RollNo);
        fname = findViewById(R.id.FatherName);
        mname = findViewById(R.id.MotherName);
        mobile = findViewById(R.id.MobileNo);
        fee = findViewById(R.id.FeeSubmitted);
        address = findViewById(R.id.Address);
        add = findViewById(R.id.addButton);
        upload = findViewById(R.id.uploadimage);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            upload.setImageURI(uri);
                        } else{
                            Toast.makeText(AddStudent.this,"No Image Selected",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


    }

    public void saveData(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Student Image")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(AddStudent.this);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageURL = urlImage.toString();
                uploadData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });
    }

    public void uploadData() {

        String Sname = name.getText().toString();
        String SSclass = Sclass.getText().toString();
        String Ssection = section.getText().toString();
        String Srollno = rollno.getText().toString();
        String Sfname = fname.getText().toString();
        String Smname = mname.getText().toString();
        String Smobile = mobile.getText().toString();
        String Sfee = fee.getText().toString();
        String Saddress = address.getText().toString();

        DataClass1 dataClass1 = new DataClass1(Sname,SSclass,Ssection,Srollno,Sfname,Smname,Smobile,Sfee,Saddress,imageURL);

        FirebaseDatabase.getInstance().getReference("Class 1st A").child(Sname)
                .setValue(dataClass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AddStudent.this,"Student Added",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddStudent.this, e.getMessage().toString(),Toast.LENGTH_SHORT).show();

                    }
                });

    }
}