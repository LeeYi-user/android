package com.example.app1123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        convertTempture();
    }

    private void convertTempture()
    {
        int c;
        double f = 0.0;
        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null)
        {
            c = Integer.parseInt(bundle.getString("TEMPC"));
            f = (9.0 * c) / 5.0 + 32.0;
            TextView o = findViewById(R.id.textView);
            o.setText("華氏溫度: " + Double.toString(f));
        }
    }
}
