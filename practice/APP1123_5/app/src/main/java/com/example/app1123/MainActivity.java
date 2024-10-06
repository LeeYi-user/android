package com.example.app1123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SET_RESULT = 1;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.lblOutput);
    }

    public void button_click(View view)
    {
        EditText txtOpd1, txtOpd2;

        txtOpd1 = findViewById(R.id.txtOpd1);
        txtOpd2 = findViewById(R.id.txtOpd2);

        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("OPERAND01", txtOpd1.getText().toString());
        bundle.putString("OPERAND02", txtOpd2.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, SET_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case SET_RESULT:
                if (resultCode == RESULT_OK)
                {
                    Bundle bundle = data.getExtras();
                    output.setText("計算結果: " + bundle.getDouble("RESULT"));
                }

                break;
        }
    }
}
