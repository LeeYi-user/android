package com.example.ch13_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements LocationListener {
    private static final int PERMISSIONS_REQUEST_GPS = 101;
    private TextView output;
    private LocationManager lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.lblOutput);
        // 取得定位服務的LocationManager物件
        lc = (LocationManager) getSystemService(LOCATION_SERVICE);
        // 檢查是否有啟用GPS
        if (!lc.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //  顯示GPS沒有啟用的對話方塊
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("定位管理")
                    .setMessage("GPS目前狀態是尚未啟用.\n"
                            +"請先啟用GPS?")
                    .setPositiveButton("確定", null).create().show();
        }
        // Android 6.0以上版本的權限管理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_GPS);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_GPS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 已經取得權限
                output.setText("取得權限取得GPS資訊");
            } else {
                output.setText("直到取得權限, 否則無法取得GPS資訊");
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        int minTime = 1000; // 毫秒
        float minDistance = 1; // 公尺
        try {  // 取得最佳的定位者
            String best = lc.getBestProvider(new Criteria(), true);
            if (best != null) {   // 註冊更新的傾聽者物件
                lc.requestLocationUpdates(best, minTime, minDistance, this);
            }
            else
                output.setText("請確認開啟GPS");
        }
        catch(SecurityException sex) {
            Log.e("Ch13_1_2", "GPS權限失敗..." + sex.getMessage());
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        try {  // 取消註冊更新的傾聽者物件
            lc.removeUpdates(this);
        }
        catch(SecurityException sex) {
            Log.e("Ch13_1_2", "GPS權限失敗..." + sex.getMessage());
        }
    }
    @Override
    public void onLocationChanged(Location location) {
        double lat, lng;
        if (location != null) {
            // 取得經緯度
            lat = location.getLatitude();
            lng = location.getLongitude();
            String p = "定位提供者: " + location.getProvider();
            output.setText(p + "\n緯度: " + lat + "\n經度: " + lng);
        }
    }
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {  }
    @Override
    public void onProviderEnabled(String s) {  }
    @Override
    public void onProviderDisabled(String s) {  }
    // 啟動設定程式來更改GPS設定
    public void button_Click(View view) {
        // 使用Intent物件啟動設定程式來更改GPS設定
        Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(i);
    }
}