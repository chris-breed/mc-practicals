package com.practicals.chris.prac6_foleyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    int snare, cymbal;
    SoundController soundController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundController = new SoundController(this);
        snare = soundController.addSound(R.raw.snare);
        cymbal = soundController.addSound(R.raw.cymbal);

        // Buttons
        Button top_left = findViewById(R.id.top_left);
        Button top_right = findViewById(R.id.top_right);
        Button bottom_left = findViewById(R.id.bottom_left);
        Button bottom_right = findViewById(R.id.bottom_right);


    }

    public void snareClick(View view) {
        Log.i("Sound", "Played snare sound clip.");
        soundController.play(snare);
    }

    public void cymbalClick(View view) {
        Log.i("Sound", "Played cymbal sound clip.");
        soundController.play(snare);
    }
}
