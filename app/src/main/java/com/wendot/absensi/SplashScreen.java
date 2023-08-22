package com.wendot.absensi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.wendot.absensi.model.SessionManager;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashscreen();
    }

    private void splashscreen() {
        SessionManager sessionManager = new SessionManager(SplashScreen.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sessionManager.checkLogin();
            }
        },5000);
    }

}