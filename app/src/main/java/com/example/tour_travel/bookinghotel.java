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

public class bookinghotel extends AppCompatActivity {

    ImageView homeIcon, notification, search, acc;
    Button searchButton;

    // ✅ Form fields
    EditText hotelField, checkinDate, checkoutDate, guestsField, roomTypeField;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookinghotel);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Bottom toolbar icons
        homeIcon = findViewById(R.id.homeIcon);
        notification = findViewById(R.id.notification);
        search = findViewById(R.id.search);
        acc = findViewById(R.id.acc);

        // Form fields
        hotelField = findViewById(R.id.fromField);
        checkinDate = findViewById(R.id.toField);
        checkoutDate = findViewById(R.id.departureDate);
        guestsField = findViewById(R.id.returnDate);
        roomTypeField = findViewById(R.id.passengerField);
        searchButton = findViewById(R.id.searchButton);

        // Bottom Nav
        homeIcon.setOnClickListener(v -> startActivity(new Intent(this, home.class)));
        search.setOnClickListener(v -> startActivity(new Intent(this, hotel_schedule.class)));
        notification.setOnClickListener(v -> startActivity(new Intent(this, notify.class)));
        acc.setOnClickListener(v -> startActivity(new Intent(this, profile_setting.class)));

        // ✅ Search button with constraints
        searchButton.setOnClickListener(view -> {
            String hotel = hotelField.getText().toString().trim();
            String checkin = checkinDate.getText().toString().trim();
            String checkout = checkoutDate.getText().toString().trim();
            String guestsStr = guestsField.getText().toString().trim();
            String roomType = roomTypeField.getText().toString().trim();

            // 1. Required fields
            if (hotel.isEmpty()) {
                hotelField.setError("Enter hotel name");
                return;
            }
            if (checkin.isEmpty()) {
                checkinDate.setError("Select check-in date");
                return;
            }
            if (checkout.isEmpty()) {
                checkoutDate.setError("Select check-out date");
                return;
            }
            if (guestsStr.isEmpty()) {
                guestsField.setError("Enter number of guests");
                return;
            }
            if (roomType.isEmpty()) {
                roomTypeField.setError("Select room type");
                return;
            }

            // 2. Guests must be between 1–10
            try {
                int guests = Integer.parseInt(guestsStr);
                if (guests < 1 || guests > 10) {
                    guestsField.setError("Guests must be between 1 and 10");
                    return;
                }
            } catch (NumberFormatException e) {
                guestsField.setError("Invalid number of guests");
                return;
            }

            // 3. Check-out must be different from Check-in
            if (checkin.equals(checkout)) {
                Toast.makeText(this, "Check-in and Check-out cannot be same", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ If all validations pass, move to hotel schedule
            Intent obj = new Intent(bookinghotel.this, hotel_schedule.class);
            startActivity(obj);
        });
    }
}
