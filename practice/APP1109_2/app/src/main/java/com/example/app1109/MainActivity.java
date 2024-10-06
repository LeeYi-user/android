package com.example.app1109;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.lblOutput);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int tmp;
        double result;
        EditText txtTemp = findViewById(R.id.txtTemp);

        tmp = Integer.parseInt(txtTemp.getText().toString());
        switch(item.getItemId())
        {
            case R.id.toF:
                result = (9.0 * tmp) / 5.0 + 32.0;
                output.setText("華氏溫度: " + result);
                break;
            case R.id.toC:
                result = (5.0 / 9.0) * (tmp - 32);
                output.setText("攝氏溫度: " + result);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
