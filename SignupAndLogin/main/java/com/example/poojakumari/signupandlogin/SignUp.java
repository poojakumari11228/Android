package com.example.poojakumari.signupandlogin;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUp extends AppCompatActivity {

    EditText uname,email,pass,dob;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        uname = findViewById(R.id.editText);
        email = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);
        dob = findViewById(R.id.editText4);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);


    }

    public void signUp_bt(View view){

        if(male.isSelected()){
            gender="male";
        }else
            gender="female";

        Intent login = new Intent(SignUp.this,LogIn.class);
        login.putExtra("s_uname",""+this.uname.getText().toString());
        login.putExtra("s_pass",""+this.pass.getText().toString());
        login.putExtra("s_email",""+this.email.getText().toString());
        login.putExtra("s_gender",""+gender);

        startActivity(login);
    }

    public void event_bt(View view) {
      //  Intent temp_in = new Intent(Intent.ACTION_DIAL);
        Intent temp_in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Intent temp_in = new Intent(Intent.ACTION_VIEW);
       // temp_in.setData(Uri.parse("geo:0,0?q="+location));

        startActivity(temp_in);
    }

    }
