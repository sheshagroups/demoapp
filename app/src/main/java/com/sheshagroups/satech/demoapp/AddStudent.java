package com.sheshagroups.satech.demoapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddStudent extends AppCompatActivity {
    FirebaseAuth auth;
    EditText name,Sclass,section,rollno,fname,mname,mobile,fee,address;
    Button add;
    ImageView upload;
    String imageURL;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference reference;
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

        /*

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

        */


// Main Code Down

        /*
         add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String Sname = name.getText().toString();
                String SSclass = Sclass.getText().toString();
                String Ssection = section.getText().toString();
                String Srollno = rollno.getText().toString();
                String Sfname = fname.getText().toString();
                String Smname = mname.getText().toString();
                String Smobile = mobile.getText().toString();
                String Sfee = fee.getText().toString();
                String Saddress = address.getText().toString();
                String Sstudentid =

                HelperClass1 helperClass1 = new HelperClass1(Sname,SSclass,Ssection,Srollno,Sfname,Smname,Smobile,Sfee,Saddress,);
                reference.child(Sname).setValue(helperClass1);

                Toast.makeText(AddStudent.this,"Student Added",Toast.LENGTH_SHORT).show();
            }
        });


    }
    */

        // Main Code Up

    /*
    public void saveData(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Students")
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
                // pending
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });
    }

    public void uploadData(){
        String Sname = name.getText().toString();
        String SSclass = Sclass.getText().toString();
        String Ssection = section.getText().toString();
        String Srollno = rollno.getText().toString();
        String Sfname = fname.getText().toString();
        String Smname = mname.getText().toString();
        String Smobile = mobile.getText().toString();
        String Sfee = fee.getText().toString();
        String Saddress = address.getText().toString();

        DataClass1 dataClass1 = new DataClass1(Sname,SSclass,Ssection,Srollno,Sfname,Smname,Smobile,Sfee,Saddress);

        FirebaseDatabase.getInstance().getReference("users").child(Sname)
                .setValue(dataClass1);
        Toast.makeText(AddStudent.this,"Added Successfully",Toast.LENGTH_SHORT).show();
    }

     */

}}
