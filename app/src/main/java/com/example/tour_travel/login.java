package com.example.tour_travel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginBtn;
    TextView goToSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) getSupportActionBar().hide();

        // 🔒 Already logged in? Skip login
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(login.this, home.class));
            finish();
            return;
        }

        // Initialize views
        emailInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);
        loginBtn = findViewById(R.id.buttonLogin);
        goToSignup = findViewById(R.id.newToHome);

        // Navigate to sign up
        goToSignup.setOnClickListener(v -> {
            startActivity(new Intent(login.this, create.class));
        });

        // Login logic
        loginBtn.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String pass = passwordInput.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty()) {
                emailInput.setError("Enter valid email");
                passwordInput.setError("Enter valid password");
                Toast.makeText(login.this, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                return;
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent obj = new Intent(login.this, home.class);
                            obj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(obj);
                            finish();
                        } else {
                            Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
