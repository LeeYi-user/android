package com.example.ch10_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        EditText url = (EditText) findViewById(R.id.txtURL);
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url.getText().toString()));
        startActivity(i);
    }
}