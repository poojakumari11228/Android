package com.example.poojakumari.myapplication;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.nio.channels.Channel;

import static android.os.Build.VERSION_CODES.N;

public class MyServices extends Service {
    Notification mNotification;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //super.onStartCommand(intent,flags,startId);
        Toast.makeText(getApplicationContext(),"Services start ",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
