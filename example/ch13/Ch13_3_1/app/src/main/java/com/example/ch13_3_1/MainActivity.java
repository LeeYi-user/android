package com.example.ch13_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final int MAX = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 取得EditText元件
        EditText elat = (EditText) findViewById(R.id.txtLat);
        EditText elon = (EditText) findViewById(R.id.txtLon);
        // 取得經緯度座標
        float lat = Float.parseFloat(elat.getText().toString());
        float lon = Float.parseFloat(elon.getText().toString());
        // 取得TextView元件
        TextView output = (TextView)findViewById(R.id.lblOutput);
        try {  // 建立Geocoder物件
            Geocoder geocoder = new Geocoder(this, Locale.TAIWAN);
            // 取得地址清單的List物件
            List<Address> listAddress = geocoder.getFromLocation(lat, lon, MAX);
            if (listAddress != null) {   // 是否有取得地址
                String out = "";
                for (int i = 0; i < MAX; i++) {
                    Address ad = listAddress.get(i);
                    out += (i+1) + ": ";  // 取得地址內容
                    for (int j = 0; j < ad.getMaxAddressLineIndex(); j++) {
                            out += ad.getAddressLine(j) + "  ";
                    }
                    out += ad.getFeatureName() + "-" + ad.getPostalCode();
                    out += "\n";
                }
                output.setText(out);
            }
            else {
                output.setText("沒有傳回地址資料!");
            }
        } catch (Exception ex) {
            output.setText("錯誤:" + ex.toString());
        }
    }
}
