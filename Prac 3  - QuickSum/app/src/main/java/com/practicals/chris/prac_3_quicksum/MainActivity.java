package com.practicals.chris.prac_3_quicksum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView result;
    boolean otherButtonPressed;

    public Button one;
    public Button two;
    public Button three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        otherButtonPressed = false;

        SharedPreferences preferences = getSharedPreferences("file", MODE_PRIVATE);

        ConstraintLayout layout = findViewById(R.id.layout);
        String hexColor = preferences.getString("rgb", null);
        if (hexColor != null) {
//            Log.i("color", hexColor);
            layout.setBackgroundColor(Color.parseColor(hexColor));

        }

        result = findViewById(R.id.txt_result);

        one = findViewById(R.id.btn_1);
        one.setOnClickListener(this);

        two = findViewById(R.id.btn_2);
        two.setOnClickListener(this);

        three = findViewById(R.id.btn_3);
        three.setOnClickListener(this);

        Button four = findViewById(R.id.btn_4);
        four.setOnClickListener(this);

        Button five = findViewById(R.id.btn_5);
        five.setOnClickListener(this);

        Button six = findViewById(R.id.btn_6);
        six.setOnClickListener(this);

        Button seven = findViewById(R.id.btn_7);
        seven.setOnClickListener(this);

        Button eight = findViewById(R.id.btn_8);
        eight.setOnClickListener(this);

        Button nine = findViewById(R.id.btn_9);
        nine.setOnClickListener(this);

        Button other = findViewById(R.id.btn_other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherButtonPressed = true;
                swapButtonText();
            }
        });

        Button config = findViewById(R.id.btn_config);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, configurationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void swapButtonText() {
        if (otherButtonPressed) {
            one.setText(R.string.b1_2);
            two.setText(R.string.b2_3);
            three.setText(R.string.b3_4);
        } else {
            one.setText(R.string.b1);
            two.setText(R.string.b2);
            three.setText(R.string.b3);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_1:
                if (!otherButtonPressed) {
                    addNumberToTotal(1);
                } else {
                    addNumberToTotal(1 / 2f);
                    otherButtonPressed = false;
                    swapButtonText();
                }
                break;

            case R.id.btn_2:
                if (!otherButtonPressed) {
                    addNumberToTotal(2);
                } else {
                    addNumberToTotal(1 / 3f);
                    otherButtonPressed = false;
                    swapButtonText();
                }
                break;

            case R.id.btn_3:
                if (!otherButtonPressed) {
                    addNumberToTotal(3);
                } else {
                    addNumberToTotal(1 / 4f);
                    otherButtonPressed = false;
                    swapButtonText();
                }
                break;

            case R.id.btn_4:
                addNumberToTotal(4);
                break;

            case R.id.btn_5:
                addNumberToTotal(5);
                break;

            case R.id.btn_6:
                addNumberToTotal(6);
                break;

            case R.id.btn_7:
                addNumberToTotal(7);
                break;

            case R.id.btn_8:
                addNumberToTotal(8);
                break;

            case R.id.btn_9:
                addNumberToTotal(9);
                break;
        }
    }

    private void addNumberToTotal(float addition) {
        float currentTotal;

        try {
            currentTotal = Float.parseFloat(result.getText().toString());
        } catch (NumberFormatException e) {
            Log.e("QuickSum", e.toString());
            currentTotal = 0;
        }

        float newTotal;

        newTotal = currentTotal + addition;
        result.setText(String.valueOf(newTotal));
    }
}

