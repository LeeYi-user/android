package com.example.ch7_3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    private ListView lv;
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得字串陣列的城巿名犒陣列
        cities = getResources().getStringArray(R.array.cities);
        // 建立ArrayAdapter物件
        ArrayAdapter<String> a = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cities);
        // 取得ListView元件
        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(a);
        lv.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("你是住在: " + cities[position]);
    }
}