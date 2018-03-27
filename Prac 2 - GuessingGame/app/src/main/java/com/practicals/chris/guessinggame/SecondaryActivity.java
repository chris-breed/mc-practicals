package com.practicals.chris.guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        prefs = getSharedPreferences("value", MODE_PRIVATE);

        final TextView txtMin = findViewById(R.id.currMin);
        final TextView txtMax = findViewById(R.id.currMax);

        minMax min_max = (minMax) getIntent().getSerializableExtra("minMax");
//        int min = extras.getInt("currMin");
//        int max = extras.getInt("currMax");

//        Log.i("Practicals", "The old mim was: " + min_max._min);
//        Log.i("Practicals", "The old max was: " + min_max._max);

        txtMin.setText(Integer.toString(min_max._min));
        txtMax.setText(Integer.toString(min_max._max));

        final SeekBar sbMin = findViewById(R.id.seekMin);
        sbMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtMin.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar sbMax = findViewById(R.id.seekMax);
        sbMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtMax.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btn = findViewById(R.id.btn_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minMax min_max = new minMax(Integer.parseInt(txtMin.getText().toString()), Integer.parseInt(txtMax.getText().toString()));
                Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);

                prefs.edit().putInt("min", sbMin.getProgress()).apply();
                prefs.edit().putInt("min", sbMax.getProgress()).apply();

                intent.putExtra("minmax", min_max);
//                intent.putExtra("min", Integer.parseInt(txtMin.getText().toString()));
//                intent.putExtra("max", Integer.parseInt(txtMax.getText().toString()));
                startActivity(intent);
            }
        });
    }
}
