package com.hackaton.brainjacked.brain;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hackaton.brainjacked.LoginActivity;
import com.hackaton.brainjacked.R;

import java.util.List;

public class LanguagesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner first_language_spinner = null;
    Spinner second_language_spinner = null;
    Button record_text = null;
    TextView translated_text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        first_language_spinner =  findViewById(R.id.first_language_spinner);
        second_language_spinner = findViewById(R.id.second_language_spinner);
        record_text = findViewById(R.id.hold_to_translate);
        translated_text = findViewById(R.id.translated_text);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.available_language, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        first_language_spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.available_language_second, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        second_language_spinner.setAdapter(adapter2);

        record_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        displaySpeechRecognizer();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // RELEASED
                        break;
                }
                return false;
            }
        });

        new AlertDialog.Builder(LanguagesActivity.this)
                .setTitle("!!! Warning !!!")
                .setMessage("Premium function... \nSend to us 10 HARNOLDS ;) to received translation to other languages")
                .setNegativeButton(android.R.string.ok, null)
                .setIcon(R.drawable.harnold)
                .setPositiveButton("Try premium",null)
                .show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private static final int SPEECH_REQUEST_CODE = 0;

    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// This starts the activity and populates the intent with the speech text.
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    // This callback is invoked when the Speech Recognizer returns.
// This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            translated_text.setText(spokenText);

            
            // Do something with spokenText.
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}