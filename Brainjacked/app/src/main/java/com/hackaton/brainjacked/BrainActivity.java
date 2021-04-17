package com.hackaton.brainjacked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;


public class BrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_activity);

        Button memory = findViewById(R.id.memory);
        Button languages = findViewById(R.id.languages);
        Button emotions = findViewById(R.id.emotions);
        Button logic = findViewById(R.id.logic);
        Button my_brain = findViewById(R.id.my_brain);
        Button sleep = findViewById(R.id.sleep);

    }
}