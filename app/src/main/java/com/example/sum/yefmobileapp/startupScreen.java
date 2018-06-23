package com.example.sum.yefmobileapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


public class startupScreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
        getSupportActionBar().hide();

        new CountDownTimer(2500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                getSupportActionBar().show();
                //set the new Content of your activity
            }
        }.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(startupScreen.this, MainActivity.class));

            }
        }, 2500);

        Log.d("activity", "In StartUp Activity");

    }

}

