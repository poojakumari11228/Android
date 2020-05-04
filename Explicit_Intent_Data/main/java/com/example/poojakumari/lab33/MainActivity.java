package com.example.poojakumari.lab33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        bt = findViewById(R.id.button);
        tv.setText("DEFAULT MSG");
            }


    public void btclick(View view) {
        Intent in = new Intent(MainActivity.this,getMsg.class);
        startActivityForResult(in,1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 ) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra("message");
                tv.setText(reply);
            }
}
        }
    }