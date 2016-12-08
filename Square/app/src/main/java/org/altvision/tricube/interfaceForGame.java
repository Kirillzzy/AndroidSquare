package org.altvision.tricube;

import com.google.android.gms.ads.InterstitialAd;


interface mainInterface{
    
        //сделать кнопку нажимаемой или нет
         void set_enabled(int a, int b, boolean ... arg);

        // следующие 3 функии устанавилвают цвет кнопку
         void set_black(int a, int b);

         void set_white(int a,int b);

         void set_grey(int a,int b);

        //генерация случайных позиций для кнопок
         int[] generate(int what);

        //поменять две кнопки местами
         void swap(int a, int b);

        // b - это место с которого начинается цикл в последующих функций, т.к. могут быть открыты 3 кн
         int generate_b();

        //создаем наверху кнопки с цветом в рандомных местах
         void create();

        // меняем ряды местами
         void swap_row(int row);

        // выполняется во время слияния предпоследнего ряда и последнего
         void do_down();


         int get_score();

         int get_best();

        // создать внизу цветные кнопки в рандомных местах
         void create_base();

        // поменять цвет на противоположный в нижних кнопках
         void change_color(int column);

         void restart_timer();

         void newtask();

         void save_record(int newRecord);

         int load_record();

         void play_good_connect();

         void play_bad_connect();

         void play_begin_game();

         void play_end_game();

         InterstitialAd newInterstitialAd();

         void showInterstitial();

         void loadInterstitial();

         void setStyles();



         int isMusicOn();

         int isRoundOn();


         //void changeColors();

         int getComplexity();


}