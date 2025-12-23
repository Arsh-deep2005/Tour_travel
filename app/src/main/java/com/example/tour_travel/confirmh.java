package com.example.tour_travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class confirmh extends AppCompatActivity {

    TextView newToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmh);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        newToHome= findViewById(R.id.newToHome);

        newToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(confirmh.this, home.class);
                startActivity(obj);
            }
        });
    }
}