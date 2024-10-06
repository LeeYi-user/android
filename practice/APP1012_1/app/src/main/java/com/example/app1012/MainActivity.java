package com.example.app1012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    float size = 20;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        output.setTextSize(this.size);
        Button zoom_in = findViewById(R.id.zoom_in);
        Button zoom_out = findViewById(R.id.zoom_out);

        zoom_in.setOnClickListener(this);
        zoom_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.zoom_in)
        {
            size++;
        }
        else
        {
            size--;
        }

        output.setTextSize(size);
    }
}
