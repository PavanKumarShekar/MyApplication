package com.kumar.pavan.myapplication.moo;

/**
 * Created by amrut on 3/18/2018.
 */

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;

import com.kumar.pavan.myapplication.R;

public class SpashScreenActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SpashScreenActivity.this, WelcomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}