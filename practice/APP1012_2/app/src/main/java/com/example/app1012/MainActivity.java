package com.example.app1012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_click(View view)
    {
        String str = "";

        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);

        if (boy.isChecked())
        {
            str += "男\n";
        }

        if (girl.isChecked())
        {
            str += "女\n";
        }

        RadioGroup type = findViewById(R.id.rgType);

        if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
        {
            str += "全票\n";
        }
        else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
        {
            str += "兒童票\n";
        }
        else
        {
            str += "學生票\n";
        }

        TextView output = findViewById(R.id.lblOutput);
        output.setText(str);
    }
}
