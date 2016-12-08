package org.altvision.tricube;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.annotation.Dimension;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

import org.altvision.tricube.R;

public class MainActivity extends AppCompatActivity implements mainInterface{

    private LinearLayout mainLayout;//главный слой, на котором все
    private GridLayout services;//слой с кнопкой начать и счет  и рекордом
    private GridLayout layouts[];//слоя с кнопками
    private Button buttons[][];//собственно сами кнопки
    private Button begin;//кнопка начать новую игру
    private Button settings;
    private Button scoreLabel;// метка со счетом
    private Button bestLabel;// метка с рекором
    private Button MainMenu;
    private Space free;
    private Timer mainTimer;//счетчик для приостановки глваного потока
    private final int lenb = 7;// сколько рядов с кнопками
    private int flag = 0;//метка какой слой двигать
    private int downposition;// наша верхняя позиция в игре от куда начинает падать
    private String colors[];// цвета на верху
    private String colors_base[];// цвета внизу
    private int opening = 3;// сколько внизу открыто
    private int FPS;// время на какое останавливатется поток
    private boolean istimerworking = false;// метка работает ли счетчик
    private TimerTask task;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    private MyPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //обьявление
        prefs = new MyPreferences();
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        mainLayout = new LinearLayout(this);//(LinearLayout) findViewById(R.id.mainLayout);
        services = new GridLayout(this);
        layouts = new GridLayout[lenb];
        buttons = new Button[lenb][5];
        free = new Space(this);
        begin = new Button(this);
        settings = new Button(this);
        scoreLabel = new Button(this);
        bestLabel = new Button(this);
        MainMenu = new Button(this);
        colors = new String[5];
        colors_base = new String[5];
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        MobileAds.initialize(getApplicationContext(),"ca-app-pub-9693937253743635~9970070705");
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("@string/banner");
        mAdView.setId(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        services.setRowCount(1);
        services.setColumnCount(5);
        services.setOrientation(GridLayout.VERTICAL);

        services.addView(begin,
                display.getWidth()/5,
                display.getHeight()/9);
        services.addView(scoreLabel,
                display.getWidth()/5,
                display.getHeight()/9);
        services.addView(bestLabel,
                display.getWidth()/5,
                display.getHeight()/9);
        services.addView(settings,
                display.getWidth()/5,
                display.getHeight()/9);
        services.addView(MainMenu,
                display.getWidth()/5,
                display.getHeight()/9);


        //расположение services
        ((GridLayout.LayoutParams)bestLabel.getLayoutParams()).setGravity(Gravity.TOP);
        ((GridLayout.LayoutParams)begin.getLayoutParams()).setGravity(Gravity.TOP);
        ((GridLayout.LayoutParams)scoreLabel.getLayoutParams()).setGravity(Gravity.TOP);
        ((GridLayout.LayoutParams)MainMenu.getLayoutParams()).setGravity(Gravity.TOP);
        ((GridLayout.LayoutParams)settings.getLayoutParams()).setGravity(Gravity.TOP);

        setStyles();

        begin.setText("NEW\nGAME");
        begin.setTextColor(Color.WHITE);
        scoreLabel.setText("Score \n0");
        scoreLabel.setEnabled(false);
        scoreLabel.setTextColor(Color.WHITE);
        int rec = load_record();
        bestLabel.setText("Best \n"+rec);
        bestLabel.setEnabled(false);
        bestLabel.setTextColor(Color.WHITE);
        settings.setText("Setts");
        settings.setTextColor(Color.WHITE);
        MainMenu.setText("MENU");
        MainMenu.setTextColor(Color.WHITE);
        free.setMinimumHeight(25);


        if(isTablet()){
            begin.setTextSize(25);
            scoreLabel.setTextSize(25);
            bestLabel.setTextSize(25);
            settings.setTextSize(25);
            MainMenu.setTextSize(25);
        }else{
            begin.setTextSize(15);
            scoreLabel.setTextSize(15);
            bestLabel.setTextSize(15);
            settings.setTextSize(15);
            MainMenu.setTextSize(15);
        }

        //засовываем в слои кнопки и обявляем их
        for (int i = 0; i < lenb; i++) {
            layouts[i] = new GridLayout(this);
            layouts[i].setRowCount(1);
            layouts[i].setColumnCount(5);
            layouts[i].setOrientation(GridLayout.VERTICAL);
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Button(this);
                set_enabled(i,j,false);
                if(isRoundOn()==0) {
                    buttons[i][j].setBackgroundResource(R.drawable.button_white_style);
                }else{
                    buttons[i][j].setBackgroundResource(R.drawable.button_white_round);
                }
                layouts[i].addView(buttons[i][j],
                        display.getWidth()/(layouts[i].getColumnCount()),
                        display.getHeight()/(layouts[i].getColumnCount()+4));
            }
        }
        //работа с главным слоем
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(services);
        mainLayout.addView(free);
        for (int i = 0; i < lenb; i++) {
            mainLayout.addView(layouts[i]);
        }
        mainLayout.addView(mAdView);
        setContentView(mainLayout);

