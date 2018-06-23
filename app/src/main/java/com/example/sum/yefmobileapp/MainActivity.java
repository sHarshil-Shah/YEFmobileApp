package com.example.sum.yefmobileapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("activity","In Main Activity");
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId()){
            case R.id.menuhome:
                Toast.makeText(this,"Home Clicked",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menuchatwithus:
                Toast.makeText(this,"Chat Clicked",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, chat.class));
                return true;
            case R.id.menuaboutus:
                Toast.makeText(this,"About Us Clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, aboutus.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
