package com.example.app1116;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("關於本書");
        builder.setMessage("Android 程式設計\n作者: 陳會安");
        builder.setCancelable(true);
        builder.setPositiveButton("確定", null);
        builder.show();
    }
}
