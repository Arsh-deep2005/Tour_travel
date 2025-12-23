package com.example.tour_travel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.Instant;

public class home extends AppCompatActivity {

    ImageView logoIcon, jhaj, train, hotel, profile, notification, search, insurance, restaurant, car, coupon, event, destination;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_home);


        jhaj = findViewById(R.id.jhaj);
        train = findViewById(R.id.train);
        hotel = findViewById(R.id.hotel);
        profile = findViewById(R.id.acc);
        logout = findViewById(R.id.logout);
        logoIcon = findViewById(R.id.logoicon);
        notification = findViewById(R.id.notification);
        search = findViewById(R.id.search);
        insurance = findViewById(R.id.insurance);
        restaurant = findViewById(R.id.restaurant);
        car = findViewById(R.id.car);
        coupon = findViewById(R.id.coupon);
        event = findViewById(R.id.event);
        destination = findViewById(R.id.destination);

        // ✅ Set saved profile image if available
        SharedPreferences sharedPreferences = getSharedPreferences("profile", MODE_PRIVATE);
        String savedUri = sharedPreferences.getString("imageUri", null);
        if (savedUri != null) {
            logoIcon.setImageURI(Uri.parse(savedUri)); // 🔴 This line can crash on MIUI
        }


        // 👆 Clicking the logo opens profile setting screen (where camera/gallery can be selected)
        logoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(home.this, profile_setting.class);
                startActivity(obj);
            }
        });

        jhaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, bookingflight.class);
                startActivity(obj);
            }
        });

        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, bookingtrain.class);
                startActivity(obj);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, bookinghotel.class);
                startActivity(obj);
            }
        });

        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, extra.class);
                startActivity(obj);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(home.this, profile_setting.class);
                startActivity(obj);
            }
        });

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut(); // ✅ Proper logout
            Intent intent = new Intent(home.this, login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish(); // end home screen
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(home.this, notify.class);
                startActivity(obj);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(home.this, search.class);
                startActivity(obj);
            }
        });


//        logout.setOnClickListener(v -> {
//            FirebaseAuth.getInstance().signOut();
//            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//            if (currentUser == null) {
//                Log.d("Logout", "User signed out successfully.");
//            }
//            // ... same as before
//        });
    }
}