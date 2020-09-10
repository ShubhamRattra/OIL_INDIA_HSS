package com.rattra.navigationdrawertechno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NoticeActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        webView = findViewById(R.id.web_notice);

        WebSettings webSettings = webView.getSettings();
        webSettings.setAllowFileAccess(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.setWebChromeClient(new WebChromeClient());


        webView = findViewById(R.id.web_notice);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://drive.google.com/folderview?id=1bmKGSNpDKInmYFl8oYasESeozl-zw71f");

    }

    //Code For Back Button
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
            Toast.makeText(this,"Opening Study material",Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
            Toast.makeText(this,"Closing Study material",Toast.LENGTH_SHORT).show();
        }
    }
}