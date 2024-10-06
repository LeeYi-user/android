package com.example.app1116;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText opd1, opd2;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opd1 = findViewById(R.id.opd1);
        opd1.setText("100");
        opd2 = findViewById(R.id.opd2);
        opd2.setText("0");
        output = findViewById(R.id.output);
        Spinner sp = findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int v1, v2;
        double r = 0.0;

        try
        {
            v1 = Integer.parseInt(opd1.getText().toString());
            v2 = Integer.parseInt(opd2.getText().toString());

            switch (i)
            {
                case 0:
                    r = v1 + v2;
                    break;
                case 1:
                    r = v1 - v2;
                    break;
                case 2:
                    r = v1 * v2;
                    break;
                case 3:
                    r = v1 / v2;
                    break;
            }

            output.setText("運算結果 = " + r);
        }
        catch (Exception ex)
        {
            output.setText(ex.getMessage());
            Log.d("Ch8_1_2", "除以 0 的錯誤");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
