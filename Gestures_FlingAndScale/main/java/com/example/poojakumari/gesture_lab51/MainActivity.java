package com.example.poojakumari.gesture_lab51;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
, ScaleGestureDetector.OnScaleGestureListener  {

    ImageView im;
   // TextView tv;
    int imgs[]=new int[10];
    int counter = 0;
    private float scale = 1f;
    private float onScaleBegin = 0;
    private float onScaleEnd = 0;
    private ScaleGestureDetector detector;
    String TAG = "DBG";

    GestureDetectorCompat gestureDetectorCompat;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getPointerCount()>1)
        {
            detector.onTouchEvent(event);
        }
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im = findViewById(R.id.imageView);

        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setIsLongpressEnabled(true);
        detector = new ScaleGestureDetector(this,this);

        im.setImageResource(R.drawable.img12);
        imgs[0]= R.drawable.img1;
        imgs[1]= R.drawable.img2;
        imgs[2]= R.drawable.img3;
        imgs[3]= R.drawable.img4;
        imgs[4]= R.drawable.img5;
        imgs[5]= R.drawable.img6;
        imgs[6]= R.drawable.img7;
        imgs[7]= R.drawable.img8;
        imgs[8]= R.drawable.img9;
        imgs[9]= R.drawable.img10;


    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float x1 = e1.getX();
        float x2 = e2.getX();

        if( (x1-x2)<0 ){

          if(counter<10) {
                counter++;
                im.setImageResource(imgs[counter]);
                Toast.makeText(getApplicationContext(), "image " + counter, Toast.LENGTH_SHORT).show();
            }
        }
        if( (x1-x2)>0 ){
            if(counter>0) {
                counter--;
                im.setImageResource(imgs[counter]);
                Toast.makeText(getApplicationContext(), "image " + counter, Toast.LENGTH_SHORT).show();
            }
        }


        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        scale *= detector.getScaleFactor();
        scale = Math.max(0.1f, Math.min(scale, 5.0f));
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Log.d(TAG, "onScaleBegin");
        onScaleBegin = scale;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        Log.d(TAG, "onScaleEnd");
        onScaleEnd = scale;
        if (onScaleEnd > onScaleBegin) {
            im.setScaleX(scale);
          //  Toast.makeText(getApplicationContext(), "Scaled Up by a factor of " + String.valueOf(onScaleEnd / onScaleBegin), Toast.LENGTH_SHORT).show();
        }
        if (onScaleEnd < onScaleBegin) {

            im.setScaleX(scale);
          //  Toast.makeText(getApplicationContext(), "Scaled Down by a factor of " + String.valueOf(onScaleBegin / onScaleEnd), Toast.LENGTH_SHORT).show();
        }
    }
}
