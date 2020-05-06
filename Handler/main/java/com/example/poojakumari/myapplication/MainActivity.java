package com.example.poojakumari.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView test;
    Handler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.titleDescription);
        handle = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test.setText("Hey! Text Changed");
            }
        };
        new Thread(runnable).start();

    }
}
