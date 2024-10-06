package com.example.ch11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 選擇圖檔的Spinner元件
        sp = (Spinner) findViewById(R.id.spinner);
        // 取得ImageView元件
        image = (ImageView) findViewById(R.id.imageView);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 取得選取圖檔的索引值
        int index = sp.getSelectedItemPosition();
        // 指定ImageView元件顯示的圖檔
        if (index == 0) {
            image.setImageResource(R.mipmap.image01);
        }
        else if (index == 1) {
            image.setImageResource(R.mipmap.image02);
        }
        else if (index == 2) {
            image.setImageResource(R.mipmap.image03);
        }
        else if (index == 3) {
            image.setImageResource(R.mipmap.image04);
        }
        else if (index == 4) {
            image.setImageResource(R.mipmap.image05);
        }
        else if (index == 5) {
            image.setImageResource(R.mipmap.image06);
        }
        else if (index == 6) {
            image.setImageResource(R.mipmap.image07);
        }
    }
}
