package com.example.poojakumari.fragmentlab;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Object MyApplication =null ;
    FragmentManager fManager;
    FragmentTransaction fTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication = getApplicationContext();

        if ( (findViewById(R.id.layout_default))!=null ){
            Toast.makeText(getApplicationContext(),"default layout",Toast.LENGTH_LONG).show();
            addFirst(); }

        if ( (findViewById(R.id.layout_land))!=null ){
            Toast.makeText(getApplicationContext(),"Landscape layout",Toast.LENGTH_LONG).show();
            addSecond();
        }
//

    }

    public void addFirst(){
        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.fragmentLayout,new FragmentOne());
        fTransaction.commit();


    }

    public void addSecond(){
        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.fragmentLayout,new FragmentTwo());
        fTransaction.commit();
    }
}
