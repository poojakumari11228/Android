package com.example.poojakumari.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
    }

    public void bt_call(View view){
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse(et.getText().toString()));
        startActivity(in);
    }
    public void bt_camera(View view){
        Intent in =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(in);
    }
    public void bt_contact(View view){
       Intent in =  new Intent(Intent.ACTION_DEFAULT,Uri.parse("content://contacts/people/"));
        startActivity(in);
    }
    public void bt_browser(View view){
        Intent in = new Intent(Intent.ACTION_VIEW);
         in.setData(Uri.parse("http://"+et.getText().toString()));
         startActivity(in);
    }
    public void bt_calllog(View view){
        Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("content://call_log/calls"));
        startActivity(in);
    }
    public void bt_gallery(View view){
        Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/external/images/media/"));
        startActivity(in);
    }
    public void bt_dialpad(View view){
        Intent in = new Intent(Intent.ACTION_DIAL);
        in.setData(Uri.parse("tel:"+et.getText().toString()));
        startActivity(in);
    }

    public void bt_clearfield(View view){
        et.setText("");
    }

    public void sendemail(View view) {
        //Send an E-Mail
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("plan/text");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"poojakumari11228@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
        i.putExtra(Intent.EXTRA_TEXT, "MAIL BODY");
        startActivity(i);
    }
}
