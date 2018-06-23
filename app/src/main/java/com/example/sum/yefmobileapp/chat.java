package com.example.sum.yefmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        (Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);

        Log.d("activity", "In Chat Activity");

    }
}
