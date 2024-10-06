package com.example.app1012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.rgGender);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        TextView output = findViewById(R.id.lblOutput);

        switch (i)
        {
            case R.id.rdbBoy:
                RadioButton boy = findViewById(R.id.rdbBoy);
                output.setText(boy.getText());
                break;
            case R.id.rdbGirl:
                RadioButton girl = findViewById(R.id.rdbGirl);
                output.setText(girl.getText());
                break;
        }
    }
}
