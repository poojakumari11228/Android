package com.example.poojakumari.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar tb;
    ListView lv;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.toolbar);
        lv = findViewById(R.id.listview);

        setSupportActionBar(tb);
        getSupportActionBar().setLogo(R.drawable.search);

        list = new ArrayList<String>();
        for(int i =1; i<=100;i++){
          if(i%2!=0)
              list.add("F16SW"+i);
        }
        //   array adopter  used to connect the text with our layout
        //  using  bulid in layout (simple.list.item ) and its text id
        // parameters( this, our layout, text id, data list )
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
       lv.setAdapter(arrayAdapter);

       //   event listner for all items
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String text = lv.getItemAtPosition(position).toString();
               Toast.makeText(getApplicationContext(),"clicked data is: "+text,Toast.LENGTH_LONG).show();
           }
       });
    }
}
