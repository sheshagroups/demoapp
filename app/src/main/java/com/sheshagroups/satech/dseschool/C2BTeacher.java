package com.sheshagroups.satech.dseschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class C2BTeacher extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    InterstitialAd mInterstitialAd;
    AdView adView;
    CardView addstudent,uploadcw,uploadhw,uploaddpp,uploaddiary,addnotification,attendance,logout,updatestudent,application,library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_bteacher);
        adView = findViewById(R.id.adView);
        addstudent=findViewById(R.id.addstudent);
        uploadcw=findViewById(R.id.upload_cw);
        uploadhw=findViewById(R.id.upload_hw);
        uploaddpp=findViewById(R.id.upload_dpp);
        uploaddiary=findViewById(R.id.add_diary);
        addnotification=findViewById(R.id.add_notification);
        updatestudent=findViewById(R.id.updatestudent);
        logout=findViewById(R.id.logout_teacher);
        application = findViewById(R.id.application);
        library = findViewById(R.id.upload_library);
        sharedPreferences=getSharedPreferences("login1",MODE_PRIVATE);
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
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        Intent cwpdf = new Intent(C2BTeacher.this,TeacherLogin.class);
                        startActivity(cwpdf);
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
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C2BTeacher.this,C2B_Addstudent.class);
                startActivity(intent);
            }
        });
        uploadcw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_UploadCW.class);
                startActivity(cwpdf);
            }
        });
        uploadhw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_UploadHW.class);
                startActivity(cwpdf);
            }
        });
        uploaddpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_UploadDpp.class);
                startActivity(cwpdf);
            }
        });
        uploaddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_UploadDiary.class);
                startActivity(cwpdf);
            }
        });
        addnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_AddNotification.class);
                startActivity(cwpdf);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd!=null){
                    mInterstitialAd.show(C2BTeacher.this);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent cwpdf = new Intent(C2BTeacher.this,TeacherLogin.class);
                    startActivity(cwpdf);
                    finish();
                }
                else{
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent cwpdf = new Intent(C2BTeacher.this,TeacherLogin.class);
                    startActivity(cwpdf);
                    finish();
                }
            }
        });
        updatestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2BStudentTeacherLogin.class);
                startActivity(cwpdf);
            }
        });
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,Application_C2B.class);
                startActivity(cwpdf);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwpdf = new Intent(C2BTeacher.this,C2B_Upload_Library.class);
                startActivity(cwpdf);
            }
        });
    }
    }
