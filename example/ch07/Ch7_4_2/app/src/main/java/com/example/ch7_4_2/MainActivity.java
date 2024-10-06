package com.example.ch7_4_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int tmp;
        double result;
        // 取得EditText元件
        EditText txtTemp = (EditText) findViewById(R.id.txtTemp);
        // 取得輸入值
        tmp = Integer.parseInt(txtTemp.getText().toString());
        switch(item.getItemId()) {
            case R.id.toF:
                // 攝氏轉華氏的公式
                result = (9.0 * tmp) / 5.0 + 32.0;
                output.setText("華氏溫度: " + result);
                break;
            case R.id.toC:
                // 華氏轉攝氏的公式
                result = (5.0 / 9.0 ) * (tmp - 32);
                output.setText("攝氏溫度: " + result);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}