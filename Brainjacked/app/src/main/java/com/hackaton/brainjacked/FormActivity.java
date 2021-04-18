package com.hackaton.brainjacked;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.DTO.Emotion;
import com.hackaton.brainjacked.DTO.Register;
import com.hackaton.brainjacked.DTO.RegisterReturn;
import com.hackaton.brainjacked.DTO.Skills;
import com.hackaton.brainjacked.brain.BrainActivity;
import com.hackaton.brainjacked.services.ServiceGenerator;
import com.hackaton.brainjacked.services.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        String chip= null , pass = null;

        try{
            Bundle bundle = getIntent().getExtras();
            chip = (bundle.getString("chip"));
            pass = (bundle.getString("pass"));
        }catch (Exception e){

        }

        ToggleButton EI = findViewById(R.id.e_i);
        ToggleButton EI2 = findViewById(R.id.e_i2);
        ToggleButton EI3 = findViewById(R.id.e_i3);

        ToggleButton NS = findViewById(R.id.n_s);
        ToggleButton NS2 = findViewById(R.id.n_s2);
        ToggleButton NS3 = findViewById(R.id.n_s3);

        ToggleButton TF = findViewById(R.id.t_f);
        ToggleButton TF2 = findViewById(R.id.t_f2);
        ToggleButton TF3 = findViewById(R.id.t_f3);

        ToggleButton PJ = findViewById(R.id.p_j);
        ToggleButton PJ2 = findViewById(R.id.p_j2);
        ToggleButton PJ3 = findViewById(R.id.p_j3);

        Button finishForm = findViewById(R.id.finish_form);
        String finalPass = pass;
        String finalChip = chip;
        finishForm.setOnClickListener(v -> {
            int ei = 0;
            if (EI.isChecked()) ei++;
            if (EI2.isChecked()) ei++;
            if (EI3.isChecked()) ei++;

            int ns = 1;
            if (NS.isChecked()) ns++;
            if (NS2.isChecked()) ns--;
            if (NS3.isChecked()) ns++;

            int tf = 0;
            if (TF.isChecked()) tf++;
            if (TF2.isChecked()) tf++;
            if (TF3.isChecked()) tf++;

            int pj = 1;
            if (PJ.isChecked()) pj++;
            if (PJ2.isChecked()) pj--;
            if (PJ3.isChecked()) pj++;

            Personality.Letters letters = new Personality.Letters();
            if (ei > 1) letters.firstLetter = 'e';
            else letters.firstLetter = 'i';

            if (ns > 1) letters.secondLetter = 'n';
            else letters.secondLetter = 's';

            if (tf > 1) letters.thirdLetter = 't';
            else letters.thirdLetter = 'f';

            if (pj > 1) letters.fourthLetter = 'p';
            else letters.fourthLetter = 'j';
            Log.e("MY", String.valueOf(letters.firstLetter + letters.secondLetter + letters.thirdLetter + letters.fourthLetter));
            register(String.valueOf(letters.firstLetter + letters.secondLetter + letters.thirdLetter + letters.fourthLetter), finalChip, finalPass);
            //startActivity(new Intent(this, BrainActivity.class));
        });
    }

    private void register(String person, String chip, String pass) {
        Register register = new Register();
        register.setPersonalityType(person.toUpperCase());
        register.setFirst_name("q");
        register.setLast_name("q");
        register.setPassword(pass);
        register.setChip_code(chip);
        register.setDominantHalf("Left");
        register.setSkills(new Skills(new Emotion()));
        UserService userService = ServiceGenerator.createService(UserService.class);
        Call<RegisterReturn> call = userService.register(register);
        call.enqueue(new Callback<RegisterReturn>() {
            @Override
            public void onResponse(Call<RegisterReturn> call, Response<RegisterReturn> response) {
                Log.e("MY", String.valueOf(response.code()));
                if (response.code() == 200)
                    startActivity(new Intent(FormActivity.this, BrainActivity.class));
                else
                    new AlertDialog.Builder(FormActivity.this)
                            .setTitle("Warning")
                            .setMessage("Soemthing went wrong")
                            .setNegativeButton(android.R.string.ok, null)
                            .show();

            }

            @Override
            public void onFailure(Call<RegisterReturn> call, Throwable t) {
                new AlertDialog.Builder(FormActivity.this)
                        .setTitle("Warning")
                        .setMessage("Soemthing went wrong")
                        .setNegativeButton(android.R.string.ok, null)
                        .show();
            }
        });
    }
}
