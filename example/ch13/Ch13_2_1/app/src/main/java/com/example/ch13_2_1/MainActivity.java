package com.example.ch13_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_GPS = 101;
    private TextView output;
    private LocationManager lc;
    private Location current;
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
    // Button元件的事件處理
    public void button_Click(View view) {
        String best = lc.getBestProvider(new Criteria(), true);
        try {  // 取得最後的GPS座標
            current = lc.getLastKnownLocation(best);
            if (current != null) {
                double lat = current.getLatitude();
                double lng = current.getLongitude();
                output.setText("緯度: " + lat + "\n經度: " + lng);
            }
            else
                output.setText("取得GPS位置失敗...");
        }
        catch (SecurityException sex) {
            Log.e("Ch13_2_1", "GPS權限失敗..." + sex.getMessage());
        }
    }
    public void button2_Click(View view) {
        float latitude = (float) current.getLatitude();
        float longitude = (float) current.getLongitude();
        String label = "車站";
        String uri = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        query = Uri.encode(query);
        uri = uri + "?q=" + query + "?z=16";
        Intent geoMap = new Intent(
                Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(geoMap);
    }
}
