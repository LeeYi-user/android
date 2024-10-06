package com.example.ch9_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 取得EditText元件
        EditText txtC = (EditText) findViewById(R.id.txtC);
        // 建立Intent物件
        Intent intent = new Intent(this, FActivity.class);
        // 建立傳遞資料的Bundle物件
        Bundle bundle = new Bundle();
        bundle.putString("TEMPC",txtC.getText().toString());
        intent.putExtras(bundle);  // 加上資料
        startActivity(intent);     // 啟動活動
    }
}
