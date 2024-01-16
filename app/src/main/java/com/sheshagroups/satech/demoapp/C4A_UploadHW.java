package com.sheshagroups.satech.demoapp;

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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class C4A_UploadHW extends AppCompatActivity {
    Button uploadcw;
    EditText uploadET;
    ImageView upload;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    Uri pdfUri;
    LinearProgressIndicator progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4_aupload_hw);
        uploadcw = findViewById(R.id.uploadcwc1b);
        upload = findViewById(R.id.uploadc1b);
        uploadET = findViewById(R.id.uploadETc1b);
        FirebaseApp.initializeApp(C4A_UploadHW.this);
        storageReference = FirebaseStorage.getInstance().getReference("C4A HW");
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploaded HW C4A");

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

        StorageReference reference = storageReference.child("CW PDF C1A"+ UUID.randomUUID().toString()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri = uriTask.getResult();
                CWFileModel cwFileModel = new CWFileModel(uploadET.getText().toString(),uri.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(cwFileModel);
                Toast.makeText(C4A_UploadHW.this,"File Uploaded",Toast.LENGTH_SHORT).show();
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
