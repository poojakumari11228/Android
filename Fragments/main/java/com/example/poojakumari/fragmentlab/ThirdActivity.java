package com.example.poojakumari.fragmentlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv = findViewById(R.id.idtext);

        Intent in = getIntent();
        String id = in.getStringExtra("data");
        tv.setText(id);
    }
}
