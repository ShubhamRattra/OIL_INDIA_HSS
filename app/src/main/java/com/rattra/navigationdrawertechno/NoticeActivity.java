package com.rattra.navigationdrawertechno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
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
        webSettings.setJavaScriptEnabled(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.clearCache(true);
        webView.clearHistory();
        // webView.setWebChromeClient(new client());


        webView = findViewById(R.id.web_notice);

        webView.setWebViewClient(new client());

        webView.loadUrl("https://drive.google.com/folderview?id=1bmKGSNpDKInmYFl8oYasESeozl-zw71f");


        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {

                DownloadManager.Request req = new DownloadManager.Request(Uri.parse(url));
                req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                DownloadManager dm = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);

                Toast.makeText(getApplicationContext(),"Downloading started ......",Toast.LENGTH_SHORT).show();
            }
        });

    }


private class client extends WebViewClient{
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }
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