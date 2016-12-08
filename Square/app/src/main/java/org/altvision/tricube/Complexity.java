package org.altvision.tricube;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class Complexity extends AppCompatActivity {
    Button begginer;
    Button player;
    Button pro;
    MyPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Complexity settings");
        prefs = new MyPreferences();
        begginer = (Button) findViewById(R.id.begginerButton);
        begginer.setTextColor(Color.WHITE);
        player = (Button) findViewById(R.id.playerButton);
        player.setTextColor(Color.WHITE);
        pro = (Button) findViewById(R.id.proButton);
        pro.setTextColor(Color.WHITE);

        begginer.setBackgroundResource(R.drawable.button_blueactionbar_style);
        player.setBackgroundResource(R.drawable.button_blueactionbar_style);
        pro.setBackgroundResource(R.drawable.button_blueactionbar_style);

        int kind = loadComlexity();
        if(kind==0){
            begginer.setText(begginer.getText()+"    ✓");
        }else if(kind==1){
            player.setText(player.getText()+"    ✓");
        }else if(kind==2){
            pro.setText(pro.getText()+"    ✓");
        }

        if(isTablet()){

            begginer.setTextSize(50);
            player.setTextSize(50);
            pro.setTextSize(50);
        }else{
            begginer.setTextSize(40);
            player.setTextSize(40);
            pro.setTextSize(40);
        }

        begginer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    //begginer.setText(begginer.getText() + "    ✓");
                    //defeat("begginer");
                    saveComplexity(0);

                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        player.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    //player.setText(player.getText() + "    ✓");
                    //defeat("player");
                    saveComplexity(1);

                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });

        pro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    //pro.setText(pro.getText() + "    ✓");
                    //defeat("pro");
                    saveComplexity(2);

                    Intent activityCalled = new Intent();
                    setResult(RESULT_OK, activityCalled);
                    finish();
                }
                return false;
            }
        });
    }

    private void defeat(String kind){
        if(kind=="begginer"){
            player.setText("Player");
            pro.setText("Pro");
        }else if(kind=="player"){
            begginer.setText("Begginer");
            pro.setText("Pro");
        }else{
            begginer.setText("Begginer");
            player.setText("Player");
        }
    }

    private int loadComlexity(){
        return prefs.getValue(this,"complexity",1);
    }

    private void saveComplexity(int kind){
        prefs.save(this,"complexity",kind);
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
