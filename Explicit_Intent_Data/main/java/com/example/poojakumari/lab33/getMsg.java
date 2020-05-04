package com.example.poojakumari.lab33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getMsg extends AppCompatActivity {
 EditText et;
 Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_msg);
        et = findViewById(R.id.editText);
        bt= findViewById(R.id.button2);

    }


    public void bt_cl(View view) {
        String s = et.getText().toString();
        Intent in = new Intent();
        in.putExtra("message",s);
        setResult(RESULT_OK,in);
        finish();
    }
}
