package com.example.ch14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private EditText txtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得SharedPreferences物件
        prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        // 取得EditText元件
        txtC = (EditText) findViewById(R.id.txtC);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 取得偏好設定資料
        String tempc = prefs.getString("TEMPC" , "100");
        txtC.setText(tempc);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // 取得Editor物件
        SharedPreferences.Editor prefEdit = prefs.edit();
        // 存入偏好設定資料至Editor物件
        prefEdit.putString("TEMPC", txtC.getText().toString());
        prefEdit.commit(); // 確認寫入檔案
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 建立Intent物件
        Intent intent=new Intent(this, FActivity.class);
        startActivity(intent);     // 啟動活動
    }
}