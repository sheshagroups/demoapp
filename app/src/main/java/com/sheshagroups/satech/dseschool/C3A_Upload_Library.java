package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class C3A_Upload_Library extends AppCompatActivity {
    Button uploadcw;
    EditText uploadET;
    ImageView upload;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    Uri pdfUri;
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_aupload_library);
        uploadcw = findViewById(R.id.uploadcw);
        upload = findViewById(R.id.upload);
        uploadET = findViewById(R.id.uploadET);
        FirebaseApp.initializeApp(C3A_Upload_Library.this);
        storageReference = FirebaseStorage.getInstance().getReference("C3A Library");
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploaded Library C3A");
        adView = findViewById(R.id.adView);
        MobileAds.initialize(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        uploadcw.setEnabled(false);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });
    }private void selectPDF(){
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            uploadcw.setEnabled(true);
            uploadET.setText(data.getDataString()
                    .substring(data.getDataString().lastIndexOf("/")+1));

            uploadcw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadPDFFile(data.getData());
                }
            });
        }
    }
    private void uploadPDFFile(Uri data){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("File is Loading..");
        progressDialog.show();

        StorageReference reference = storageReference.child("HW PDF C1A"+ UUID.randomUUID().toString()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri = uriTask.getResult();
                CWFileModel cwFileModel = new CWFileModel(uploadET.getText().toString(),uri.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(cwFileModel);
                Toast.makeText(C3A_Upload_Library.this,"File Uploaded",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("File Uploading..."+(int) progress+"%");
            }
        });
    }
}