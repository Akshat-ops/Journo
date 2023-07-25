package com.example.trip;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterViewFlipper;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;


public class MainHomePage extends AppCompatActivity {

    AdapterViewFlipper flipper;
    ArrayList<AdapterFlipperModel> flipper_data;
    AdapterFlipper_BaseAdapter flipper_baseadapter;


    CardView amritsar,Delhi1;
    ImageView Profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        Profile = findViewById(R.id.imageView11);
        Delhi1=findViewById(R.id.Vns);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHomePage.this, Settings.class);
                startActivity(intent);
                finish();
            }
        });

        flipper = findViewById(R.id.adapterViewFlipper); //main flipper of the home which would be shown in application

        flipper_data = new ArrayList<>();

        //Adding items to flipper_data arraylist.
        flipper_data.add(new AdapterFlipperModel("Taj Mahal", "Agra", R.drawable.agra_taj_mahal)); //setting values to the items which were in the constructor of model adpater java class
        flipper_data.add(new AdapterFlipperModel("Akshardham Temple", "Delhi", R.drawable.new_delhi_akshardham_temple));
        flipper_data.add(new AdapterFlipperModel("Amritsar Golden Temple", "Amritsar", R.drawable.amritsar_golden_temple));
        flipper_data.add(new AdapterFlipperModel("Lake Pichola", "Udaipur", R.drawable.udaipur_lake_pichola));
        flipper_data.add(new AdapterFlipperModel("Victoria Memorial Hall", "Kolkata", R.drawable.kolkata_victoria_memorial_hall));

        //Setting the adapter
        flipper_baseadapter = new AdapterFlipper_BaseAdapter(this, flipper_data);
        flipper.setAdapter(flipper_baseadapter);

        //Few settings for controlling the flipper
        flipper.setAutoStart(true); //start when the application starts without the user click.
        flipper.setFlipInterval(3000); //3000 milliseconds = 3 seconds.

        amritsar = findViewById(R.id.Tap);
        amritsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainHomePage.this, City_Information.class));
            }
        });
        Delhi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainHomePage.this, Delhi.class));
                finish();
            }
        });


    }


    public void Browser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.makemytrip.com/hotels/"));
        startActivity(intent);
    }
}




