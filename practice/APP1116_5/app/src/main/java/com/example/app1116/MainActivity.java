package com.example.app1116;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("選擇一個確認");
        String[] options = {"紅色", "黃色", "綠色"};
        builder.setItems(options, this);
        builder.setNegativeButton("取消", null);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Button btn = findViewById(R.id.button2);

        switch (i)
        {
            case 0:
                btn.setBackgroundColor(Color.RED);
                break;
            case 1:
                btn.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                btn.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
