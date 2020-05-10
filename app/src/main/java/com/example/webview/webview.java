package com.example.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class webview extends AppCompatActivity {

    private WebView web; //自定义webview来加载URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        web = findViewById(R.id.web);
        String url=getIntent().getDataString();//用于接收url
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        web.loadUrl(url);//使用自定义的web去加载url
        web.setWebViewClient(new WebViewClient(){//使用自定义的web打开url
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                web.loadUrl(url);
                return true;
            }
        });
    }
}