        // событие на кнопу begin
        begin.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    if(istimerworking) {
                        mainTimer.cancel();
                        istimerworking = false;
                    }
                    scoreLabel.setText("Score \n0");
                    int rec = load_record();
                    bestLabel.setText("Best \n"+rec);
                    if(getComplexity()==0){
                        FPS=400;
                    }else if(getComplexity()==1) {
                        FPS = 300;
                    }else{
                        FPS=250;
                    }
                    flag = 0;
                    opening = 3;
                    mainTimer = new Timer();
                    for (int i = 0; i < lenb; i++) {
                        for (int j = 0; j < 5; j++) {
                            set_white(i, j);
                        }
                    }
                    mInterstitialAd = newInterstitialAd();
                    loadInterstitial();
                    downposition = 0;
                    create_base();
                    create();
                    play_begin_game();
                    //до этого момента обьявляем и делаем все до начала игры
                    restart_timer();
                }
                return false;
            }
        });

        settings.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction()& MotionEvent.ACTION_MASK;
                if(MotionEvent.ACTION_DOWN==action){
                    startActivity(new Intent(view.getContext(),SettingsActivity.class));
                }
                return false;
            }
        });

        MainMenu.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction()& MotionEvent.ACTION_MASK;
                if(MotionEvent.ACTION_DOWN==action){
                    startActivity(new Intent(view.getContext(),Beggining.class));
                }
                return false;
            }
        });


        //события на нажатия кнопок в базе(внизу)
        buttons[lenb-1][0].setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    change_color(0);
                }
                return false;
            }
        });

        buttons[lenb-1][1].setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    change_color(1);
                }
                return false;
            }
        });

        buttons[lenb-1][2].setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    change_color(2);
                }
                return false;
            }
        });

        buttons[lenb-1][3].setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    change_color(3);
                }
                return false;
            }
        });

        buttons[lenb-1][4].setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                int action = event.getAction() & MotionEvent.ACTION_MASK;
                if (MotionEvent.ACTION_DOWN == action) {
                    change_color(4);
                }
                return false;
            }
        });
    };

    public void setStyles(){
        if(isRoundOn()==0) {
            begin.setBackgroundResource(R.drawable.button_red_style);
            scoreLabel.setBackgroundResource(R.drawable.button_blue_style);
            bestLabel.setBackgroundResource(R.drawable.button_blue_style);
            settings.setBackgroundResource(R.drawable.button_blue_style);
            MainMenu.setBackgroundResource(R.drawable.button_red_style);
        }else{
            begin.setBackgroundResource(R.drawable.button_red_round);
            scoreLabel.setBackgroundResource(R.drawable.button_blue_round);
            bestLabel.setBackgroundResource(R.drawable.button_blue_round);
            settings.setBackgroundResource(R.drawable.button_blue_round);
            MainMenu.setBackgroundResource(R.drawable.button_red_round);
        }
    }



    public void changeColors(){
        switch (loadColor1()){
            case 1:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.white));
                services.setBackgroundColor(getResources().getColor(R.color.white));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case 2:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.black));
                services.setBackgroundColor(getResources().getColor(R.color.black));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.black));
                }
                break;
            case 3:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.blueActionBar));
                services.setBackgroundColor(getResources().getColor(R.color.blueActionBar));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.blueActionBar));
                }
                break;
            case 4:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                services.setBackgroundColor(getResources().getColor(R.color.blue));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.blue));
                }
                break;
            case 5:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.red));
                services.setBackgroundColor(getResources().getColor(R.color.red));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.red));
                }
                break;
            case 6:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.orange));
                services.setBackgroundColor(getResources().getColor(R.color.orange));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.orange));
                }
                break;
            case 7:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.green));
                services.setBackgroundColor(getResources().getColor(R.color.green));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.green));
                }
                break;
            case 8:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                services.setBackgroundColor(getResources().getColor(R.color.yellow));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                break;
            case 9:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.purple));
                services.setBackgroundColor(getResources().getColor(R.color.purple));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.purple));
                }
                break;
            case 10:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.pink));
                services.setBackgroundColor(getResources().getColor(R.color.pink));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.pink));
                }
                break;
            case 11:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.grey));
                services.setBackgroundColor(getResources().getColor(R.color.grey));
                for(int i=0;i<lenb;i++){
                    layouts[i].setBackgroundColor(getResources().getColor(R.color.grey));
                }
                break;
        }
    }
    //сделать кнопку нажимаемой или нет
    public void set_enabled(int a, int b, boolean ... arg){
        boolean realy = false;
        if(arg.length==0){
            realy=true;
        }
        else{
            if(arg[0]== false)
                realy=false;
            else
                realy=true;
        }
        buttons[a][b].setEnabled(realy);
    }

    // следующие 3 функии устанавилвают цвет кнопку
    public void set_black(int a, int b){
        if(isRoundOn()==0) {
            buttons[a][b].setBackgroundResource(R.drawable.button_black_style);
        }else{
            buttons[a][b].setBackgroundResource(R.drawable.button_black_round);
        }
    }

    public void set_white(int a,int b){
        if(isRoundOn()==0) {
            buttons[a][b].setBackgroundResource(R.drawable.button_white_style);
        }else{
            buttons[a][b].setBackgroundResource(R.drawable.button_white_round);
        }
    }

    public void set_grey(int a,int b){
        if(isRoundOn()==0) {
            buttons[a][b].setBackgroundResource(R.drawable.button_grey_style);
        }else{
            buttons[a][b].setBackgroundResource(R.drawable.button_grey_round);
        }
    }

    //генерация случайных позиций для кнопок
    public int[] generate(int what){
        Random random = new Random();
        int how = random.nextInt(what);
        if(how==0)
            how=1;
        if(how>=4)
            how=3;
        int a[] = new int[how+1];
        for(int i=0;i<=how;i++){
            a[i]=(random.nextInt(what));
        }
        return a;
    }

    //поменять две кнопки местами
    public void swap(int a, int b){
        if(colors[b]=="white")
            set_white(a+1,b);
        else if(colors[b]=="black")
            set_black(a+1,b);
        set_white(a,b);
    }

    // b - это место с которого начинается цикл в последующих функций, т.к. могут быть открыты 3 кн
    public int generate_b(){
        int b=0;
        if(opening==3||opening==4){
            b=1;
        }
        return b;
    }

    //создаем наверху кнопки с цветом в рандомных местах
    public void create(){
        if(get_score()>=10&&opening==3){
            opening++;
            set_enabled(lenb-1,4);
            set_white(lenb-1,4);
            colors_base[4]="white";
        }else if(get_score()>=30&&opening==4){
            opening++;
            set_enabled(lenb-1,0);
            set_white(lenb-1,0);
            colors_base[0]="white";
        }
        int n[] = generate(opening);
        int b = generate_b();
        for(int i=b;i<b+opening;i++){
            set_white(downposition,i);
            colors[i]="white";
            set_white(lenb-1,i);
            colors_base[i]="white";
        }
        for(int i=0;i<n.length;i++){
            set_black(downposition,n[i]+b);
            colors[n[i]+b]="black";
        }
        for(int i=0;i<5;i++){
            if(i<b||i>=b+opening)
                colors[i]="white";
        }
        flag=downposition;
    }

    // меняем ряды местами
    public void swap_row(int row){
        for(int i=0;i<5;i++){
            swap(row,i);
        }
    }

    // выполняется во время слияния предпоследнего ряда и последнего
    public void do_down(){
        int b=generate_b();
        for(int i=b;i<b+opening;i++){
            if(colors[i]!=colors_base[i]){
                play_bad_connect();
                for(int j=0;j<5;j++){
                    set_grey(downposition,j);
                }
                for(int j=0;j<5;j++){
                    set_white(lenb-2,j);
                }
                downposition++;
                if(getComplexity()==0) {
                    FPS+=60;
                }else if(getComplexity()==1){
                    FPS+=40;
                }
                return;
            }
        }
        play_good_connect();
        for(int i=0;i<5;i++){
            set_white(lenb-2,i);
        }
        if(getComplexity()==0) {
            if (FPS > 200) {
                FPS -= 10;
            }
        }else if(getComplexity()==1){
            if(FPS>170){
                FPS-=10;
            }
        }else if(getComplexity()==2){
            if(FPS>130) {
                FPS -= 20;
            }
        }
        scoreLabel.setText("Score \n"+(get_score()+3));
        if(get_score()>get_best()){
            bestLabel.setText("Best \n"+get_score());
            save_record(get_score());
        }
    }


    public int get_score(){
        String score = String.valueOf(scoreLabel.getText());
        score=score.substring(7,score.length());
        return Integer.parseInt(score);
    }

    public int get_best(){
        String best = String.valueOf(bestLabel.getText());
        best = best.substring(6,best.length());
        return Integer.parseInt(best);
    }

    // создать внизу цветные кнопки в рандомных местах
    public void create_base(){
        for(int i=0;i<lenb-1;i++){
            for(int j=0;j<5;j++){
                set_enabled(i,j,false);
            }
        }
        for(int i=0;i<5;i++){
            set_enabled(lenb-1,i);
        }

        set_grey(lenb-1,0);
        set_enabled(lenb-1,0,false);
        colors_base[0]="grey";

        set_grey(lenb-1,4);
        set_enabled(lenb-1,4,false);
        colors_base[4]="grey";

        for(int i=1;i<4;i++){
            set_white(lenb-1,i);
            colors_base[i]="white";
            set_enabled(lenb-1,i);
        }

    }

    // поменять цвет на противоположный в нижних кнопках
    public void change_color(int column){
        if(colors_base[column]=="white"){
            set_black(lenb-1,column);
            colors_base[column]="black";
        }else if(colors_base[column]=="black"){
            set_white(lenb-1,column);
            colors_base[column]="white";
        }
    }

    public void restart_timer(){

        if(istimerworking) {
            mainTimer.cancel();
            istimerworking = false;
        }
        mainTimer = new Timer("alertTimer",true);
        newtask();
        //работа с потоком каждые FPS
        istimerworking=true;
        mainTimer.schedule(task,FPS,FPS);
    }


    public void newtask(){
        task  = new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        istimerworking = true;
                        if (downposition == lenb - 2) {
                            mainTimer.cancel();
                            istimerworking = false;
                            if (get_score() > get_best()) {
                                bestLabel.setText("Best \n" + (get_score()));
                                save_record(get_score());
                            }
                            play_end_game();
                            for(int i=0;i<5;i++){
                                set_enabled(lenb-1,i,false);
                            }
                            Toast.makeText(getApplicationContext(),"You loose, your score is "+get_score(),Toast.LENGTH_SHORT).show();
                            Random random = new Random();
                            if(random.nextInt(2)==1) {
                                showInterstitial();
                            }
                            return;
                        }
                        if (flag == lenb - 2) {
                            do_down();
                            create();
                        } else {
                            swap_row(flag);
                            flag++;
                        }
                        restart_timer();
                    }
                });
            }
        };
    }

    public void save_record(int newRecord){
        if(getComplexity()==0) {
            prefs.save(this, "record0", newRecord);
        }else if(getComplexity()==1){
            prefs.save(this, "record1", newRecord);
        }else if(getComplexity()==2){
            prefs.save(this, "record2", newRecord);
        }
    }

    public int load_record(){
        int record=0;
        if(getComplexity()==0) {
            record = prefs.getValue(this, "record0", 0);
        }else if(getComplexity()==1){
            record = prefs.getValue(this, "record1", 0);
        }else if(getComplexity()==2){
            record = prefs.getValue(this, "record2", 0);
        }
        return record;
    }

    public void play_good_connect(){
        if(isMusicOn()==1) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.good_connect);
            mp.start();
        }
    }

    public void play_bad_connect(){
        if(isMusicOn()==1) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.bad_connect);
            mp.start();
        }
    }

    public void play_begin_game(){
        if(isMusicOn()==1) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.begin_game);
            mp.start();
        }
    }

    public void play_end_game(){
        if(isMusicOn()==1) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.end_game);
            mp.start();
        }
    }

    public InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {}

            @Override
            public void onAdFailedToLoad(int errorCode) {}

            @Override
            public void onAdClosed() {}
        });
        return interstitialAd;
    }

    public void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void loadInterstitial() {
        // Disable the next level button and load the ad.
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        setStyles();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public boolean isTablet(){
        TelephonyManager manager = (TelephonyManager) getApplicationContext().
                getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        if(manager.getPhoneType()==TelephonyManager.PHONE_TYPE_NONE){
            return true;
        }else{
            return false;
        }
    }

    public int isMusicOn(){
        return prefs.getValue(this,"music",1);
    }

    public int getComplexity(){
        return prefs.getValue(this,"complexity",1);
    }

    public int isRoundOn() {
        return prefs.getValue(this,"round",0);
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




}


