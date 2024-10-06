package com.example.app1130_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        EditText editText = findViewById(R.id.editText);
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);

        i.putExtra(SearchManager.QUERY, editText.getText().toString());
        startActivity(i);
    }
}
