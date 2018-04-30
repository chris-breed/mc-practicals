package com.practicals.chris.prac8_spiritlevelapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mGravitySensor;

    TextView x;
    TextView y;
    TextView z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        assert mSensorManager != null;
        mGravitySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSensorManager.registerListener(this, mGravitySensor, 5000);

        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        float[] convertedValues = new float[3];

        String printingValues = values[0] + ", " + values[1] + ", " + values[2];

        for (int i = 0; i < values.length; i++) {
            convertedValues[i] = roundTwoDecimals(values[i]);
        }

        x.setText(String.valueOf(convertedValues[0]));
        y.setText(String.valueOf(convertedValues[1]));
        z.setText(String.valueOf(convertedValues[2]));
        Log.i("Spirit", printingValues);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    float roundTwoDecimals(float d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");

        return Float.valueOf(twoDForm.format(d));
    }
}
