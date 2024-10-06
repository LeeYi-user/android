package com.example.ch12_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {
    private TextView output;
    private SensorManager sm;
    private Sensor as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
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
            // 取得三個方向的加速感測器值
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            output.setText("X軸: " + x + "\nY軸: " + y + "\nZ軸: " + z);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {  }
}
