package com.example.poojakumari.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String  myMovies[]={"Walking Dead","Games of throne","Thirteen reasons Why","Tangled","tinker Bell"};

    TextView textView;
    Button left ,right;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.moviesview);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);


        textView.setText(myMovies[0]);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    count--;
                    textView.setText(myMovies[count]);
                    Toast.makeText(getApplicationContext(),"left count is "+count,Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(getApplicationContext(),"left count end "+count,Toast.LENGTH_LONG).show();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4){
                    count++;
                    textView.setText(myMovies[count]);
                    Toast.makeText(getApplicationContext(),"right count is "+count,Toast.LENGTH_LONG).show();
                }else if(count>4)
                    Toast.makeText(getApplicationContext(),"right count end "+count,Toast.LENGTH_LONG).show();
            }
        });
    }


}
