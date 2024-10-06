package com.example.app1019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    private TextView output;
    private EditText txt;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        rg = findViewById(R.id.gender);
        rg.setOnCheckedChangeListener(this);
        txt = findViewById(R.id.input);
        txt.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        show(rg.getCheckedRadioButtonId());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        show(i);
    }

    public void show(int i) {
        String str = "";

        str = txt.getText().toString() + "\n";

        switch (i) {
            case R.id.boy:
                RadioButton boy = findViewById(R.id.boy);
                output.setText(str + boy.getText());
                break;
            case R.id.girl:
                RadioButton girl = findViewById(R.id.girl);
                output.setText(str + girl.getText());
                break;
        }
    }
}
