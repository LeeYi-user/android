package com.example.ch12_2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements MediaPlayer.OnCompletionListener, SensorEventListener {
    private TextView output;
    private MediaPlayer player;
    private SensorManager sm;
    private Sensor as;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;
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
            Log.d("Ch12_2_3", "onCreate: " + ex.getMessage());
        }
        // 取得感測器系統服務
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 取得加速感測器
        as = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 註冊SensorEventListener傾聽者物件
        sm.registerListener(this, as, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // 取消註冊SensorEventListener傾聽者物件
        sm.unregisterListener(this);
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
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // 取得三個方向的感測器值
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            // 裝置是否水平
            if (Math.abs(x) < 1 && Math.abs(y) < 1 && z < -9){
                output.setText("音樂暫停中...");
                player.pause();  // 暫停
            }
            long curTime = System.currentTimeMillis();
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;
                if (speed > SHAKE_THRESHOLD) {
                    if (player.isPlaying() == false) {
                        output.setText("音樂播放中...");
                        player.start();  // 播放
                    }
                    else {
                        output.setText("音樂暫停中...");
                        player.pause();  // 暫停
                    }
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {  }
}