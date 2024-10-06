package com.example.ch8_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("關於本書");  // 標題文字
        // 指定對話方塊訊息文字
        builder.setMessage("Android程式設計\n作者: 陳會安");
        builder.setCancelable(true);
        // 設定按鈕和事件處理程序
        builder.setPositiveButton("確定", null);
        builder.show();  // 顯示對話方塊
    }
}