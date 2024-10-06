package com.example.app1109;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] courses = {"美式漢堡", "特選牛排", "牛肉飯", "義大利麵"};
        sp1 = findViewById(R.id.spinner);
        ArrayAdapter<String> a1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        sp1.setAdapter(a1);

        desserts = getResources().getStringArray(R.array.dessert);
        sp2 =  findViewById(R.id.spinner2);
        ArrayAdapter<String> a2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, desserts);
        sp2.setAdapter(a2);
    }

    public void button_click(View view)
    {
        String main = sp1.getSelectedItem().toString();
        String dessert = sp2.getSelectedItem().toString();
        TextView output = findViewById(R.id.lblOutput);
        output.setText("主餐: " + main + "\n甜點: " + dessert);
    }
}
