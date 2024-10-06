package com.example.ch11_3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView video;
    private String videoFile = "wildlife";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得VideoView元件
        video = (VideoView)findViewById(R.id.videoView);
        // 指定影片的URI
        int id = getResources().getIdentifier(videoFile, "raw",
                this.getPackageName());
        final String path = "android.resource://" +
                this.getPackageName() + "/" + id;
        video.setVideoURI(Uri.parse(path));
        // 指定MediaController
        video.setMediaController(new MediaController(this));
        video.start(); // 開始播放
    }
    @Override
    public void onPause() {
        super.onPause();
        super.onStop();
        video.stopPlayback();  // 停止播放
    }
}
