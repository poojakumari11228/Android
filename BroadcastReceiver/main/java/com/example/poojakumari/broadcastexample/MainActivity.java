package com.example.poojakumari.broadcastexample;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    smsReceiver myReceiver;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        IntentFilter filter = new IntentFilter();
//        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
//        myReceiver = new smsReceiver();
//        registerReceiver(myReceiver, filter);

        if(checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Requesting permisiion",Toast.LENGTH_LONG).show();
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},9);
        }
        else {
            Toast.makeText(this,"permisiion granted",Toast.LENGTH_LONG).show();
        }


    }


}
