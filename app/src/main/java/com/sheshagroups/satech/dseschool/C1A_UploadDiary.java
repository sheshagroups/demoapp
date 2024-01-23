package com.sheshagroups.satech.dseschool;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class C1A_UploadDiary extends AppCompatActivity {

    Button uploadcw;
    EditText uploadET;
    ImageView upload;
    InterstitialAd mInterstitialAd;
    final private DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Uploaded Diary C1A");
    final private StorageReference storageReference = FirebaseStorage.getInstance().getReference("C1A Diary");

    Uri imageUri;
    ProgressBar progress;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_aupload_diary);
        progress=findViewById(R.id.progress);
        uploadcw = findViewById(R.id.uploadcw);
        upload = findViewById(R.id.upload);
        uploadET = findViewById(R.id.uploadET);
        adView = findViewById(R.id.adView);
        MobileAds.initialize(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            imageUri = data.getData();
                            upload.setImageURI(imageUri);
                        }else {
                            Toast.makeText(C1A_UploadDiary.this,"No Image Selected",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        uploadcw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri != null){
                    uploadToFirebase(imageUri);
                }else{
                    Toast.makeText(C1A_UploadDiary.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadToFirebase(Uri uri){
        String caption = uploadET.getText().toString();
        final StorageReference imageReference = storageReference.child(System.currentTimeMillis()+"."+getFileExtention(uri));

        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        DiaryData diaryData = new DiaryData(uri.toString(),caption);
                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(diaryData);
                        progress.setVisibility(View.INVISIBLE);
                        Toast.makeText(C1A_UploadDiary.this,"Uploaded",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                progress.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progress.setVisibility(View.INVISIBLE);
                Toast.makeText(C1A_UploadDiary.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtention(Uri fieluri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fieluri));
    }
}