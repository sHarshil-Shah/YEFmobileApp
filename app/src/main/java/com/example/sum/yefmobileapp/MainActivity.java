package com.example.sum.yefmobileapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {

    //Webview for yef screen
    private WebView mWebView = null;
    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Firebase reference1, reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("activity", "In Main Activity");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_yef_logo_round);

        mWebView = findViewById(R.id.updates_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setAppCacheMaxSize(50 * 1024 * 1024); // 50MB
        webSettings.setJavaScriptEnabled(true);

        if (savedInstanceState == null) {

            mWebView.loadUrl("https://www.yefindia.in/our-initiatives");
        }

        mWebView.setWebViewClient(new HelloWebViewClient());

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuchatwithus:
                startActivity(new Intent(MainActivity.this, Register.class));
                return true;

            case R.id.menu_volunteer:
                startActivity(new Intent(MainActivity.this, VolunteerActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
//If there is history, then the canGoBack method will return ‘true’//
            return true;
        }

//Default behaviour
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWebView.clearCache(true);
        mWebView.clearHistory();
    }


    public class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().contains("yefindia.in")) {

//If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
//will return ‘false” and the URL will be loaded inside your WebView//
                return false;
            }

//If the URL doesn’t contain this string, then it’ll return “true.” At this point, we’ll
//launch the user’s preferred browser, by firing off an Intent//
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            ProgressBar progressBar = findViewById(R.id.progressBar1);
            progressBar.setVisibility(View.GONE);
        }
    }

}



