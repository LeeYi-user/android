package com.example.ch11_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE = 100;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得ImageView元件
        image = (ImageView)findViewById(R.id.imageView);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        Intent intent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE &&
                resultCode == Activity.RESULT_OK) {
            Bitmap userImage = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(userImage);
        }
    }
}