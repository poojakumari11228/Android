package com.example.poojakumari.serviceslab;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class Myservice extends Service {

    private static final String CHANNEL_ID = "2";
    Notification mNotification ;
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(),"Service stoped", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Service Notofication")
                .setContentText("Service Stoped!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when notified
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is unique for each notification that you must define
        notificationManager.notify(1, mBuilder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service Started...!!!",Toast.LENGTH_LONG).show();
        buildNotofication();
        startForeground(1,mNotification);
        return START_STICKY;
    }

    private void buildNotofication() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            CharSequence channelName = "Playback channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            nManager.createNotificationChannel(notificationChannel);
        }

        mNotification = new NotificationCompat.Builder(getBaseContext(), CHANNEL_ID)
                .setContentTitle("Service Running...").
                setContentText("Service Started"+'\n'+" Welcom to Service").
                setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle()).build();

    }




}
