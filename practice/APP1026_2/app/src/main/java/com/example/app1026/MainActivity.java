package com.example.app1026;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText op1, op2;
    private TextView output;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);

        output = findViewById(R.id.output);
        sp = findViewById(R.id.spinner);

        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int v1, v2;
        double r = 0.0;

        v1 = Integer.parseInt(op1.getText().toString());
        v2 = Integer.parseInt(op2.getText().toString());

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

        output.setText("Result = " + r);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
