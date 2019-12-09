package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VitalScreen extends AppCompatActivity {

    private static final String TAG = "Vitality screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_screen);

        action();
    }

    public void action() {
        final TextView time = (TextView) findViewById(R.id.measureTime);
        final TextView sysValue = (TextView) findViewById(R.id.sysField);
        final TextView diaValue = (TextView) findViewById(R.id.diaField);
        final TextView pulseValue = (TextView) findViewById(R.id.pulseField);
        Toast toast = Toast.makeText(this,
                getString(R.string.toast_error), Toast.LENGTH_SHORT);
        Button backToMenuBtn = findViewById(R.id.backToMenuBtnVital);

        Log.i(TAG, getString(R.string.log_inf_init));

        try {
            Log.i(TAG, getString(R.string.log_try));

            time.setText(PressStorage.getDate());
            sysValue.setText("" + PressStorage.getSys());
            diaValue.setText("" + PressStorage.getDia());
            pulseValue.setText("" + PressStorage.getPulse());

            backToMenuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        catch (Exception e) {
            Log.e(TAG, e.toString());
            toast.show();
        }
    }
}