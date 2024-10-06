package com.example.app1123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void button2_click(View view)
    {
        int opd1, opd2;
        double result = 0.0;
        RadioButton rdbAdd, rdbSub, rdbMult, rdbDivide;
        CheckBox check;
        Bundle bundle = this.getIntent().getExtras();

        if (bundle == null)
        {
            return;
        }

        opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
        opd2 = Integer.parseInt(bundle.getString("OPERAND02"));

        rdbAdd = findViewById(R.id.Add);
        if (rdbAdd.isChecked())
        {
            result = opd1 + opd2;
        }

        rdbSub = findViewById(R.id.Sub);
        if (rdbSub.isChecked())
        {
            result = opd1 - opd2;
        }

        rdbMult = findViewById(R.id.Mult);
        if (rdbMult.isChecked())
        {
            result = opd1 * opd2;
        }

        rdbDivide = findViewById(R.id.Divide);
        if (rdbDivide.isChecked())
        {
            check = findViewById(R.id.checkBox);
            if (check.isChecked())
            {
                result = opd1 / opd2;
            }
            else
            {
                result = opd1 / (double) opd2;
            }
        }

        Intent rintent = new Intent();
        Bundle rbundle = new Bundle();

        rbundle.putDouble("RESULT", result);
        rintent.putExtras(rbundle);
        setResult(RESULT_OK, rintent);
        finish();
    }
}
