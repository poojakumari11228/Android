package com.example.user.lab10sqllitedatabases;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Database database;
    FloatingActionButton insertbutton;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertbutton=findViewById(R.id.btn);
        listview=findViewById(R.id.list);

        final List<Student> students = Database.getData(getApplicationContext()).dao().getStudent();
        final ArrayList<String> names = new ArrayList();
        for(Student s: students)
        {
            names.add(s.getId() + " " + s.getName() +" " + s.getRollno());
            int id= s.getId();
            String name= s.getName();
            String rollno= s.getRollno();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, names);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student s = new Student();
                String  itemValue    = (String) listview.getItemAtPosition(position);
                String[] parts = itemValue.split(" ");
                Integer sId = Integer.parseInt(parts[0]);
                String name = parts[1];
                String rolnum = parts[2];
                  s.setId(sId);
                   s.setName(name);
                   s.setRollno(rolnum);

                   Integer sid=s.getId();
                    String sname = s.getName();
                    String srollno = s.getRollno();


                Intent updatedelete = new Intent(getApplicationContext(), UpdateDelete.class);


                    updatedelete.putExtra("id", sid);
                    updatedelete.putExtra("name", sname);
                    updatedelete.putExtra("rollno", srollno);
                    startActivity(updatedelete);
                //}
            }
        });



        insertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Intent insertintent = new Intent(getApplicationContext(), Insert.class);
          startActivity(insertintent);
            }
        });
    }
}
