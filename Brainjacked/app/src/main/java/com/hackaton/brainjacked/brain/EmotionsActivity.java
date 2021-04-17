package com.hackaton.brainjacked.brain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.R;

public class EmotionsActivity extends AppCompatActivity {
    private Button serotoninInject;
    private Button dopamineInject;
    private Button adrenalineInject;
    private Button glutamateInject;
    private Button testosteroneInject;
    private ImageView infoCloud;
    private TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotions_activity);
        ImageView emotionBrainy = findViewById(R.id.emotion_brainy);
        infoCloud = findViewById(R.id.info_cloud);
        infoCloud.setVisibility(View.INVISIBLE); // at the beginning there is no info
        infoText = findViewById(R.id.info_text);
        infoText.setVisibility(View.INVISIBLE);

        // injection buttons
        serotoninInject = findViewById(R.id.serotonin_button);
        dopamineInject = findViewById(R.id.dopamine_button);
        adrenalineInject = findViewById(R.id.adrenaline_button);
        glutamateInject = findViewById(R.id.glutamate_button);
        testosteroneInject = findViewById(R.id.testosterone_button);

        // serotonin
        ImageView serotoninInfo = findViewById(R.id.info_serotonin);
        serotoninInfo.setOnClickListener(v -> {
            showInfoCloud("Serotonin helps you sleep.");
        });
        serotoninInject.setOnClickListener(v -> {
            emotionBrainy.setImageResource(R.drawable.sleepy);
            disableInjections();
            // TODO: change state of brain of the user
        });

        // dopamine
        ImageView dopamineInfo = findViewById(R.id.info_dopamine);
        dopamineInfo.setOnClickListener(v -> {
            showInfoCloud("Dopamine makes you happy.");
        });
        dopamineInject.setOnClickListener(v -> {
            emotionBrainy.setImageResource(R.drawable.happy);
            disableInjections();
            // TODO: change state of brain of the user
        });

        // adrenaline
        ImageView adrenalineInfo = findViewById(R.id.info_adrenaline);
        adrenalineInfo.setOnClickListener(v -> {
            showInfoCloud("Adrenaline gives you stamina.");
        });
        adrenalineInject.setOnClickListener(v -> {
            emotionBrainy.setImageResource(R.drawable.energized);
            disableInjections();
            // TODO: change state of brain of the user
        });

        // glutamate
        ImageView glutamateInfo = findViewById(R.id.info_glutamate);
        glutamateInfo.setOnClickListener(v -> {
            showInfoCloud("Glutamate lets you focus.");
        });
        glutamateInject.setOnClickListener(v -> {
            emotionBrainy.setImageResource(R.drawable.focused);
            disableInjections();
            // TODO: change state of brain of the user
        });

        // testosterone
        ImageView testosteroneInfo = findViewById(R.id.info_testosterone);
        testosteroneInfo.setOnClickListener(v -> {
            showInfoCloud("Testosterone increases lust.");
        });
        testosteroneInject.setOnClickListener(v -> {
            emotionBrainy.setImageResource(R.drawable.aroused);
            disableInjections();
            // TODO: change state of brain of the user
        });

        // go back
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, BrainActivity.class));
        });
    }

    void disableInjections() {
        showInfoCloud("No new boosts for 3 hrs.");
        serotoninInject.setEnabled(false);
        serotoninInject.setBackgroundColor(Color.GRAY);
        dopamineInject.setEnabled(false);
        dopamineInject.setBackgroundColor(Color.GRAY);
        adrenalineInject.setEnabled(false);
        adrenalineInject.setBackgroundColor(Color.GRAY);
        glutamateInject.setEnabled(false);
        glutamateInject.setBackgroundColor(Color.GRAY);
        testosteroneInject.setEnabled(false);
        testosteroneInject.setBackgroundColor(Color.GRAY);
    }

    void showInfoCloud(String message) {
        infoCloud.setVisibility(View.VISIBLE);
        infoText.setText(message);
        infoText.setVisibility(View.VISIBLE);
    }
}