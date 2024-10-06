package com.example.app1123;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SET_RESULT = 1;
    private TextView output;
    Button btn;
    ActivityResultLauncher launcher = registerForActivityResult(new ResultContract(), new ActivityResultCallback<String>() {
        @Override
        public void onActivityResult(String result) {
            output.setText("計算結果: " + result);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.lblOutput);
    }

    public void button_click(View view)
    {
        launcher.launch(true);
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

    class ResultContract extends ActivityResultContract<Boolean, String> {

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean aBoolean) {
            EditText txtOpd1, txtOpd2;

            txtOpd1 = findViewById(R.id.txtOpd1);
            txtOpd2 = findViewById(R.id.txtOpd2);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("OPERAND01", txtOpd1.getText().toString());
            bundle.putString("OPERAND02", txtOpd2.getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}
