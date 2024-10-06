package com.example.ch10_2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int GET_CONTACT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Button元件的事件處理
    public void button_Click(View view) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivityForResult(i, GET_CONTACT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_CONTACT) {
            if (resultCode == RESULT_OK) {
                String uri = data.getData().toString();
                Toast.makeText(this, uri, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(uri));
                startActivity(i);
            }
        }
    }
}
