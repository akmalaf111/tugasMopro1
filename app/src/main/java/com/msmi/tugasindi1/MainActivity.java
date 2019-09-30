package com.msmi.tugasindi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button website;
    Button kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website = (Button)findViewById(R.id.btn_website);
        website.setOnClickListener(this);
        kontak = (Button)findViewById(R.id.btn_kontak);
        kontak.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_kontak:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.btn_website:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(implicit);
                break;
            default:
                break;
        }
    }
}

