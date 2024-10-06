package com.example.ch10_3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Ch10_3_3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity:onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity:onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity:onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity:onStop");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity:onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity:onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity:onDestroy");
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:25.04692437135412,121.5161783959678"));
        startActivity(i);
    }
    public void button2_Click(View view) {
        finish();
    }
}