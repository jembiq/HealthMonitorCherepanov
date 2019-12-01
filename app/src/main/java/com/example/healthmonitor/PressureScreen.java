package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class PressureScreen extends AppCompatActivity {

    private static final String TAG = "Pressure screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_screen);

        action();
    }

    public void action() {
        final Date date = new Date();
        final EditText sys = (EditText) findViewById(R.id.sysField);
        final EditText dia = (EditText) findViewById(R.id.diaField);
        final EditText pulse = (EditText) findViewById(R.id.pulseField);
        Button saveBtn = (Button) findViewById(R.id.savePressBtn);
        final Toast toast = Toast.makeText(this,
                getString(R.string.toast_error), Toast.LENGTH_SHORT);

        Log.i(TAG, getString(R.string.log_inf_init));

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.i(TAG, getString(R.string.log_try));

                    PressStorage.setDate(date.toString());
                    PressStorage.setSys(Integer.parseInt
                            (sys.getText().toString()));
                    PressStorage.setDia(Integer.parseInt
                            (dia.getText().toString()));
                    PressStorage.setPulse(Integer.parseInt
                            (pulse.getText().toString()));
                }
                catch (Exception e) {
                    Log.e(TAG, e.toString());
                    toast.show();
                }
            }
        });
    }
}
