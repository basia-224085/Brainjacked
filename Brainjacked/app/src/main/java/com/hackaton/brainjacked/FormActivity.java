package com.hackaton.brainjacked;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.brain.BrainActivity;

public class FormActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button finishForm = findViewById(R.id.finish_form);
        finishForm.setOnClickListener(v -> {
            startActivity(new Intent(this, BrainActivity.class));
        });
    }
}
