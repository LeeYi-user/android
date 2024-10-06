package com.example.app1026;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinner);
        tv = findViewById(R.id.textview);
    }

    public void buttonClick(View view)
    {
        String[] steaks = getResources().getStringArray(R.array.steaks);
        int index = sp.getSelectedItemPosition();
        tv.setText("Steak: " + steaks[index]);
    }
}
