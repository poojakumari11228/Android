package com.example.poojakumari.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         tv= findViewById(R.id.textView);
        Intent insecond = getIntent();
        String st = insecond.getStringExtra("et");
        tv.setText(st);

    }

}
