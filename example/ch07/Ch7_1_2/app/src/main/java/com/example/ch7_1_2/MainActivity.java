package com.example.ch7_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private EditText opd1, opd2;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得介面元件
        opd1 = (EditText) findViewById(R.id.txtOpd1);
        opd1.setText("100");
        opd2 = (EditText) findViewById(R.id.txtOpd2);
        opd2.setText("50");
        output = (TextView) findViewById(R.id.lblOutput);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        // 註冊傾聽者物件
        sp.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        int v1, v2;
        double r = 0.0;
        v1 = Integer.parseInt(opd1.getText().toString());
        v2 = Integer.parseInt(opd2.getText().toString());
        switch (position) {
            case 0:   // 加法
                r = v1 + v2;
                break;
            case 1:   // 減法
                r = v1 - v2;
                break;
            case 2:   // 乘法
                r = v1 * v2;
                break;
            case 3:   // 除法
                r = v1 / v2;
                break;
        }
        output.setText("運算結果 = " + r);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
