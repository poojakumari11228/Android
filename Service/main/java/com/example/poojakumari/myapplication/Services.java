package com.example.poojakumari.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        bt=findViewById(R.id.button);

    }

    public void startService(View view){
        Intent in= new Intent( Services.this ,MyServices.class);
        startService(in);
    }
}
