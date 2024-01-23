package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class C8A_Home extends AppCompatActivity {
    SharedPreferences sharedPreferences, sharedPreferences1;
    CardView student_detail, student_cw, student_hw, student_dpp, student_diary,
            student_notification, student_fees, student_logout, aboutschool, contactus, library,application;
    ImageView pdf,imp;
    AdView adView;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c8_ahome);
        adView = findViewById(R.id.adView);
        student_detail = findViewById(R.id.addstudent);
        student_cw = findViewById(R.id.upload_cw);
        student_hw = findViewById(R.id.upload_hw);
        student_dpp = findViewById(R.id.upload_dpp);
        student_diary = findViewById(R.id.add_diary);
        student_notification = findViewById(R.id.add_notification);
        student_fees = findViewById(R.id.fees);
        student_logout = findViewById(R.id.logout_teacher);
        aboutschool = findViewById(R.id.aboutschool);
        contactus = findViewById(R.id.contactus);
        library = findViewById(R.id.library);
        application = findViewById(R.id.upload_application);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sharedPreferences1 = getSharedPreferences("student", MODE_PRIVATE);
        pdf = findViewById(R.id.pdf);
        imp = findViewById(R.id.impt);
        adView = findViewById(R.id.adView);
        MobileAds.initialize(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        InterstitialAd.load(this, getString(R.string.inter_ad_unit_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e("Error",loadAdError.toString());
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                mInterstitialAd = interstitialAd;

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        Intent logout = new Intent(C8A_Home.this, LoginPage.class);
                        startActivity(logout);
                        finish();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        super.onAdFailedToShowFullScreenContent(adError);
                    }

                    @Override
                    public void onAdImpression() {
                        super.onAdImpression();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent();
                        mInterstitialAd = null;
                    }
                });
            }
        });
        student_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStudentData();
            }
        });
        student_cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Classwork.class);
                startActivity(cwpdf);
            }
        });
        student_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Homework.class);
                startActivity(cwpdf);
            }
        });
        student_dpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_DPP.class);
                startActivity(cwpdf);
            }
        });
        student_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Diary.class);
                startActivity(cwpdf);
            }
        });

        student_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Fees.class);
                startActivity(cwpdf);
            }
        });
        student_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Notification.class);
                startActivity(cwpdf);
            }
        });

        student_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd!=null){
                    mInterstitialAd.show(C8A_Home.this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent logout = new Intent(C8A_Home.this, LoginPage.class);
                    startActivity(logout);
                    finish();
                }
                else{
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent logout = new Intent(C8A_Home.this, LoginPage.class);
                    startActivity(logout);
                    finish();
                }
            }
        });

        aboutschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, AboutSchool.class);
                startActivity(cwpdf);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, ContactUs.class);
                startActivity(cwpdf);
            }
        });

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Library.class);
                startActivity(cwpdf);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, C8A_Upload_Application.class);
                startActivity(cwpdf);
            }
        });
        imp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, Important.class);
                startActivity(cwpdf);
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C8A_Home.this, Document.class);
                startActivity(cwpdf);
            }
        });
    }
    public void showStudentData(){

        Intent ihome = getIntent();
        String sname = ihome.getStringExtra("name");
        String sclass = ihome.getStringExtra("class");
        String ssection = ihome.getStringExtra("section");
        String srollno = ihome.getStringExtra("rollno");
        String sstudentid = ihome.getStringExtra("studentid");
        String sfname = ihome.getStringExtra("fname");
        String smname = ihome.getStringExtra("mname");
        String smobile = ihome.getStringExtra("mobile");
        String sfee = ihome.getStringExtra("fee");
        String saddress = ihome.getStringExtra("address");
        String sattendance = ihome.getStringExtra("attendance");

        Intent profile = new Intent(C8A_Home.this,C8A_StudentDetail.class);
        profile.putExtra("Name",sname);
        profile.putExtra("Class",sclass);
        profile.putExtra("Section",ssection);
        profile.putExtra("Studentid",sstudentid);
        profile.putExtra("Rollno",srollno);
        profile.putExtra("Fname",sfname);
        profile.putExtra("Mname",smname);
        profile.putExtra("Mobile",smobile);
        profile.putExtra("Address",saddress);
        profile.putExtra("Fee",sfee);
        profile.putExtra("Attendance",sattendance);
        startActivity(profile);
    }
}