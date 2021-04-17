package com.hackaton.brainjacked;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TranslateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner first_language_spinner = null;
    Spinner second_language_spinner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        first_language_spinner =  findViewById(R.id.first_language_spinner);
        second_language_spinner = findViewById(R.id.second_language_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.available_language, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        first_language_spinner.setAdapter(adapter);
        second_language_spinner.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Choose")
                .setTitle("asdasdasd");
        AlertDialog dialog = builder.create();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}