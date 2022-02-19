package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;



public class SplashActivity extends AppCompatActivity {

    ProgressBar splashProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashProgress = findViewById(R.id.splashProgress);
        ObjectAnimator.ofInt(splashProgress, "progress", 100).setDuration(5000).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
                boolean sesion=preferences.getBoolean("sesion",false);
                if (sesion){
                    Intent intent = new Intent(getApplicationContext(),MenuPrincipal.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        }, 5000);
    }
}