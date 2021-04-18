package com.hackaton.brainjacked;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.brain.BrainActivity;

public class FormActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

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

            if (ns > 1) letters.firstLetter = 'n';
            else letters.firstLetter = 's';

            if (tf > 1) letters.firstLetter = 't';
            else letters.firstLetter = 'f';

            if (pj > 1) letters.firstLetter = 'p';
            else letters.firstLetter = 'j';

            startActivity(new Intent(this, BrainActivity.class));
        });
    }
}
