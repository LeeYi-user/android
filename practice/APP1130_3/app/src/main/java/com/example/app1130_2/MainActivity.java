package com.example.app1130_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25"));
        startActivity(i);
    }

    public void button2_Click(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:+1234567"));
        startActivity(i);
    }

    public void button3_Click(View view)
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:hueyan@ms2.hinet.net"));
        startActivity(i);
    }
}
