package com.example.ch11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements MediaPlayer.OnCompletionListener {
    private TextView output;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
        player = MediaPlayer.create(this, R.raw.maidwiththeflaxenhair);
        player.setOnCompletionListener(this);
        try {
            player.prepareAsync();  // 準備
        } catch (Exception ex) {
            Log.d("Ch11_2", "onCreate: " + ex.getMessage());
        }
    }
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        output.setText("音樂已經播放完畢...");
        player.seekTo(0);  // 從頭開始
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        if (player != null) {
            if (player.isPlaying() == false) {
                output.setText("音樂播放中...");
                player.start();  // 播放
            }
        }
    }
    public void button2_Click(View view) {
        output.setText("音樂暫停中...");
        if (player != null) {
            player.pause();  // 暫停
        }
    }
    public void button3_Click(View view) {
        output.setText("音樂已經停止播放...");
        if (player != null) {
            player.stop();
            player.prepareAsync();  // 準備
        }
    }
    @Override
    public void onDestroy() {
        if (player != null) {
            player.release();  // 釋放MediaPlayer物件
        }
        super.onDestroy();
    }
}