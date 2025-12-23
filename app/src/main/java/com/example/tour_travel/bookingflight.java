package com.example.tour_travel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class bookingflight extends AppCompatActivity {

    ImageView homeIcon, notification, search, acc;
    Button searchButton;

    // ✅ Booking form fields
    EditText fromField, toField, departureDate, returnDate, passengerField, cabinClass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookingflight);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Bottom navigation
        homeIcon = findViewById(R.id.homeIcon);
        notification = findViewById(R.id.notification);
        search = findViewById(R.id.search);
        acc = findViewById(R.id.acc);
        searchButton = findViewById(R.id.searchButton);

        // ✅ Form fields
        fromField = findViewById(R.id.fromField);
        toField = findViewById(R.id.toField);
        departureDate = findViewById(R.id.departureDate);
        returnDate = findViewById(R.id.returnDate);
        passengerField = findViewById(R.id.passengerField);
        cabinClass = findViewById(R.id.cabinClass);

        // Bottom nav clicks
        homeIcon.setOnClickListener(v -> startActivity(new Intent(this, home.class)));
        notification.setOnClickListener(v -> startActivity(new Intent(this, notify.class)));
        search.setOnClickListener(v -> startActivity(new Intent(this, search.class)));
        acc.setOnClickListener(v -> startActivity(new Intent(this, profile_setting.class)));

        // ✅ Search with constraints
        searchButton.setOnClickListener(view -> {
            String from = fromField.getText().toString().trim();
            String to = toField.getText().toString().trim();
            String departDate = departureDate.getText().toString().trim();
            String returnDt = returnDate.getText().toString().trim();
            String passengersStr = passengerField.getText().toString().trim();
            String cabin = cabinClass.getText().toString().trim();

            // 1. Required fields
            if (from.isEmpty()) {
                fromField.setError("Enter source airport");
                return;
            }
            if (to.isEmpty()) {
                toField.setError("Enter destination airport");
                return;
            }
            if (departDate.isEmpty()) {
                departureDate.setError("Select departure date");
                return;
            }
            if (passengersStr.isEmpty()) {
                passengerField.setError("Enter number of passengers");
                return;
            }
            if (cabin.isEmpty()) {
                cabinClass.setError("Select cabin class");
                return;
            }

            // 2. Source and destination must differ
            if (from.equalsIgnoreCase(to)) {
                Toast.makeText(this, "Source and Destination cannot be the same", Toast.LENGTH_SHORT).show();
                return;
            }

            // 3. Passenger count range (1–9 for flights)
            try {
                int passengers = Integer.parseInt(passengersStr);
                if (passengers < 1 || passengers > 9) {
                    passengerField.setError("Passengers must be between 1 and 9");
                    return;
                }
            } catch (NumberFormatException e) {
                passengerField.setError("Invalid passenger number");
                return;
            }

            // 4. Departure and Return check (optional – skip if one-way)
            if (!returnDt.isEmpty() && departDate.equals(returnDt)) {
                Toast.makeText(this, "Departure and Return cannot be same", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ If all validations pass, move to FlightSchedule
            Intent obj = new Intent(bookingflight.this, FlightSchedule.class);
            startActivity(obj);
        });
    }
}
