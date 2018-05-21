package com.kumar.pavan.myapplication.moo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kumar.pavan.myapplication.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    private static final int REQUEST_LOCATION = 1;
    Button btclick,btsubmit;
    private String addressLocation;
    private ImageView ivcapturedimage;
    TextView tvlocation;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_screen);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        Intent intent=getIntent();

        tvlocation = (TextView)findViewById(R.id.tvlocation);
        addressLocation=intent.getStringExtra("addressLocation");
        tvlocation.setText(intent.getStringExtra("addressLocation"));
        btclick = (Button)findViewById(R.id.button_click);
        btsubmit=(Button)findViewById(R.id.btsubmit);
        ivcapturedimage=(ImageView)findViewById(R.id.ivcapturedimage);
        btclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(LocationActivity.this,SosReportActivity.class);
             intent.putExtra("photo",photo);
                intent.putExtra("addressLocation",addressLocation);
             startActivity(intent);
            }
        });

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
             photo = (Bitmap) data.getExtras().get("data");
            ivcapturedimage.setVisibility(View.VISIBLE);
            ivcapturedimage.setImageBitmap(photo);
        }
    }
}