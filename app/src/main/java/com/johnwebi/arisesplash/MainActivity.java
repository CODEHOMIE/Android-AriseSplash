package com.johnwebi.arisesplash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AriseSplashBuilder.getInstance(this)
                .setImage(R.drawable.app_icon)
                .skipImage(true)
                .show();
    }
}
