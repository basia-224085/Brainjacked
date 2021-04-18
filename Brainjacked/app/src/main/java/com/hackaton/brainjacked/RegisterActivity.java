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
import com.hackaton.brainjacked.services.ServiceGenerator;
import com.hackaton.brainjacked.services.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            String pass = password.getText().toString();
            String chip = implantNr.getText().toString();
            if (!pass.equals(confirmPassword.getText().toString())) {
                toast("Passwords do not match");
            } else if (!chip.matches("[0-9]+")) {
                toast("Implant number must contain only numbers");
            }
            registerIfUserIsHuman(chip, pass);
        });
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
    }

    void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    void registerIfUserIsHuman(String implantNr, String password) {
        Login login = new Login(implantNr, password);
        UserService userService = ServiceGenerator.createService(UserService.class);
        Call<LoginReturn> call = userService.login(login);
        call.enqueue(new Callback<LoginReturn>() {
            @Override
            public void onResponse(Call<LoginReturn> call, Response<LoginReturn> response) {
                Log.e("MY", String.valueOf(response.code()));
                if (response.code() == 201) {
                    Intent intent = new Intent(getBaseContext(), FormActivity.class);
                    intent.putExtra("name",response.body().getFirst_name());
                    intent.putExtra("lastName",response.body().getLast_name());
                    intent.putExtra("chip", implantNr);
                    intent.putExtra("pass", password);
                    startActivity(intent);

                } else
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("ERROR")
                            .setMessage("You aren't HUMAN")
                            .setNegativeButton(android.R.string.ok, null)
                            .show();

            }

            @Override
            public void onFailure(Call<LoginReturn> call, Throwable t) {
                new AlertDialog.Builder(RegisterActivity.this)
                        .setTitle("ERROR")
                        .setMessage("You aren't HUMAN")
                        .setNegativeButton(android.R.string.ok, null)
                        .show();
            }
        });
    }
}