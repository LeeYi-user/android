package com.example.ch12_2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {
    private TextView output;
    private Button top, bottom, right, left;
    private SensorManager sm;
    private Sensor as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView和Button元件
        output = (TextView) findViewById(R.id.lblOutput);
        top = (Button) findViewById(R.id.btnTop);
        bottom = (Button) findViewById(R.id.btnBottom);
        left = (Button) findViewById(R.id.btnLeft);
        right = (Button) findViewById(R.id.btnRight);
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
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            int xf, yf;
            float x = sensorEvent.values[0]/10;
            float y = sensorEvent.values[1]/10;
            xf = (int) Math.min(Math.abs(x) * 255, 255);
            yf = (int) Math.min(Math.abs(y) * 255, 255);
            if (x > 0) {
                right.setBackgroundColor(Color.TRANSPARENT);
                left.setBackgroundColor(Color.argb(xf, 255, 0, 255));
            } else {
                right.setBackgroundColor(Color.argb(xf, 255, 0, 255));
                left.setBackgroundColor(Color.TRANSPARENT);
            }
            if (y > 0) {
                top.setBackgroundColor(Color.TRANSPARENT);
                bottom.setBackgroundColor(Color.argb(yf, 255, 0, 255));
            } else {
                top.setBackgroundColor(Color.argb(yf, 255, 0, 255));
                bottom.setBackgroundColor(Color.TRANSPARENT);
            }
            output.setText("X軸: " + x + "   Y軸: " + y);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {  }
}