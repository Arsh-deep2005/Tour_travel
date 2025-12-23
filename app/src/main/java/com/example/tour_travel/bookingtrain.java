package com.example.tour_travel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class bookingtrain extends AppCompatActivity {

    ImageView homeIcon, notification, search, acc;
    Button searchButton;

    // ✅ Booking form fields
    EditText fromField, toField, departureDate, returnDate, passengerField, cabinClass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookingtrain);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Bottom navigation
        homeIcon = findViewById(R.id.homeIcon);
        notification = findViewById(R.id.notification);
        search = findViewById(R.id.search);
        acc = findViewById(R.id.acc);

        // Form fields
        fromField = findViewById(R.id.fromField);
        toField = findViewById(R.id.toField);
        departureDate = findViewById(R.id.departureDate);
        returnDate = findViewById(R.id.returnDate);
        passengerField = findViewById(R.id.passengerField);
        cabinClass = findViewById(R.id.cabinClass);
        searchButton = findViewById(R.id.searchButton);

        // Bottom Nav Clicks
        homeIcon.setOnClickListener(v -> startActivity(new Intent(this, home.class)));
        notification.setOnClickListener(v -> startActivity(new Intent(this, notify.class)));
        search.setOnClickListener(v -> startActivity(new Intent(this, search.class)));
        acc.setOnClickListener(v -> startActivity(new Intent(this, profile_setting.class)));

        // ✅ Search button with validation
        searchButton.setOnClickListener(view -> {
            String from = fromField.getText().toString().trim();
            String to = toField.getText().toString().trim();
            String departDate = departureDate.getText().toString().trim();
            String returnDt = returnDate.getText().toString().trim();
            String passengerStr = passengerField.getText().toString().trim();
            String cabin = cabinClass.getText().toString().trim();

            // 1. Required fields
            if (from.isEmpty()) {
                fromField.setError("Enter source station");
                return;
            }
            if (to.isEmpty()) {
                toField.setError("Enter destination station");
                return;
            }
            if (departDate.isEmpty()) {
                departureDate.setError("Select departure date");
                return;
            }
            if (passengerStr.isEmpty()) {
                passengerField.setError("Enter number of passengers");
                return;
            }

            // 2. Source and Destination must differ
            if (from.equalsIgnoreCase(to)) {
                Toast.makeText(this, "Source and Destination cannot be same", Toast.LENGTH_SHORT).show();
                return;
            }

            // 3. Passenger count range (1–6)
            try {
                int passengers = Integer.parseInt(passengerStr);
                if (passengers < 1 || passengers > 6) {
                    passengerField.setError("Passengers must be between 1 and 6");
                    return;
                }
            } catch (NumberFormatException e) {
                passengerField.setError("Invalid passenger count");
                return;
            }

            // ✅ If all validations pass, go to train_schedule
            Intent obj = new Intent(bookingtrain.this, train_schedule.class);
            startActivity(obj);
        });
    }
}
