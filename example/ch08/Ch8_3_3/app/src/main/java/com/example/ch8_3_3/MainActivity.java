package com.example.ch8_3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements DialogInterface.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        // 找到Button元件
        Button btn = (Button) findViewById(R.id.button);
        // 指定背景色彩
        switch(which){
            case 0: btn.setBackgroundColor(Color.RED);
                break;
            case 1: btn.setBackgroundColor(Color.YELLOW);
                break;
            case 2: btn.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    public void button_Click(View view) {
        // 建立對話方塊
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("選擇一個確認");
        // 建立選項陣列
        String[] options = {"紅色", "黃色", "綠色" };
        builder.setItems(options, this); // 指定選項
        builder.setNegativeButton("取消", null);
        builder.show(); // 顯示對話方塊
    }
}
