package com.hackaton.brainjacked;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.DTO.Login;
import com.hackaton.brainjacked.DTO.LoginReturn;
import com.hackaton.brainjacked.brain.BrainActivity;
import com.hackaton.brainjacked.services.ServiceGenerator;
import com.hackaton.brainjacked.services.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText implantNr = findViewById(R.id.implant_nr);
        EditText password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> {
            // TODO: check if user exists in a database
            Login login = new Login(implantNr.getText().toString(), password.getText().toString());
            UserService userService = ServiceGenerator.createService(UserService.class);
            Call<LoginReturn> call = userService.login(login);
            call.enqueue(new Callback<LoginReturn>() {
                @Override
                public void onResponse(Call<LoginReturn> call, Response<LoginReturn> response) {
                    Log.e("MY",String.valueOf(response.code()));
                    if(response.code()==201) {
                        String welcomeMessage = "Welcome to Brainjacked \n" + response.body().getFirst_name() + " " + response.body().getLast_name();
                        Toast.makeText(getBaseContext(), welcomeMessage, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, BrainActivity.class));
                    }
                    else
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("Warning")
                                .setMessage("Please input correct credintials")
                                .setNegativeButton(android.R.string.ok, null)
                                .show();

                }

                @Override
                public void onFailure(Call<LoginReturn> call, Throwable t) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Warning")
                            .setMessage("Please input correct credintials")
                            .setNegativeButton(android.R.string.ok, null)
                            .show();
                }
            });
            //startActivity(new Intent(this, BrainActivity.class));
        });
        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
}