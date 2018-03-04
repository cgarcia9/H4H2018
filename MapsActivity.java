package com.example.carlosgarcia.firetracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Random;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double minla = 37.000;
        double maxla = 38.000;
        double minlo = -122.000;
        double maxlo = -121.000;

        // Add a marker in Sydney and move the camera
        for(int i=0; i < 5; i++)
        {
            Random r = new Random();
            double randomla = minla + (maxla- minla) * r.nextDouble();
            double randomlo = minlo + (maxlo- minlo) * r.nextDouble();
            LatLng sydney = new LatLng(randomla, randomlo);

            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

    }


}
