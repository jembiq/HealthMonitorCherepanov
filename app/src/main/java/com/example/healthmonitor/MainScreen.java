package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    private static final String TAG = "Main screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        action();
    }

    public void action() {

        final EditText usrNameField = (EditText) findViewById(R.id.usrNameField);
        final EditText usrAgeField = (EditText) findViewById(R.id.usrAgeField);
        final ConstraintLayout mainLay = (ConstraintLayout) findViewById(R.id.mainLay);
        final LinearLayout formPane = (LinearLayout) findViewById(R.id.formPane);
        final LinearLayout btnPane = (LinearLayout) findViewById(R.id.menuPane);
        Button saveBtn = (Button) findViewById(R.id.saveNameBtn);
        Button vitalBtn = (Button) findViewById(R.id.vitalBtn);
        Button pressBtn = (Button) findViewById(R.id.pressBtn);
        Button formBtn = (Button) findViewById(R.id.formBtn);

        Log.i(TAG, getString(R.string.log_inf_init));

        final Toast toast = Toast.makeText(this,
                getString(R.string.toast_error), Toast.LENGTH_SHORT);

        final Intent pressIntent = new Intent(this, PressureScreen.class);
        final Intent vitalIntent = new Intent(this, VitalScreen.class);

        formBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formPane.setVisibility(View.VISIBLE);
                btnPane.setVisibility(View.GONE);

                Log.i(TAG, getString(R.string.log_visibility_status));
            }
        });

        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pressIntent);

                Log.i(TAG, getString(R.string.log_press_intent_change));
            }
        });

        vitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(vitalIntent);

                Log.i(TAG, getString(R.string.log_vital_intent_change));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.i(TAG, getString(R.string.log_try));

                    UserAccStorage.setFullName(usrNameField.getText().toString());
                    UserAccStorage.setAge(Integer.parseInt
                            (usrAgeField.getText().toString()));

                    welcomeToast();
                }
                catch (Exception e) {
                    Log.e(TAG, e.toString());
                    toast.show();
                }
            }
        });

        mainLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formPane.setVisibility(View.GONE);
                btnPane.setVisibility(View.VISIBLE);

                Log.i(TAG, getString(R.string.log_visibility_status));
            }
        });
    }

    public void welcomeToast() {
        final Toast welcomeToast = Toast.makeText(this,
                getString(R.string.welcome_toast, UserAccStorage.getFullName(),
                        UserAccStorage.getAge()), Toast.LENGTH_SHORT);

        welcomeToast.show();
    }
}