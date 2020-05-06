package com.example.poojakumari.sensor_lab53;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ImageView im;
    SensorManager sManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sManager.getDefaultSensor(sensor.TYPE_GYROSCOPE);
        im = findViewById(R.id.imageView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sManager.registerListener(this,sensor,sManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        Toast.makeText(getApplicationContext(),"value :"+z,Toast.LENGTH_SHORT).show();
        if(z>0.1)
        {
            Toast.makeText(getApplicationContext(),"value >0.1 :"+z,Toast.LENGTH_SHORT).show();
            im.setImageResource(R.drawable.image3);
        }
       else  if(z<-0.1) {
            Toast.makeText(getApplicationContext(), "value <-0.1 : " + z, Toast.LENGTH_SHORT).show();
            im.setImageResource(R.drawable.image2);
        }
        else if(z>-0.09 && z<0.09){
            im.setImageResource(R.drawable.image);
        }

      //     Toast.makeText(getApplicationContext(), "value =20 : " + z, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
