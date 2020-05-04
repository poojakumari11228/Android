package com.example.poojakumari.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;
    Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);

        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_SHORT).show();
               String text =  et.getText().toString();
               Toast.makeText(getApplicationContext(),"entered text is"+text,Toast.LENGTH_SHORT).show();
              // intents are used to navigate from one activity to another
                Intent in = new Intent(MainActivity.this,secondActivity.class);
                in.putExtra("et",text);
                startActivity(in);
            }
        });
    }
    public void myevent(View v){
        Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_SHORT).show();

    }

}
