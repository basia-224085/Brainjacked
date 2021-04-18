package com.hackaton.brainjacked.brain;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaton.brainjacked.R;

public class MemoryActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button load = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_activity);
        load = findViewById(R.id.load_brain_button);
        load.setOnClickListener(v ->
        {
            dispatchTakePictureIntent();
        });
    }

    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        try {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        } catch (ActivityNotFoundException e) {
//            // display error state to the user
//        }
        new AlertDialog.Builder(MemoryActivity.this)
                .setTitle("!!! Warning !!!")
                .setMessage("Premium function... \nSend to us 15 HARNOLDS ;) to learn quick")
                .setNegativeButton(android.R.string.ok, null)
                .setIcon(R.drawable.harnold)
                .setPositiveButton("Try premium",null)
                .show();
    }
}