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

public class colorsActivity extends AppCompatActivity {

    Button white;
    Button black;
    Button blueLight;
    Button blue;
    Button orange;
    Button red;
    Button green;
    Button yellow;
    Button purple;
    Button pink;
    Button grey;
    MyPreferences prefs;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Colors");

        white = (Button) findViewById(R.id.white_color);
        white.setBackgroundResource(R.drawable.button_blueactionbar_style);
        white.setTextColor(Color.WHITE);
        black = (Button) findViewById(R.id.black_color);
        black.setBackgroundResource(R.drawable.button_blueactionbar_style);
        black.setTextColor(Color.WHITE);
        blueLight = (Button) findViewById(R.id.blueLight_color);
        blueLight.setBackgroundResource(R.drawable.button_blueactionbar_style);
        blueLight.setTextColor(Color.WHITE);
        blue = (Button) findViewById(R.id.blue_color);
        blue.setBackgroundResource(R.drawable.button_blueactionbar_style);
        blue.setTextColor(Color.WHITE);
        orange = (Button) findViewById(R.id.orange_color);
        orange.setBackgroundResource(R.drawable.button_blueactionbar_style);
        orange.setTextColor(Color.WHITE);
        red = (Button) findViewById(R.id.red_color);
        red.setBackgroundResource(R.drawable.button_blueactionbar_style);
        red.setTextColor(Color.WHITE);
        green = (Button) findViewById(R.id.green_color);
        green.setBackgroundResource(R.drawable.button_blueactionbar_style);
        green.setTextColor(Color.WHITE);
        purple = (Button) findViewById(R.id.purple_color);
        purple.setBackgroundResource(R.drawable.button_blueactionbar_style);
        purple.setTextColor(Color.WHITE);
        yellow = (Button) findViewById(R.id.yellow_color);
        yellow.setBackgroundResource(R.drawable.button_blueactionbar_style);
        yellow.setTextColor(Color.WHITE);
        pink = (Button) findViewById(R.id.pink_color);
        pink.setBackgroundResource(R.drawable.button_blueactionbar_style);
        pink.setTextColor(Color.WHITE);
        grey = (Button) findViewById(R.id.grey_color);
        grey.setBackgroundResource(R.drawable.button_blueactionbar_style);
        grey.setTextColor(Color.WHITE);

        changeNames();
        prefs = new MyPreferences();
        switch (loadMode()){// загружаем, на какую кнопку мы нажали, чтобы прийти на эту активность
            case 1://если мы нажали на первую кнопку
                switch(loadColor1()){//показываем какая кнопка выбранна на данный момент
                    case 1:
                        white.setText(white.getText()+"    ✓");
                        break;
                    case 2:
                        black.setText(black.getText()+"    ✓");
                        break;
                    case 3:
                        blueLight.setText(blueLight.getText()+"    ✓");
                        break;
                    case 4:
                        blue.setText(blue.getText()+"    ✓");
                        break;
                    case 5:
                        red.setText(red.getText()+"    ✓");
                        break;
                    case 6:
                        orange.setText(orange.getText()+"    ✓");
                        break;
                    case 7:
                        green.setText(green.getText()+"    ✓");
                        break;
                    case 8:
                        yellow.setText(yellow.getText()+"    ✓");
                        break;
                    case 9:
                        purple.setText(purple.getText()+"    ✓");
                        break;
                    case 10:
                        pink.setText(pink.getText()+"    ✓");
                        break;
                    case 11:
                        grey.setText(grey.getText()+"    ✓");
                        break;

                }
                break;

            case 2:
                switch(loadColor2()){//показываем какая кнопка выбранна на данный момент
                    case 1:
                        white.setText(white.getText()+"    ✓");
                        break;
                    case 2:
                        black.setText(black.getText()+"    ✓");
                        break;
                    case 3:
                        blueLight.setText(blueLight.getText()+"    ✓");
                        break;
                    case 4:
                        blue.setText(blue.getText()+"    ✓");
                        break;
                    case 5:
                        red.setText(red.getText()+"    ✓");
                        break;
                    case 6:
                        orange.setText(orange.getText()+"    ✓");
                        break;
                    case 7:
                        green.setText(green.getText()+"    ✓");
                        break;
                    case 8:
                        yellow.setText(yellow.getText()+"    ✓");
                        break;
                    case 9:
                        purple.setText(purple.getText()+"    ✓");
                        break;
                    case 10:
                        pink.setText(pink.getText()+"    ✓");
                        break;
                    case 11:
                        grey.setText(grey.getText()+"    ✓");
                        break;

                }
                break;

            case 3:
                switch(loadColor3()){//показываем какая кнопка выбранна на данный момент
                    case 1:
                        white.setText(white.getText()+"    ✓");
                        break;
                    case 2:
                        black.setText(black.getText()+"    ✓");
                        break;
                    case 3:
                        blueLight.setText(blueLight.getText()+"    ✓");
                        break;
                    case 4:
                        blue.setText(blue.getText()+"    ✓");
                        break;
                    case 5:
                        red.setText(red.getText()+"    ✓");
                        break;
                    case 6:
                        orange.setText(orange.getText()+"    ✓");
                        break;
                    case 7:
                        green.setText(green.getText()+"    ✓");
                        break;
                    case 8:
                        yellow.setText(yellow.getText()+"    ✓");
                        break;
                    case 9:
                        purple.setText(purple.getText()+"    ✓");
                        break;
                    case 10:
                        pink.setText(pink.getText()+"    ✓");
                        break;
                    case 11:
                        grey.setText(grey.getText()+"    ✓");
                        break;

                }
                break;

            case 4:
                switch(loadColor4()){//показываем какая кнопка выбранна на данный момент
                    case 1:
                        white.setText(white.getText()+"    ✓");
                        break;
                    case 2:
                        black.setText(black.getText()+"    ✓");
                        break;
                    case 3:
                        blueLight.setText(blueLight.getText()+"    ✓");
                        break;
                    case 4:
                        blue.setText(blue.getText()+"    ✓");
                        break;
                    case 5:
                        red.setText(red.getText()+"    ✓");
                        break;
                    case 6:
                        orange.setText(orange.getText()+"    ✓");
                        break;
                    case 7:
                        green.setText(green.getText()+"    ✓");
                        break;
                    case 8:
                        yellow.setText(yellow.getText()+"    ✓");
                        break;
                    case 9:
                        purple.setText(purple.getText()+"    ✓");
                        break;
                    case 10:
                        pink.setText(pink.getText()+"    ✓");
                        break;
                    case 11:
                        grey.setText(grey.getText()+"    ✓");
                        break;

                }
                break;

            case 5:
                switch(loadColor5()){//показываем какая кнопка выбранна на данный момент
                    case 1:
                        white.setText(white.getText()+"    ✓");
                        break;
                    case 2:
                        black.setText(black.getText()+"    ✓");
                        break;
                    case 3:
                        blueLight.setText(blueLight.getText()+"    ✓");
                        break;
                    case 4:
                        blue.setText(blue.getText()+"    ✓");
                        break;
                    case 5:
                        red.setText(red.getText()+"    ✓");
                        break;
                    case 6:
                        orange.setText(orange.getText()+"    ✓");
                        break;
                    case 7:
                        green.setText(green.getText()+"    ✓");
                        break;
                    case 8:
                        yellow.setText(yellow.getText()+"    ✓");
                        break;
                    case 9:
                        purple.setText(purple.getText()+"    ✓");
                        break;
                    case 10:
                        pink.setText(pink.getText()+"    ✓");
                        break;
                    case 11:
                        grey.setText(grey.getText()+"    ✓");
                        break;

                }
                break;
        }

