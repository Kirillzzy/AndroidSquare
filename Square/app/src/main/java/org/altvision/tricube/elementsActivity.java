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

public class elementsActivity extends AppCompatActivity {
    Button fon;
    Button stroke;
    Button falling;
    Button back;
    Button disable;
    Button save;
    MyPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Colors");
        fon = (Button) findViewById(R.id.fon);
        fon.setBackgroundResource(R.drawable.button_blueactionbar_style);
        fon.setTextColor(Color.WHITE);
        stroke = (Button) findViewById(R.id.stroke);
        stroke.setBackgroundResource(R.drawable.button_blueactionbar_style);
        stroke.setTextColor(Color.WHITE);
        falling = (Button) findViewById(R.id.falling);
        falling.setBackgroundResource(R.drawable.button_blueactionbar_style);
        falling.setTextColor(Color.WHITE);
        back = (Button) findViewById(R.id.back);
        back.setBackgroundResource(R.drawable.button_blueactionbar_style);
        back.setTextColor(Color.WHITE);
        disable = (Button) findViewById(R.id.disableColor);
        disable.setBackgroundResource(R.drawable.button_blueactionbar_style);
        disable.setTextColor(Color.WHITE);
        save = (Button) findViewById(R.id.saveColors);
        save.setBackgroundResource(R.drawable.button_blueactionbar_style);
        save.setTextColor(Color.WHITE);
        prefs = new MyPreferences();





        if (isTablet()) {
            fon.setTextSize(40);
            stroke.setTextSize(40);
            falling.setTextSize(40);
            back.setTextSize(40);
            disable.setTextSize(40);
            save.setTextSize(40);
        } else {
            fon.setTextSize(30);
            stroke.setTextSize(30);
            falling.setTextSize(30);
            back.setTextSize(30);
            disable.setTextSize(30);
            save.setTextSize(30);
        }


        fon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent intent = new Intent(view.getContext(), colorsActivity.class);
                    saveMode(1);
                    startActivity(intent);
                }
                return false;
            }
        });

        stroke.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent intent = new Intent(view.getContext(), colorsActivity.class);
                    saveMode(2);
                    startActivity(intent);
                }
                return false;
            }
        });

        falling.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent intent = new Intent(view.getContext(), colorsActivity.class);
                    saveMode(3);
                    startActivity(intent);
                }
                return false;
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent intent = new Intent(view.getContext(), colorsActivity.class);
                    saveMode(4);
                    startActivity(intent);
                }
                return false;
            }
        });

        disable.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent intent = new Intent(view.getContext(), colorsActivity.class);
                    saveMode(5);
                    startActivity(intent);
                }
                return false;
            }
        });

        save.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });
    }

    private void saveMode(int val){
        prefs.save(this,"mode",val);
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

