package com.example.app1019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private TextView output;
    private int[] ids = {R.id.original, R.id.beef, R.id.seafood};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);

        for (int id : ids)
        {
            CheckBox chk = findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId())
        {
            case R.id.original:
                output.setText("你點選的是原味\n");
                break;
            case R.id.beef:
                output.setText("你點選的是牛肉\n");
                break;
            case R.id.seafood:
                output.setText("你點選的是海鮮\n");
                break;
        }

        showOrder();
    }

    public void showOrder()
    {
        String str = output.getText().toString();

        for (int id : ids)
        {
            CheckBox chk = findViewById(id);

            if (chk.isChecked())
            {
                str += chk.getText() + "\n";
            }
        }

        output.setText(str);
    }
}
