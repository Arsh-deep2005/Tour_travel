package com.example.tour_travel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class train_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_train_schedule);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        RecyclerView recycler_train = findViewById(R.id.trainRecycler);
        recycler_train.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<trainmodal> train_list = new ArrayList<>();

        // ✅ Now this calls the correct constructor
        train_list.add(new trainmodal("Thirukkural Express", "47h 5m", "2,540", "AC 3 Tier", "Available", "05:15", "04:20", "Departure", "Arrival"));
        train_list.add(new trainmodal("Himsagar Express", "71h 15m", "2,750", "AC 3 Tier", "Available", "12:45", "12:00", "Departure", "Arrival"));
        train_list.add(new trainmodal("Navyug Express", "68h 15m", "2,600", "AC 3 Tier", "Available", "15:30", "11:45", "Departure", "Arrival"));
        train_list.add(new trainmodal("Gurudev Express", "53h 30m", "2,495", "AC 3 Tier", "Available", "06:40", "12:10", "Departure", "Arrival"));
        train_list.add(new trainmodal("Ten Jammu Express", "67h 30m", "2,800", "AC 3 Tier", "Available", "14:20", "09:50", "Departure", "Arrival"));
        train_list.add(new trainmodal("Tirunelveli Express", "63h 20m", "2,650", "AC 3 Tier", "Available", "08:10", "23:30", "Departure", "Arrival"));
        train_list.add(new trainmodal("Madurai Express", "61h 5m", "2,580", "AC 3 Tier", "Available", "10:45", "23:50", "Departure", "Arrival"));
        train_list.add(new trainmodal("Kochuveli Express", "59h 30m", "2,520", "AC 3 Tier", "Available", "07:25", "18:55", "Departure", "Arrival"));
        train_list.add(new trainmodal("Trivandrum Express", "57h 10m", "2,500", "AC 3 Tier", "Available", "11:30", "20:40", "Departure", "Arrival"));
        train_list.add(new trainmodal("Nagercoil Express", "60h 45m", "2,605", "AC 3 Tier", "Available", "04:00", "16:45", "Departure", "Arrival"));
        train_list.add(new trainmodal("Rameswaram Express", "65h 25m", "2,700", "AC 3 Tier", "Available", "16:50", "10:15", "Departure", "Arrival"));
        train_list.add(new trainmodal("Cape Express", "66h 40m", "2,755", "AC 3 Tier", "Available", "09:35", "04:15", "Departure", "Arrival"));

        train_adapter adapter = new train_adapter(this, train_list);
        recycler_train.setAdapter(adapter);
    }
}
