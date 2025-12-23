package com.example.tour_travel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hotel_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel_schedule);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        RecyclerView recyler_hotel = findViewById(R.id.hotelScheduleRecycler);

        recyler_hotel.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<hotelmodal> list = new ArrayList<>();
        list.add(new hotelmodal("The Oberoi Cecil", "Shimla", "checkin", "checkout", "AC", "Available", "13,500"));
        list.add(new hotelmodal("Wildflower Hall", "Shimla", "checkin", "checkout", "AC", "Available", "31,000"));
        list.add(new hotelmodal("Welcomhotel by ITC, Shimla", "Shimla", "checkin", "checkout", "AC", "Available", "10,519"));
        list.add(new hotelmodal("The Orchid Shimla", "Shimla", "checkin", "checkout", "AC", "Available", "5,222"));
        list.add(new hotelmodal("Snow Valley Resorts", "Shimla", "checkin", "checkout", "AC", "Available", "3,070"));
        list.add(new hotelmodal("WelcomHeritage Elysium Resort & Spa", "Shimla", "checkin", "checkout", "AC", "Available", "10,814"));
        list.add(new hotelmodal("Radisson Kufri Hotel Shimla", "Shimla", "checkin", "checkout", "AC", "Available", "10,900"));
        list.add(new hotelmodal("Plan – Marina‑Shimla Designer Boutique Hotel", "Shimla", "checkin", "checkout", "AC", "Available", "6,000"));
        list.add(new hotelmodal("Treebo Maharaja", "Shimla", "checkin", "checkout", "AC", "Available", "1,100"));
        list.add(new hotelmodal("Hotel Willow Banks", "Shimla", "checkin", "checkout", "AC", "Available", "5,000"));
        list.add(new hotelmodal("Hotel CK International", "Shimla", "checkin", "checkout", "AC", "Available", "3,000"));
        list.add(new hotelmodal("Hotel Prestige Shimla", "Shimla", "checkin", "checkout", "AC", "Available", "1,360"));
        list.add(new hotelmodal("Hotel Silverine", "Shimla", "checkin", "checkout", "AC", "Available", "2,500"));
        list.add(new hotelmodal("Kamna Hill Resort", "Shimla", "checkin", "checkout", "AC", "Available", "2,500"));
        list.add(new hotelmodal("Hotel Baljees Residency", "Shimla", "checkin", "checkout", "AC", "Available", "3,000"));
        list.add(new hotelmodal("Woodville Palace Hotel", "Shimla", "checkin", "checkout", "AC", "Available", "4,000"));
        list.add(new hotelmodal("Peterhoff (heritage HPTDC hotel)", "Shimla", "checkin", "checkout", "AC", "Available", "premium"));



        hotel_adapter adapter = new hotel_adapter(this,list);
        recyler_hotel.setAdapter(adapter);



    }
}