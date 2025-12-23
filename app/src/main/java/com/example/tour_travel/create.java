package com.example.tour_travel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class create extends AppCompatActivity {

    Button signup, cancel;
    TextView loginLink;
    EditText pss, email;
    CheckBox checkBox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize UI components
        loginLink = findViewById(R.id.loginLink);
        signup = findViewById(R.id.signup);
        cancel = findViewById(R.id.cancel);
        pss = findViewById(R.id.pss);
        checkBox = findViewById(R.id.checkBox);
        email = findViewById(R.id.email);

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create.this, login.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = email.getText().toString().trim();
                String password = pss.getText().toString().trim();

                if (!checkBox.isChecked()) {
                    checkBox.setError("You must accept the terms to sign up");
                    return;
                }

                if (!isValidEmail(emailStr)) {
                    email.setError("Enter a valid Gmail address");
                    return;
                }

                if (!isValidPassword(password)) {
                    pss.setError("Use min 6 characters with letters, numbers & symbols");
                    return;
                }

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailStr, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(create.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();

                                    // Clear back stack and go to Home
                                    Intent intent = new Intent(create.this, home.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(create.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(create.this, login.class));
            }
        });
    }

    // These methods should be outside onCreate() and onClick()
    public boolean isValidPassword(String pss) {
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$";
        return pss.matches(passwordRegex);
    }

    public boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
