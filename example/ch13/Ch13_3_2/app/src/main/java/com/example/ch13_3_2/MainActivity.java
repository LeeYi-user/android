package com.example.ch13_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 取得EditText元件
        EditText address = (EditText) findViewById(R.id.txtAddress);
        String addressName = address.getText().toString();
        // 取得TextView元件
        TextView output = (TextView)findViewById(R.id.lblOutput);
        try {  // 建立Geocoder物件
            Geocoder geocoder = new Geocoder(this, Locale.TAIWAN);
            // 取得經緯度座標清單的List物件
            List<Address> listGPSAddress = geocoder.getFromLocationName(addressName, 1);
            // 有找到經緯度座標
            if (listGPSAddress != null) {
                double lat = listGPSAddress.get(0).getLatitude();
                double lon = listGPSAddress.get(0).getLongitude();
                output.setText("緯度: " + lat + "\n經度: " + lon);
            }
        } catch (Exception ex) {
            output.setText("錯誤:" + ex.toString());
        }
    }
}
