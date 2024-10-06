package com.example.ch14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        // 取得SharedPreferences的設定資料
        prefs=getSharedPreferences("MyPref",MODE_PRIVATE);
        convertTemperature();
    }
    // 轉換溫度
    private void convertTemperature() {
        int c;
        double f = 0.0;
        // 取得SharedPreferences的設定資料
        String str = prefs.getString("TEMPC", "100");
        c = Integer.parseInt(str);
        // 攝氏轉華氏的公式
        f = (9.0 * c) / 5.0 + 32.0;
        // 顯示華氏溫度
        TextView o = (TextView) findViewById(R.id.lblOutput);
        o.setText("華氏溫度: " + Double.toString(f));
    }
}