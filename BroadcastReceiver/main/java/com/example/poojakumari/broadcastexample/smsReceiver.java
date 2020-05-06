package com.example.poojakumari.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class smsReceiver extends BroadcastReceiver {
    SmsManager  smsManager = SmsManager.getDefault();
    ;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "inside onreceiveW", Toast.LENGTH_LONG).show();

        final Bundle bundle = intent.getExtras();

        if (bundle!=null) {
            Toast.makeText(context, "sms Received not null.....", Toast.LENGTH_LONG).show();

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                  SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[0]);
                  String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                  String senderNum = phoneNumber;
                  String message = currentMessage.getDisplayMessageBody();
                  if (message.contains("hello")){
                      Toast.makeText(context, ""+"senderNum: "+ senderNum + ", message: " + message, Toast.LENGTH_LONG).show();
                        }
                  else
                      Toast.makeText(context, "SMS doesnot contain hello", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(context, "sms Received  null.....", Toast.LENGTH_LONG).show();
    }
}
