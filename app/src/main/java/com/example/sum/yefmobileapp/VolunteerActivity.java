package com.example.sum.yefmobileapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.util.Objects;

public class VolunteerActivity extends AppCompatActivity {

    //Webview for volunteer form
    private WebView volunteerWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Volunteer");

        Log.d("activity", "In Volunteer Activity");
        volunteerWebView = (WebView) findViewById(R.id.volunteer_webview);
        WebSettings webSettings = volunteerWebView.getSettings();
        webSettings.setAppCacheMaxSize( 50 * 1024 * 1024 ); // 50MB
        webSettings.setJavaScriptEnabled(true);
        if (savedInstanceState == null) {

            volunteerWebView.loadUrl("https://www.yefindia.in/get-involved/volunteer");
        }

        volunteerWebView.setWebViewClient(new HelloWebViewClient());



    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        volunteerWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        volunteerWebView.restoreState(savedInstanceState);
    }

    @Override

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && volunteerWebView.canGoBack()) {
            volunteerWebView.goBack();
//If there is history, then the canGoBack method will return ‘true’//
            return true;
        }

//Default behaviour
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        volunteerWebView.clearCache(true);
        volunteerWebView.clearHistory();
    }


    public class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().contains("yefindia.in")) {

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
            ProgressBar progressBar = findViewById(R.id.progressBar2);
            progressBar.setVisibility(View.GONE);
        }
    }
}
