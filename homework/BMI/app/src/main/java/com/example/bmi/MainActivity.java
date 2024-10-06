package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void button_click(View view)
    {
        EditText height_input = findViewById(R.id.height_input), weight_input = findViewById(R.id.weight_input);
        double height = Double.parseDouble(height_input.getText().toString()), weight = Double.parseDouble(weight_input.getText().toString());
        TextView output = findViewById(R.id.output);
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        output.setText("您的BMI是: " + numberFormat.format(weight / Math.pow(height / 100, 2)));
    }

    public void button2_click(View view)
    {
        EditText height_input = findViewById(R.id.height_input), weight_input = findViewById(R.id.weight_input);
        TextView output = findViewById(R.id.output);

        height_input.getText().clear();
        weight_input.getText().clear();
        output.setText("");
    }
}
