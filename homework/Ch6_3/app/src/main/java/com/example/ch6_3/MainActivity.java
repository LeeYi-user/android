package com.example.ch6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imgOutput);
        RadioGroup rg = findViewById(R.id.rgImages);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.rdbDog:
                image.setImageResource(R.mipmap.dog);
                break;
            case R.id.rdbElephant:
                image.setImageResource(R.mipmap.elephant);
                break;
            case R.id.rdbMouse:
                image.setImageResource(R.mipmap.mouse);
                break;
            case R.id.rdbRabbit:
                image.setImageResource(R.mipmap.rabbit);
                break;
        }
    }
}
