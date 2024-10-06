package com.example.ch7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner sp1, sp2;
    private String[] desserts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] courses = {"美式漢堡", "特選牛排", "牛肉飯", "義大利麵"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 主餐的Spinner元件
        sp1 = (Spinner) findViewById(R.id.spinner);
        // 建立ArrayAdapter接合器物件
        ArrayAdapter<String> a1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courses);
        sp1.setAdapter(a1);  // 指定接合器物件
        // 甜點的Spinner元件
        desserts = getResources().getStringArray(R.array.dessert);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> a2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, desserts);
        sp2.setAdapter(a2);
    }
    public void button_Click(View view) {
        // 取得使用者的選擇
        String main = sp1.getSelectedItem().toString();
        String dessert = sp2.getSelectedItem().toString();
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("主餐: " + main + "\n甜點: " + dessert);
    }
}
