package com.example.app1019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = findViewById(R.id.main);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://chatapp.khes60122.repl.co/");
    }
}