        if(isTablet()){
            white.setTextSize(25);
            black.setTextSize(25);
            blueLight.setTextSize(25);
            blue.setTextSize(25);
            orange.setTextSize(25);
            red.setTextSize(25);
            green.setTextSize(25);
            purple.setTextSize(25);
            yellow.setTextSize(25);
            pink.setTextSize(25);
            grey.setTextSize(25);
        }else{
            white.setTextSize(15);
            black.setTextSize(15);
            blueLight.setTextSize(15);
            blue.setTextSize(15);
            orange.setTextSize(15);
            red.setTextSize(15);
            green.setTextSize(15);
            purple.setTextSize(15);
            yellow.setTextSize(15);
            pink.setTextSize(15);
            grey.setTextSize(15);
        }



        white.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(1);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        black.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(2);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });
        blueLight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(3);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        blue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(4);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        orange.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(5);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        red.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(6);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        green.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(7);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        purple.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(8);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        yellow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(9);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        pink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(10);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        grey.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    save(11);
                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

    }


    private int loadMode(){
        return prefs.getValue(this,"mode",0);
    }

    private int loadColor1(){
        return prefs.getValue(this,"color1",1);
    }

    private int loadColor2(){
        return prefs.getValue(this,"color2",2);
    }

    private int loadColor3(){
        return prefs.getValue(this,"color3",2);
    }

    private int loadColor4(){
        return prefs.getValue(this,"color4",1);
    }

    private int loadColor5(){
        return prefs.getValue(this,"color5",11);
    }

    private void saveColor1(int val){
        prefs.save(this,"color1",val);
    }

    private void saveColor2(int val){
        prefs.save(this,"color2",val);
    }

    private void saveColor3(int val){
        prefs.save(this,"color3",val);
    }

    private void saveColor4(int val){
        prefs.save(this,"color4",val);
    }

    private void saveColor5(int val){
        prefs.save(this,"color5",val);
    }

    private void save(int val){
        int kind = loadMode();
        switch (kind){
            case 1:
                saveColor1(val);
                break;
            case 2:
                saveColor2(val);
                break;
            case 3:
                saveColor3(val);
                break;
            case 4:
                saveColor4(val);
                break;
            case 5:
                saveColor5(val);
                break;
        }
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


    private void changeNames(){
        white.setText("White");
        black.setText("Black");
        grey.setText("Grey");
        blueLight.setText("Blue Light");
        blue.setText("Blue");
        orange.setText("Orange");
        red.setText("Red");
        green.setText("Green");
        purple.setText("Purple");
        yellow.setText("Yellow");
        pink.setText("Pink");
    }
}


