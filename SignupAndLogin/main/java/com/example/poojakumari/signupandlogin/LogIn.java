package com.example.poojakumari.signupandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    EditText l_uname,l_pass;
    Intent in;
    String gender,msg;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        l_uname = findViewById(R.id.editText5);
        l_pass = findViewById(R.id.editText7);
        b=findViewById(R.id.b2);
        in = getIntent();

         this.gender =in.getStringExtra(("s_gender").toString());

         b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent welcom_int = new Intent(LogIn.this,Welcome.class);
                 welcom_int.putExtra("uname",""+l_uname.getText().toString());
                 welcom_int.putExtra("email",""+in.getStringExtra(("s_email")));
                 welcom_int.putExtra("gender",""+gender);

                 startActivity(welcom_int);

             }
         });
    }

     public void login_bt(View view){
/*
        if( !(l_uname.getText().toString().equals(in.getStringExtra(("s_uname").toString())))  &&
                ( l_pass.getText().toString().equals(in.getStringExtra(("s_pass").toString())))  ){
        msg = "Invalid user name or pass word";
            Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_SHORT).show();

        }else
        {
            */
       //  msg ="Login success";
  //       Toast.makeText(getApplicationContext(),"Inside login event",Toast.LENGTH_SHORT).show();

            Intent welcom_int = new Intent(LogIn.this,Welcome.class);
            welcom_int.putExtra("uname",""+l_uname.getText().toString());
            welcom_int.putExtra("email",""+in.getStringExtra(("s_email").toString()));
            welcom_int.putExtra("gender",""+gender);

            startActivity(welcom_int);

  //      }



     }
}
