package com.example.ch14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String fname = "note.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void btnSave_Click(View view) {
        EditText input = (EditText) findViewById(R.id.txtInput);
        String str = input.getText().toString();
        try {
            // 開啟寫入檔案
            FileOutputStream out = openFileOutput(fname,MODE_PRIVATE);
            // 將字串轉換成位元組資料後, 寫入串流
            out.write(str.getBytes());
            out.close();     // 關閉串流
            Toast.makeText(this, "成功寫入檔案...",
                    Toast.LENGTH_SHORT).show();
            input.setText("");  // 清除EditText元件的內容
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void btnRead_Click(View view) {
        try {
            // 開啟讀取檔案
            FileInputStream in = openFileInput(fname);
            byte[] data = new byte[128];
            // 讀取串流的位元組資料
            in.read(data);
            in.close();    // 關閉串流
            // 將位元組資料建立成字串
            String str = new String(data);
            Toast.makeText(this, "成功讀取檔案...",
                    Toast.LENGTH_SHORT).show();
            TextView output = (TextView) findViewById(R.id.lblOutput);
            output.setText("讀取內容:\n" + str);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
