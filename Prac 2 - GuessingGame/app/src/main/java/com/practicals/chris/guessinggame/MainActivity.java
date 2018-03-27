package com.practicals.chris.guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int random_int;
    final int defaultMin = 1;
    final int defaultMax = 10;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView status = findViewById(R.id.txt_status);
        final EditText input = findViewById(R.id.txt_input);

        minMax extra = (minMax) getIntent().getSerializableExtra("minmax");
        int newMin;
        int newMax;

        int p_min = 0, p_max = 0;
        try {
            p_min = prefs.getInt("min", MODE_PRIVATE);
            p_max = prefs.getInt("max", MODE_PRIVATE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (!extra.isEmpty()) {
                newMin = extra._min;
                newMax = extra._max;
                random_int = new Random().nextInt(newMax - newMin) + newMin;
            } else if (p_min == 0 && p_max == 0) {
                newMin = defaultMin;
                newMax = defaultMax;
                random_int = new Random().nextInt(newMax - newMin) + newMin;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Button settings = findViewById(R.id.btn_configurations);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final minMax min_max = new minMax(defaultMin, defaultMax);
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
//                intent.putExtra("currMin", defaultMin);
//                intent.putExtra("currMax", defaultMax);
                intent.putExtra("minMax", min_max);
                startActivity(intent);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int entered_number = 0;

                try {
                    entered_number = Integer.parseInt(input.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.print("Didn't like an empty String");
                }

                if (entered_number == random_int) {
                    status.setText(R.string.correct);
                } else if (entered_number < random_int) {
                    status.setText(R.string.high);
                } else {
                    status.setText(R.string.low);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

