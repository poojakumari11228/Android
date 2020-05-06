package com.example.poojakumari.locationsupdates;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;


public class MainActivity extends AppCompatActivity {

    LocationRequest locationRequest;
    private static final String TAG = "loc" ;
    Address currLoc;
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    LocationCallback locationCallback;
    Geocoder geocoder;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);

        geocoder = new Geocoder(getApplicationContext(),Locale.getDefault());
        startLocationUpdates();
        
    }

    protected void startLocationUpdates(){

        // Create the location request to start receiving updates
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10*1000);
        locationRequest.setFastestInterval(2000);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        } else {
            Log.d(TAG, "getLocation: permissions granted");
        }

        locationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location location = locationResult.getLastLocation();
//                String msg = "Updated Location: " +Double.toString(location.getLatitude()) + "," +Double.toString(location.getLongitude());
                try {
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    currLoc = addresses.get(0);
                    tv.setText(currLoc.getAddressLine(0));
                    Toast.makeText(MainActivity.this, currLoc.getAddressLine(0), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        getFusedLocationProviderClient(this).requestLocationUpdates(locationRequest, locationCallback , null);

    }
}