package com.sheshagroups.satech.demoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;

import java.io.InputStream;
import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    ImageView browse;
    Button upload;
    Uri filepath;
    Bitmap bitmap;
    ArrayList<Uri> ChooseImageList;
    RecyclerView recyclerView;
    private static final int IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        browse=findViewById(R.id.upload_icon);
        upload = findViewById(R.id.uploadimage);
        recyclerView=findViewById(R.id.image_view);
        ChooseImageList=new ArrayList<>();

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                startActivityForResult(intent,IMAGE_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMAGE_CODE && resultCode==RESULT_OK){
            if (data.getClipData() != null){
                Toast.makeText(this,"Multiple",Toast.LENGTH_SHORT).show();
            }else if (data.getData() !=  null){
                Toast.makeText(this,"single",Toast.LENGTH_SHORT).show();
            }
        }
    }
}