package com.kumar.pavan.myapplication.moo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.kumar.pavan.myapplication.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by amrut on 3/18/2018.
 */

public class HomeScreenActivity  extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    private GoogleApiClient googleApiClient;
    private Location myLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private final int LOCATION_PERMISSION_REQUEST = 100;
    private Button btReportIncident,btSafety;
    private String addressLocation;
    private ImageView ivSos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        initviews();

        createGoogleApiClient();

        btReportIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReportActivity= new Intent();
                ReportActivity.setClass(HomeScreenActivity.this,ReportActivity.class);
                startActivity(ReportActivity);
            }
        });
        ivSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMyLocation();
//
            }
        });
        btSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReportActivity= new Intent();
                ReportActivity.setClass(HomeScreenActivity.this,SafetyActivity.class);
                startActivity(ReportActivity);
            }
        });
    }


    private void createGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    private void getMyLocation() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_PERMISSION_REQUEST);
                return;
            } else {

                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        myLocation = location;
                        Log.d("myLocationone","myLocation"+myLocation);

                    }
                });
            }

        } else {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    myLocation = location;
                    Log.d("myLocation","myLocation"+myLocation);
                }
            });
        }

        if (myLocation != null) {

            Double latitude = myLocation.getLatitude();
            Double longitude =  myLocation.getLongitude();

            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName(); // Only if availabl
                addressLocation=address;
                Intent ReportActivity= new Intent();
                ReportActivity.setClass(HomeScreenActivity.this,LocationActivity.class);
                ReportActivity.putExtra("addressLocation",addressLocation);
                startActivity(ReportActivity);
            } catch (IOException e) {
                e.printStackTrace();
            }



        } else {
            Toast.makeText(this,"Please make sure your GPS is on and press again",
                    Toast.LENGTH_SHORT).show();
            //addressLocation="Couldn't get your location.Please make sure the GPS is turned ON";
            //tvLatLng.setText("NCouldn't get your location.\nPlease make sure the GPS is turned O");
        }


    }

    private void initviews() {
        btReportIncident=(Button)findViewById(R.id.btReportIncident);
        ivSos=(ImageView) findViewById(R.id.ivSos);
        btSafety=(Button)findViewById(R.id.btSafety);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        getMyLocation();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please give access to location\nin order to fetch your current location", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
