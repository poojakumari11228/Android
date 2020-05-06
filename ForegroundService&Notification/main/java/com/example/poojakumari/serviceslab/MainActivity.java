package com.example.poojakumari.serviceslab;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "1";
    Intent i;
    Notification mNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
     i = new Intent(MainActivity.this,Myservice.class);
     startService(i);
    }

    public void stopService(View view) {
        getWindow().getDecorView().setBackgroundColor(Color.RED);
    stopService(i);

    }

}
