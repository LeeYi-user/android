package com.example.app1019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        String str = "";

        CheckBox original = findViewById(R.id.original);

        if (original.isChecked())
        {
            str += original.getText() + "\n";
        }

        CheckBox beef = findViewById(R.id.beef);

        if (beef.isChecked())
        {
            str += beef.getText() + "\n";
        }

        CheckBox seafood = findViewById(R.id.seafood);

        if (seafood.isChecked())
        {
            str += seafood.getText() + "\n";
        }

        TextView output = findViewById(R.id.output);
        output.setText(str);
    }
}
