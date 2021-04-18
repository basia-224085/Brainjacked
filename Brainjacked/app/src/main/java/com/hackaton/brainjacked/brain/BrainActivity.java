package com.hackaton.brainjacked.brain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.hackaton.brainjacked.R;


public class BrainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_activity);

        Button memory = findViewById(R.id.memory);
        memory.setOnClickListener(v -> {
            startActivity(new Intent(this, MemoryActivity.class));
        });
        Button languages = findViewById(R.id.languages);
        languages.setOnClickListener(v -> {
            startActivity(new Intent(this, LanguagesActivity.class));
        });
        Button emotions = findViewById(R.id.emotions);
        emotions.setOnClickListener(v -> {
            startActivity(new Intent(this, EmotionsActivity.class));
        });
        Button logic = findViewById(R.id.logic);
        logic.setOnClickListener(v -> {
            startActivity(new Intent(this, LogicActivity.class));
        });
        Button my_brain = findViewById(R.id.my_brain);
        my_brain.setOnClickListener(v -> {
            startActivity(new Intent(this, MyBrainActivity.class));
        });
        Button sleep = findViewById(R.id.sleep);
        sleep.setOnClickListener(v -> {
            //TODO: log out
        });

    }
}