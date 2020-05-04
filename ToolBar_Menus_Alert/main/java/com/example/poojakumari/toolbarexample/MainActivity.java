package com.example.poojakumari.toolbarexample;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt;
    Toolbar tb;
    EditText et;
    ArrayList<String> list;
    ListView lv;
    ArrayAdapter<String> arrAdptr;
    ActionMode mActionMode;

    ///// calback function for contextual action bar
    public ActionMode.Callback mActionModcb = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.context_action_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.dlt_fromActionBar:
                    Toast.makeText(getApplicationContext(),"Deleting from context action bar",Toast.LENGTH_LONG).show();
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt = findViewById(R.id.button2);

        tb= findViewById(R.id.toolbar);
        et = findViewById(R.id.editText);
        lv = findViewById(R.id.list_item);

        setSupportActionBar(tb);
        //register view for context menu
        registerForContextMenu(lv);



        ////////////// For list view


        list = new ArrayList<String>();
        for(int i=1 ; i<=100 ; i++)
        {
            list.add("F16SW"+i);
        }

         arrAdptr = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(arrAdptr);

        lv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode!=null){return false;}
                mActionMode = MainActivity.this.startActionMode(mActionModcb);
                v.setSelected(true);
                return true;
            }
        });
    }

   //// For Alert
   public void showDltAlert(String title, String msg, final AdapterView.AdapterContextMenuInfo info) {

       AlertDialog.Builder myAlertBuilder = new
               AlertDialog.Builder(MainActivity.this);
       // Set the dialog title and message.
       myAlertBuilder.setTitle(title);
       myAlertBuilder.setMessage(msg);
       // Add the dialog buttons.
       myAlertBuilder.setPositiveButton("OK", new
             DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       // User clicked OK button.
                       arrAdptr.remove(arrAdptr.getItem(info.position));
                   }
               });
       myAlertBuilder.setNegativeButton("Cancel", new
               DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       // User cancelled the dialog.
                      Toast.makeText(getApplicationContext(), "Pressed" +      "     Cancel",   Toast.LENGTH_SHORT).show();

                   }
               });
       // Create and show the AlertDialog.
       myAlertBuilder.show();
   }


    //////////////option menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                Toast.makeText(getApplicationContext(),"clicked item id is "+item.getItemId(),Toast.LENGTH_LONG).show();
                break;
            case R.id.action_add:
                arrAdptr.add(et.getText().toString());
                Toast.makeText(getApplicationContext(),""+et.getText()+ " added!".toString(),Toast.LENGTH_LONG).show();
                et.setText("");
                break;
            default:
                    return false;
        }
        return super.onOptionsItemSelected(item);
    }

    /////// context menu


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.edit:
                Toast.makeText(getApplicationContext(),"clicked context item title is "+item.getTitle()+" value is "+arrAdptr.getItem(info.position),Toast.LENGTH_LONG).show();
              et.setText(arrAdptr.getItem(info.position));
                break;
            case R.id.dlt:
                showDltAlert("DELETE","Do you want to delete this item",info);

                default:
                return false;
        }
        return super.onContextItemSelected(item);
    }

    public void popup_bt(View view) {
        Toast.makeText(getApplicationContext(),"popup clicked",Toast.LENGTH_LONG).show();
        PopupMenu pop = new PopupMenu(this,bt);
        getMenuInflater().inflate(R.menu.popup_menu, pop.getMenu());

        pop.show();
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popup1:
                        Toast.makeText(getApplicationContext(),"clicked context item title is "+item.getTitle(),Toast.LENGTH_LONG).show();
                        break;
                    case R.id.popup2:
                        Toast.makeText(getApplicationContext(),"clicked context item title is "+item.getTitle(),Toast.LENGTH_LONG).show();
                        break;
                    default:
                        return false;
                }

                return false;
            }
        });
    }
}
