package com.practicals.chris.prac_3_quicksum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

public class configurationActivity extends AppCompatActivity {

    ImageView image;

    public EditText txt_red;
    public EditText txt_green;
    public EditText txt_blue;

    public SeekBar sb_red;
    public SeekBar sb_green;
    public SeekBar sb_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        txt_red = findViewById(R.id.txt_red);
        txt_green = findViewById(R.id.txt_green);
        txt_blue = findViewById(R.id.txt_blue);

        sb_red = findViewById(R.id.sb_red);
        sb_green = findViewById(R.id.sb_green);
        sb_blue = findViewById(R.id.sb_blue);

        image = findViewById(R.id.background_colour);

        setupTextListeners();
        setupSeekBarListeners();

        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intColor = Color.rgb(Integer.parseInt(txt_red.getText().toString()),
                        Integer.parseInt(txt_green.getText().toString()),
                        Integer.parseInt(txt_blue.getText().toString()));

                String hexColor = String.format("#%06X", (0xFFFFFF & intColor));

                SharedPreferences.Editor prefs = getSharedPreferences("file", MODE_PRIVATE).edit();
                prefs.putString("rgb", hexColor);
                prefs.apply();

                Intent intent = new Intent(configurationActivity.this, MainActivity.class);
                intent.putExtra("newColour", hexColor);
//                Log.i("color", hexColor);
                startActivity(intent);
            }
        });
    }

    private void setupSeekBarListeners() {
        sb_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_red.setText(Integer.toString(progress));
                updateDisplayColour();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_green.setText(Integer.toString(progress));
                updateDisplayColour();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_blue.setText(Integer.toString(progress));
                updateDisplayColour();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setupTextListeners() {
        txt_red.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    sb_red.setProgress(Integer.parseInt(s.toString()));
                    updateDisplayColour();
                }
            }

        });

        txt_green.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    sb_green.setProgress(Integer.parseInt(s.toString()));
                    updateDisplayColour();
                }
            }
        });

        txt_blue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    sb_blue.setProgress(Integer.parseInt(s.toString()));
                    updateDisplayColour();
                }
            }
        });
    }

    private void updateDisplayColour() {
        int color = Color.rgb(sb_red.getProgress(), sb_green.getProgress(), sb_blue.getProgress());
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        image.setColorFilter(Color.parseColor(hexColor));
    }
}
