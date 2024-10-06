package com.example.ch14_4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String DATABASE_TABLE = "students";
    private SQLiteDatabase db;
    private StdDBHelper dbHelper;
    private EditText txtID, txtName, txtGrade, txtNewGrade;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 建立SQLiteOpenHelper物件
        dbHelper = new StdDBHelper(this);
        db = dbHelper.getWritableDatabase(); // 開啟資料庫
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
        // 取得EditText元件
        txtID = (EditText) findViewById(R.id.txtID);
        txtName = (EditText) findViewById(R.id.txtName);
        txtGrade=(EditText) findViewById(R.id.txtGrade);
        txtNewGrade=(EditText) findViewById(R.id.txtNewGrade);
    }
    @Override
    protected void onStop() {
        super.onStop();
        db.close(); // 關閉資料庫
    }
    // Button元件的事件處理 - 插入記錄
    public void button_Click(View view) {
        long id;
        ContentValues cv = new ContentValues();
        cv.put("_id", Integer.parseInt(txtID.getText().toString()));
        cv.put("name", txtName.getText().toString());
        cv.put("grade", Double.parseDouble(txtGrade.getText().toString()));
        id = db.insert(DATABASE_TABLE, null, cv);
        output.setText("新增記錄成功: " + id);
    }  // 更新記錄
    public void button2_Click(View view) {
        int count;
        int id = Integer.parseInt(txtID.getText().toString());
        ContentValues cv = new ContentValues();
        cv.put("grade", Double.parseDouble(txtNewGrade.getText().toString()));
        count = db.update(DATABASE_TABLE, cv, "_id=" + id, null);
        output.setText("更新記錄成功: " + count);
    }  // 刪除記錄
    public void button3_Click(View view) {
        int count;
        int id = Integer.parseInt(txtID.getText().toString());
        count = db.delete(DATABASE_TABLE, "_id=" + id, null);
        output.setText("刪除記錄成功: " + count);
    }  // 查詢所有記錄
    public void button4_Click(View view) {
        // 查詢整個資料表
        SqlQuery("SELECT * FROM " + DATABASE_TABLE);
    }
    public void button5_Click(View view) {
        EditText txtSQL = (EditText) findViewById(R.id.txtSQL);
        // 執行輸入SQL指令的查詢
        SqlQuery(txtSQL.getText().toString());
    }
    // 執行SQL查詢
    public void SqlQuery(String sql) {
        String[] colNames;
        String str = "";
        Cursor c = db.rawQuery(sql, null);
        colNames = c.getColumnNames();
        // 顯示欄位名稱
        for (int i = 0; i < colNames.length; i++)
            str += colNames[i] + "\t\t";
        str += "\n";
        c.moveToFirst();  // 第1筆
        // 顯示欄位值
        for (int i = 0; i < c.getCount(); i++) {
            str += c.getString(0) + "\t\t";
            str += c.getString(1) + "\t\t";
            str += c.getString(2) + "\n";
            c.moveToNext();  // 下一筆
        }
        output.setText(str.toString());
    }
}
