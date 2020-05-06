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

    float x=0;
    float y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sManager.getDefaultSensor(sensor.TYPE_PROXIMITY);
        if(sensor==null){
            Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),sensor.getMaximumRange()+"",Toast.LENGTH_LONG).show();

        }
        im = findViewById(R.id.imageView);
       im.setImageResource(R.drawable.image);
        x = im.getScaleX();
        y = im.getScaleY();


    }

    @Override
    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
      //  Toast.makeText(getApplicationContext(),"range exceed"+sensor.getMaximumRange(),Toast.LENGTH_LONG).show();
        if(event.values[0]<sensor.getMaximumRange()){
            im.setScaleX(x*2);
            im.setScaleY(y*2);

        }
        else{
            im.setScaleX(x);
            im.setScaleY(y);
      //  Toast.makeText(getApplicationContext(),"range not  exceed",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
