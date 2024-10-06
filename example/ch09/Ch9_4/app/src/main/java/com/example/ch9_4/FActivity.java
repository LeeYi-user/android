package com.example.ch9_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        convertTempture();
    }
    // 轉換溫度
    private void convertTempture() {
        int c;
        double f = 0.0;
        // 取得傳遞的資料
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            c = Integer.parseInt(bundle.getString("TEMPC"));
            // 攝氏轉華氏的公式
            f = (9.0 * c) / 5.0 + 32.0;
            // 顯示華氏溫度
            TextView o = (TextView) findViewById(R.id.lblOutput);
            o.setText("華氏溫度: " + Double.toString(f));
        }
    }
}