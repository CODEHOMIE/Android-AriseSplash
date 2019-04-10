package com.johnwebi.arisesplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AriseSplashBuilder.getInstance(this)
                .setIconImage(R.drawable.logo)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AriseSplashBuilder.SPLASH_SCREEN_FINISHED) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this, "SplashScreen finished", Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "SplashScreen finished, but canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
