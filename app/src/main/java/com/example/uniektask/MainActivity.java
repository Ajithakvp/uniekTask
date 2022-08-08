package com.example.uniektask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity   {


    ImageView image, image3, image1, image2;
    FusedLocationProviderClient fusedLocationProviderClient;
    private final static int REQUEST_CODE = 100;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    LinearLayout hiddenview, hiddenview1;
    TextView tvInsert, tvView, tvIcon, tvMap;

    RelativeLayout rlayout1,rlayout;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        tvMap = findViewById(R.id.tvMap);
        hiddenview = findViewById(R.id.hiddenview);
        hiddenview1 = findViewById(R.id.hiddenview1);
        rlayout1=findViewById(R.id.rlayout1);
        rlayout=findViewById(R.id.rlayout);

        tvInsert = findViewById(R.id.tvInsert);
        tvView = findViewById(R.id.tvView);
        tvIcon = findViewById(R.id.tvIcon);



        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        tvMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map();

            }
        });


        rlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenview1.getVisibility() == View.VISIBLE) {
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.GONE);
                    hiddenview1.setVisibility(View.GONE);
                } else {
                    image1.setVisibility(View.GONE);
                    image2.setVisibility(View.VISIBLE);
                    hiddenview1.setVisibility(View.VISIBLE);
                }
            }
        });

        rlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenview1.getVisibility() == View.VISIBLE) {
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.GONE);
                    hiddenview1.setVisibility(View.GONE);
                } else {
                    image1.setVisibility(View.GONE);
                    image2.setVisibility(View.VISIBLE);
                    hiddenview1.setVisibility(View.VISIBLE);
                }
            }
        });


        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenview.getVisibility() == View.VISIBLE) {
                    image.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.GONE);
                    hiddenview.setVisibility(View.GONE);
                } else {
                    image3.setVisibility(View.VISIBLE);
                    image.setVisibility(View.GONE);
                    hiddenview.setVisibility(View.VISIBLE);
                }


            }
        });


        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenview.getVisibility() == View.VISIBLE) {
                    image.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.GONE);
                    hiddenview.setVisibility(View.GONE);
                } else {
                    image3.setVisibility(View.VISIBLE);
                    image.setVisibility(View.GONE);
                    hiddenview.setVisibility(View.VISIBLE);
                }
            }
        });

        tvInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });
        tvIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        drawerLayout = findViewById(R.id.drawLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Navopen, R.string.Navclose);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void Map() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        String Locate = addresses.get(0).getAddressLine(0);

                        Toast.makeText(MainActivity.this, Locate, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        } else {
            permission();
        }
    }

    private void permission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, REQUEST_CODE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Map();
            } else {
                Toast.makeText(MainActivity.this, "not Access", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }












}