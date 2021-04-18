package com.hackaton.brainjacked.brain;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.Personality;
import com.hackaton.brainjacked.R;

public class MyBrainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_brain_activity);

        //TODO: trzeba ogarnac static klase
        TextView firstLetter = findViewById(R.id.first_letter);
        TextView secondLetter = findViewById(R.id.second_letter);
        TextView thirdLetter = findViewById(R.id.third_letter);
        TextView fourthLetter = findViewById(R.id.fourth_letter);


    }
}
