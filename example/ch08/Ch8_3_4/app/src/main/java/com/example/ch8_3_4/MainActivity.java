package com.example.ch8_3_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements DialogInterface.OnClickListener, DialogInterface.OnMultiChoiceClickListener {
    String[] items = {"Samsung", "OPPO", "Apple", "ASUS"};
    boolean[] itemsChecked = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        String msg = "";
        for (int index = 0; index < items.length; index++) {
            if (itemsChecked[index])
                msg += items[index] + "\n";
        }
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText(msg);
    }
    @Override
    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
        Toast.makeText(MainActivity.this,
                items[which] + (isChecked ? " 勾選": "沒有勾選"),
                Toast.LENGTH_SHORT).show();
    }
    public void button_Click(View view) {
        // 建立對話方塊
        AlertDialog build = new AlertDialog.Builder(this)
                .setTitle("請勾選選項?")
                .setPositiveButton("確定", this)
                .setNegativeButton("取消", null)
                .setMultiChoiceItems(items,itemsChecked, this)
                .show(); // 顯示對話方塊
    }
}
