package com.example.trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class City_Information extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_information);

        ///// RECYCLER VIEW :

        list.add(new RecyclerViewModel("The Golden Temple", "2 km", R.drawable.amritsar_golden_temple, 4.5f));
        list.add(new RecyclerViewModel("Wagah Border", "28 km", R.drawable.amritsar_wagah_border, 4f));
        list.add(new RecyclerViewModel("Jallianwala Bagh", "2 km", R.drawable.amritsar_jallianwala_bagh, 4.5f));
        list.add(new RecyclerViewModel("Partition Museum", "3 km", R.drawable.amritsar_partition_museum, 3f));

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        decoration = new RecyclerViewItemDecoration(16);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(decoration);

    }
    public void Browser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fabhotels.com/blog/restaurants-in-amritsar/"));
        startActivity(intent);
    }
    public void Browser1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.makemytrip.com/hotels/amritsar-hotels.html"));
        startActivity(intent);
    }
    public void Browser2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Amritsar,+Punjab/@31.6335441,74.8701203,12z/data=!3m1!4b1!4m6!3m5!1s0x391964aa569e7355:0xeea2605bee84ef7d!8m2!3d31.6339793!4d74.8722642!16zL20vMDI5a3B5"));
        startActivity(intent);
    }
    public void Browser3(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tripadvisor.in/Tourism-g303884-Amritsar_Amritsar_District_Punjab-Vacations.html"));
        startActivity(intent);
    }
}
