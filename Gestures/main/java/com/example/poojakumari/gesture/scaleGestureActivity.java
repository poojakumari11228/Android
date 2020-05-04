package com.example.poojakumari.gesture;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class scaleGestureActivity extends AppCompatActivity implements ScaleGestureDetector.OnScaleGestureListener {

    TextView tv;
    float scale = 1f;
    float begin = 0;
    float end = 0;
    ScaleGestureDetector scaleGestureDetector;
    String tag = "DBG";
    ImageView im;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_gesture);

        tv = findViewById(R.id.textView3);
        scaleGestureDetector = new ScaleGestureDetector(this, this);



    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        scale *= detector.getScaleFactor();
        scale = Math.max(0.1f, Math.min(scale, 5.0f));
        tv.setText("Scale factor : " + scale);
        // textView.setText(“Scale Factor:”+scale);
        im.setScaleX(scale);
        im.setScaleY(scale);
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Log.d(tag, "onScaleBegin");
        begin = scale;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

        Log.d(tag, "onScaleEnd");
        end = scale;
        if (end > begin) {
            Toast.makeText(getApplicationContext(),"ScaledUp by factor of  "+String.valueOf(end/begin),Toast.LENGTH_LONG);

        }
        if (end < begin) {
            Toast.makeText(getApplicationContext(),"Scaled Down by factor of  "+String.valueOf(begin/end),Toast.LENGTH_LONG);
        }
    }
}
