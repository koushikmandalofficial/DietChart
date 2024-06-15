package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.app.dietchartfinal.R;

public class SplashScreenActivity extends AppCompatActivity {
    //  TextView textview1;
    TextView textview2;
    private static int Splash_timout=5500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //textview1=findViewById(R.id.textview1);
        textview2=findViewById(R.id.textview2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sh = getSharedPreferences("DietCharSharedPref", MODE_PRIVATE);

                if(!sh.getBoolean("loginstate",false)) {

                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {

                    Intent intent2 = new Intent(SplashScreenActivity.this,HomeActivity.class);
                    startActivity(intent2);
                    finish();
                }
            }
        },Splash_timout);

        // Animation myanimation1 = AnimationUtils.loadAnimation(splashscreen.this,R.anim.animation2);
        //  textview1.startAnimation(myanimation1);

        Animation myanimation2 = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.animation1);
        textview2.startAnimation(myanimation2);
    }
}