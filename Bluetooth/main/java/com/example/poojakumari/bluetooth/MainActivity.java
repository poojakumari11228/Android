package com.example.poojakumari.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    private Set<BluetoothDevice> pairedDevices;
    private BluetoothAdapter BA;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);

        BA = BluetoothAdapter.getDefaultAdapter();
        BluetoothAdapter myBTadapter=BluetoothAdapter.getDefaultAdapter();
        if(myBTadapter==null)
        {
            Toast.makeText(getApplicationContext(), "Device doesn't support Bluetooth", Toast.LENGTH_LONG).show();
        }
        if(!myBTadapter.isEnabled())
        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0);
            Toast.makeText(getApplicationContext(), "Enabling Bluetooth!!", Toast.LENGTH_LONG).show();
        }


    }

    public void showDevicesPaired(View view) {
        pairedDevices = BA.getBondedDevices();

        List<String> s = new ArrayList<String>();
        for(BluetoothDevice bt : pairedDevices) {
            s.add(bt.getName());

            Log.d("", "name : " + bt.getName());
        }

       // arrayAdapter = new ArrayAdapter<>(this,pairedDevices,R.layout.support_simple_spinner_dropdown_item,R.id.list,pairedDevices);
        //lv.setAdapter((ListAdapter) pairedDevices);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, s));

    }

    public void off_bluetooth(View view) {
        BA.disable();
        Toast.makeText(this, "BLUETOOTH OFF!", Toast.LENGTH_SHORT).show();
    }
}


