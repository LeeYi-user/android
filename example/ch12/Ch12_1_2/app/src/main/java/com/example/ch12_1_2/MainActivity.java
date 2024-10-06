package com.example.ch12_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    private EditText txtUrl;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webView);
        // 初始WebView元件
        web.getSettings().setJavaScriptEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.setWebViewClient(new myWebViewClient());
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view,int progress) {
                progressBar.setProgress(progress);
                super.onProgressChanged(view, progress);
            }
        });
        // 取得EditText元件
        txtUrl = (EditText) findViewById(R.id.txtURL);
        String strUrl = txtUrl.getText().toString();
        web.loadUrl(strUrl);   // 載入網頁
    }
    // 宣告繼承WebViewClient的類別
    class myWebViewClient extends WebViewClient {
        @SuppressWarnings("deprecation")
        @Override          // 舊版本
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            web.loadUrl(url);
            return true;
        }
        @TargetApi(Build.VERSION_CODES.N)
        @Override          // 目標API 24以上版本
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            web.loadUrl(request.getUrl().toString());
            return true;
        }
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        String strUrl = txtUrl.getText().toString();
        web.loadUrl(strUrl);
    }
    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {  // 是否有上一頁
            web.goBack();       // 移至上一頁
            return;
        }
        super.onBackPressed();
    }
}
