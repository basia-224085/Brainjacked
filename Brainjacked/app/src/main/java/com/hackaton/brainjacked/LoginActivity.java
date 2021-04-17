package com.hackaton.brainjacked;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText implantNr = findViewById(R.id.implant_nr);
        EditText password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.register_button);
        loginButton.setOnClickListener(v -> {
            // TODO: check if user exists in a database
            // startActivity(new Intent(this, MainActivity.class));
        });
        Button registerButton = findViewById(R.id.login_button);
        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}