package com.example.trip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class Delhi extends AppCompatActivity {
    ImageView P;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_attractions_varanasi);
        P=findViewById(R.id.imageView14);
        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Delhi.this, MainHomePage.class));
                finish();
            }
        });
    }


}
