package com.example.tour_travel;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;

public class profile_setting extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_GALLERY = 2;

    private ImageView logoicon, homeIcon;
    private Uri imageUri;
    private Button btn;

    // ✅ Profile fields
    EditText usernameField, numberField, emailfield, pssfield, pnofield, addfield, modefield;

    private SharedPreferences preferences;
    private static final String PREF_NAME = "profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_setting);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Views
        logoicon = findViewById(R.id.logoicon);
        homeIcon = findViewById(R.id.homeIcon);
        btn = findViewById(R.id.button);

        usernameField = findViewById(R.id.usernameField);
        numberField = findViewById(R.id.numberField);
        emailfield = findViewById(R.id.emailfield);
        pssfield = findViewById(R.id.pssfield);
        pnofield = findViewById(R.id.pnofield);
        addfield = findViewById(R.id.addfield);
        modefield = findViewById(R.id.modefield);

        // SharedPreferences
        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // 🔁 Load saved data
        loadProfileData();

        // 👆 Profile picture click
        logoicon.setOnClickListener(v -> {
            checkAndRequestPermissions();
            showImagePickerDialog();
        });

        // ⏪ Home icon
        homeIcon.setOnClickListener(v -> {
            Intent intent = new Intent(profile_setting.this, home.class);
            startActivity(intent);
        });

        // ✅ Save button
        btn.setOnClickListener(v -> {
            saveProfileData();
            Toast.makeText(profile_setting.this, "Profile Saved!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(profile_setting.this, home.class);
            startActivity(intent);
            finish();
        });
    }

    // ⬇️ Save image URI + all fields
    private void saveProfileData() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("imageUri", imageUri != null ? imageUri.toString() : null);
        editor.putString("username", usernameField.getText().toString());
        editor.putString("number", numberField.getText().toString());
        editor.putString("email", emailfield.getText().toString());
        editor.putString("password", pssfield.getText().toString());
        editor.putString("phone", pnofield.getText().toString());
        editor.putString("address", addfield.getText().toString());
        editor.putString("card", modefield.getText().toString());
        editor.apply();
    }

    // ⬇️ Load image + fields
    private void loadProfileData() {
        String savedUri = preferences.getString("imageUri", null);
        if (savedUri != null) {
            logoicon.setImageURI(Uri.parse(savedUri));
            imageUri = Uri.parse(savedUri);
        }
        usernameField.setText(preferences.getString("username", ""));
        numberField.setText(preferences.getString("number", ""));
        emailfield.setText(preferences.getString("email", ""));
        pssfield.setText(preferences.getString("password", ""));
        pnofield.setText(preferences.getString("phone", ""));
        addfield.setText(preferences.getString("address", ""));
        modefield.setText(preferences.getString("card", ""));
    }

    // ⬇️ Image Picker
    private void showImagePickerDialog() {
        String[] options = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose profile image");
        builder.setItems(options, (dialog, which) -> {
            if (which == 0) openCamera();
            else openGallery();
        });
        builder.show();
    }

    private void openCamera() {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "profile.jpg");
        imageUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                logoicon.setImageURI(imageUri);
            } else if (requestCode == REQUEST_GALLERY && data != null) {
                imageUri = data.getData();
                if (imageUri != null) {
                    logoicon.setImageURI(imageUri);
                }
            }
        }
    }

    // 🛑 Permissions
    private void checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }
    }
}
