package com.example.ch7_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view) {
        String[] Steaks = getResources().getStringArray(R.array.steaks);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        int index = sp.getSelectedItemPosition();
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("牛排要" + Steaks[index]);
    }
}
