package org.altvision.tricube;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Beggining extends AppCompatActivity {

    Button classicGame;
    Button settingsButton;
    Button arcadeGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beggining);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TriCube");

        classicGame = (Button) findViewById(R.id.classic);
        classicGame.setBackgroundResource(R.drawable.button_blueactionbar_style);
        classicGame.setTextColor(Color.WHITE);
        settingsButton = (Button) findViewById(R.id.gotoSettings);
        settingsButton.setBackgroundResource(R.drawable.button_blueactionbar_style);
        settingsButton.setTextColor(Color.WHITE);
        arcadeGame = (Button) findViewById(R.id.round);
        arcadeGame.setBackgroundResource(R.drawable.button_blueactionbar_style);
        arcadeGame.setTextColor(Color.WHITE);

        if(isTablet()){
            classicGame.setTextSize(50);
            settingsButton.setTextSize(50);
            arcadeGame.setTextSize(50);
        }else{
            classicGame.setTextSize(40);
            settingsButton.setTextSize(40);
            arcadeGame.setTextSize(40);
        }

        classicGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    startActivity(new Intent(view.getContext(), MainActivity.class));
                }
                return false;
            }
        });

        arcadeGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    startActivity(new Intent(view.getContext(), RoundMode.class));
                }
                return false;
            }
        });

        settingsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    startActivity(new Intent(view.getContext(), SettingsActivity.class));
                }
                return false;
            }
        });

    }

    private boolean isTablet(){
        TelephonyManager manager = (TelephonyManager) getApplicationContext().
                getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        if(manager.getPhoneType()==TelephonyManager.PHONE_TYPE_NONE){
            return true;
        }else{
            return false;
        }
    }

}
