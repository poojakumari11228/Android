package com.example.user.lab10sqllitedatabases;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDelete extends AppCompatActivity {
EditText rollno2;
EditText name2;
Button update1;
Button delete1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        rollno2 = findViewById(R.id.roll1);
        name2 = findViewById(R.id.name1);
        update1 = findViewById(R.id.update);
        delete1 = findViewById(R.id.delete);

        Intent newintent = getIntent();
        String getrollno = newintent.getStringExtra("rollno");
        String getname = newintent.getStringExtra("name");
        final int getid = newintent.getIntExtra("id", 0);
        rollno2.setText(getrollno);
        name2.setText(getname);

        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = name2.getText().toString();
                String newrollno = rollno2.getText().toString();

                Student newstudent = new Student();
                newstudent.setId(getid);
                newstudent.setName(newname);
                newstudent.setRollno(newrollno);
                MainActivity.database.dao().updateStudent(newstudent);

                Toast.makeText(getApplicationContext(), "Student Info Updated" , Toast.LENGTH_LONG).show();
                finish();

            }
        });

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student newstudent = new Student();
                newstudent.setId(getid);
                MainActivity.database.dao().deleteStudent(newstudent);

                Toast.makeText(getApplicationContext(), "Student Info Deleted" , Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}
