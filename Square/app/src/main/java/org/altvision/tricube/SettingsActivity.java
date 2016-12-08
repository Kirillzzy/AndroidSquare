package org.altvision.tricube;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    private Switch soundSwitch;
    private Switch roundSwitch;
    private Button difficultButton;
    private Button okButton;
    private Button colorsButton;
    private MyPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        prefs = new MyPreferences();
        soundSwitch = (Switch) findViewById(R.id.soundSwitch);
        roundSwitch = (Switch) findViewById(R.id.roundSwitch);
        difficultButton = (Button) findViewById(R.id.difficultButton);
        //colorsButton = (Button) findViewById(R.id.colorsButton);
        okButton = (Button)findViewById(R.id.okButton);
        okButton.setTextColor(Color.WHITE);
        soundSwitch.setTextColor(Color.WHITE);
        roundSwitch.setTextColor(Color.WHITE);
        difficultButton.setTextColor(Color.WHITE);
        //colorsButton.setTextColor(Color.WHITE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");

        okButton.setBackgroundResource(R.drawable.button_blueactionbar_style);
        difficultButton.setBackgroundResource(R.drawable.button_blueactionbar_style);
        soundSwitch.setBackgroundResource(R.drawable.button_blueactionbar_style);
        roundSwitch.setBackgroundResource(R.drawable.button_blueactionbar_style);
        //colorsButton.setBackgroundResource(R.drawable.button_blueactionbar_style);

        if(loadSoundSwitch()==1) {
            soundSwitch.setChecked(true);
        }
        else if(loadSoundSwitch()==0) {
            soundSwitch.setChecked(false);
        }

        if(loadRoundSwitch()==1) {
            roundSwitch.setChecked(true);
        }
        else if(loadSoundSwitch()==0) {
            roundSwitch.setChecked(false);
        }


        if(isTablet()){
            soundSwitch.setTextSize(50);
            roundSwitch.setTextSize(50);
            difficultButton.setTextSize(50);
            okButton.setTextSize(50);
            //colorsButton.setTextSize(50);
        }else{
            soundSwitch.setTextSize(40);
            roundSwitch.setTextSize(40);
            difficultButton.setTextSize(40);
            okButton.setTextSize(40);
            //colorsButton.setTextSize(40);
        }


        okButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    saveSettings();
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        difficultButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    startActivity(new Intent(view.getContext(), Complexity.class));
                }
                return false;
            }
        });

        /*colorsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    startActivity(new Intent(view.getContext(), elementsActivity.class));
                }
                return false;
            }
        });*/

    }
    private void saveSettings() {
        if(soundSwitch.isChecked())
            prefs.save(this,"music",1);
        else
            prefs.save(this,"music",0);

        if(roundSwitch.isChecked())
            prefs.save(this,"round",1);
        else
            prefs.save(this,"round",0);
    }

    private int loadSoundSwitch(){
        return prefs.getValue(this,"music",1);
    }
    private int loadRoundSwitch() { return prefs.getValue(this,"round",0); }

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
