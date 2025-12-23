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

public class FlightSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flight_schedule);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        RecyclerView flight = findViewById(R.id.flightRecycler);
        flight.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<flightmodal> flight_list = new ArrayList<>();

        flight_list.add(new flightmodal("Indigo", "2h2min","4,500","Economy","available","1:00","3:01","Departure","Arrival"));

        flight_list.add(new flightmodal("IndiGo",       "2h 00m", "₹3,500",  "Economy", "available", "06:00", "08:00", "Departure", "Arrival"));
        flight_list.add(new flightmodal("Air India Express","2h 20m", "₹4,200",  "Economy", "available", "07:15", "09:35", "Departure", "Arrival"));
        flight_list.add(new flightmodal("IndiGo",       "2h 00m", "₹3,450",  "Economy", "available", "09:00", "11:00", "Departure", "Arrival"));
        flight_list.add(new flightmodal("SpiceJet",     "2h 00m", "₹3,600",  "Economy", "available", "10:30", "12:30", "Departure", "Arrival"));
        flight_list.add(new flightmodal("Air India",    "2h 23m", "₹4,000",  "Economy", "available", "11:45", "14:08", "Departure", "Arrival"));
        flight_list.add(new flightmodal("IndiGo",       "2h 40m", "₹4,500",  "Economy", "available", "12:15", "14:55", "Departure", "Arrival")); // Goa
        flight_list.add(new flightmodal("SpiceJet",     "2h 15m", "₹3,800",  "Economy", "available", "13:00", "15:15", "Departure", "Arrival"));
        flight_list.add(new flightmodal("Air India Express","2h 00m","₹3,550",  "Economy", "available", "14:30", "16:30", "Departure", "Arrival"));
        flight_list.add(new flightmodal("IndiGo",       "2h 00m", "₹3,400",  "Economy", "available", "15:00", "17:00", "Departure", "Arrival"));
        flight_list.add(new flightmodal("SpiceJet",     "2h 00m", "₹3,650",  "Economy", "available", "16:30", "18:30", "Departure", "Arrival"));
        flight_list.add(new flightmodal("Air India",    "2h 00m", "₹3,700",  "Economy", "available", "17:45", "19:45", "Departure", "Arrival"));
        flight_list.add(new flightmodal("IndiGo",       "2h 00m", "₹3,550",  "Economy", "available", "18:30", "20:30", "Departure", "Arrival"));
        flight_list.add(new flightmodal("SpiceJet",     "2h 00m", "₹3,600",  "Economy", "available", "19:00", "21:00", "Departure", "Arrival"));
        flight_list.add(new flightmodal("Air India Express","2h 00m","₹3,480",  "Economy", "available", "20:15", "22:15", "Departure", "Arrival"));
        flight_list.add(new flightmodal("IndiGo",       "2h 00m", "₹3,500",  "Economy", "available", "21:00", "23:00", "Departure", "Arrival"));



        adapter_flight adapater1 = new adapter_flight(this,flight_list);
        flight.setAdapter(adapater1);



    }
}