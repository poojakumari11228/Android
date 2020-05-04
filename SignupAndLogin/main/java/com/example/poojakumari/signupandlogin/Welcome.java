package com.example.poojakumari.signupandlogin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {



    Intent in;
    TextView name,email,gender;
    ImageView img;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        name = findViewById(R.id.textname);
        email = findViewById(R.id.textemail);
        gender = findViewById(R.id.textgender);
        img = findViewById(R.id.imageView);
/*
        name.setText(in.getStringExtra(("name").toString()));
        email.setText(in.getStringExtra(("email").toString()));
        gender.setText(in.getStringExtra(("gender").toString()));
*/

        //Drawable drawable  = getResources().getDrawable(R.drawable.welcome);
        //img.setImageDrawable(drawable);
        img.setImageResource(R.drawable.welcome2);


        in = getIntent();
        name.setText("NAME : "+in.getStringExtra("uname").toString());
        email.setText("EMAIL : "+in.getStringExtra("email").toString());
        gender.setText("GENDER :  "+in.getStringExtra("gender").toString());
    }
}
