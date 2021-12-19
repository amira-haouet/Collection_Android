package com.example.androidprojectfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.example.androidprojectfirebase.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;
public class GeoActivity extends AppCompatActivity implements LocationListener{



        Button button_location;
        TextView textView_location;
        LocationManager locationManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView_location = findViewById(R.id.text_location);
            button_location = findViewById(R.id.button_location);
            //Runtime permissions
            if (ContextCompat.checkSelfPermission(GeoActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(GeoActivity.this,new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                },100);
            }


            button_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //create method
                    getLocation();
                }
            });



        }

        @SuppressLint("MissingPermission")
        private void getLocation() {

            try {
                locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,GeoActivity.this);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        public void onLocationChanged(Location location) {
            Toast.makeText(this, ""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();
            try {
                Geocoder geocoder = new Geocoder(GeoActivity.this, Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                String address = addresses.get(0).getAddressLine(0);

                textView_location.setText(address);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }