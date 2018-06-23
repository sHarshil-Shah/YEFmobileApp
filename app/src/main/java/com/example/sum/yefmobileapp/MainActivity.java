package com.example.sum.yefmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("activity", "In Main Activity");

        final ViewPager viewPager=findViewById(R.id.viewPager);
        Comunicator comunicator=new Comunicator(getSupportFragmentManager());
        viewPager.setAdapter(comunicator);
        viewPager.setCurrentItem(0);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_yef_logo_round);

        findViewById(R.id.txtGeneral).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        findViewById(R.id.txtSkills).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;

    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {

                case R.id.menuchatwithus:
                    startActivity(new Intent(MainActivity.this, chat.class));
                    return true;
                case R.id.menuaboutus:
                    startActivity(new Intent(MainActivity.this, aboutus.class));
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }


}
