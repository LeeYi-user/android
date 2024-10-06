package com.example.ch9_5a;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    ActivityResultLauncher launcher = registerForActivityResult(new
            ResultContract(), new ActivityResultCallback<String>() {
        @Override
        public void onActivityResult(String result) {
            output.setText("計算結果: " + result);
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        // 啟動活動且有回傳資料
        launcher.launch(true);
    }
    class ResultContract extends ActivityResultContract<Boolean, String> {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean input) {
            EditText txtOpd1, txtOpd2;
            // 取得EditText元件
            txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
            txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
            // 建立Intent物件
            Intent intent = new Intent(MainActivity.this, OpActivity.class);
            // 建立傳遞資料的Bundle物件
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01",txtOpd1.getText().toString());
            bundle.putString("OPERAND02",txtOpd2.getText().toString());
            intent.putExtras(bundle);  // 加上資料
            return intent;
        }
        @Override
        public String parseResult(int resultCode, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}