package com.example.poojakumari.gesture;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    GestureDetectorCompat gestureDetectorCompat;
    TextView tv;
//  for single Touch
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        gestureDetectorCompat.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }

    // for scale getsure
    public void bt_scale_gesture(View view){
        Intent in = new Intent(this.getApplicationContext(),scaleGestureActivity.class);
        startActivity(in);
    }


/// for multi touch
    @Override
    public boolean onTouchEvent(MotionEvent event) {

       if( event.getPointerCount()>1){
           tv.setText("multiple touch");
           int action = event.getAction();
           int index = event.getActionIndex();
           tv.append("\n"+action+"\n"+index);
       }
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView2);
        gestureDetectorCompat = new GestureDetectorCompat(this,this);

        gestureDetectorCompat.setIsLongpressEnabled(true);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("single tab confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("double tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("double tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("on down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("single tab up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("Fling");
        return true;
    }
}
