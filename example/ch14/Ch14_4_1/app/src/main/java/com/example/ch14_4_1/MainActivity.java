package com.example.ch14_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private StdDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        dbHelper = new StdDBHelper(this);
        db = dbHelper.getWritableDatabase();
        TextView output = (TextView)
                findViewById(R.id.lblOutput);
        output.setText("資料庫是否開啟: " + db.isOpen() +
                "\n資料庫版本: " + db.getVersion());
    }
}