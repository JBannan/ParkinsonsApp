package com.blogspot.technopike.parkinsonsapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity {

    private float xOffset, yOffset, zOffset;//Used for calibration
    float xData, yData, zData;// values recorded by the sensor
    private SensorManager sensorManager;
    Sensor accelerometer;

    TextView xValue, yValue, zValue;
    Button calibrateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calibrateButton = findViewById(R.id.calibrate_btn);
        calibrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Accelerometer
        xValue = findViewById(R.id.accelX);
        yValue = findViewById(R.id.accelY);
        zValue = findViewById(R.id.accelZ);

        //Set all Text = 0
        xValue.setText("xValue: 0");
        yValue.setText("yValue: 0");
        zValue.setText("zValue: 0");
        Log.i("AccelerometerActivity", "Set X,Y,Z to Zero");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Accelerometer Sensor
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener accelerometerListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                xValue.setText("xValue: " + sensorEvent.values[0]);
                yValue.setText("yValue: " + sensorEvent.values[1]);
                zValue.setText("zValue: " + sensorEvent.values[2]);
                xData = sensorEvent.values[0];
                yData = sensorEvent.values[0];
                zData = sensorEvent.values[0];
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.i("AccelerometerActivity", "onCreate: Registered Accelerometer Listener ------------------------------------------");
    }

    void Calibrate () throws InterruptedException {
        wait(3000);// waits for 3 seconds before getting offsets

    }
}
/*
    TODO:
        - Finish Calibrate Function
        - Implement Function in button press
        - Use Offsets in Text Displays
 */