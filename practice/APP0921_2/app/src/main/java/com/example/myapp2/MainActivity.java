package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        EditText name = findViewById(R.id.nameInput);
        String str = name.getText().toString();
        TextView output = findViewById(R.id.lblOutput);

        output.setText("您好! " + str);
    }
}
