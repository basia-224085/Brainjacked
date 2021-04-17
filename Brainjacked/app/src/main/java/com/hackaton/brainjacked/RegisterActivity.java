package com.hackaton.brainjacked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText implantNr = findViewById(R.id.implant_nr);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirm_password);

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> {
            if(password.getText() != confirmPassword.getText()) {
                toast("Passwords do not match");
            } else if(!implantNr.getText().toString().matches("[0-9]+")) {
                toast("Implant number must contain only numbers");
            }
            // TODO: add new user to the database
            // startActivity(new Intent(this, MainActivity.class));
        });
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }

    void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}