package com.example.user.lab10sqllitedatabases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    EditText insertrollno;
    EditText insertname;
    Button insertbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        insertrollno=findViewById(R.id.roll);
        insertname=findViewById(R.id.name);
        insertbutton1=findViewById(R.id.btn1);

insertbutton1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name1= insertname.getText().toString();
        String rollno1 = insertrollno.getText().toString();
Student student = new Student();
student.setRollno(rollno1);
student.setName(name1);
MainActivity.database.dao().insertStudent(student);
Toast.makeText(getApplicationContext() ,"Student Inserted" , Toast.LENGTH_LONG ).show();

insertrollno.setText("");
insertname.setText("");

    }
});

    }
}
