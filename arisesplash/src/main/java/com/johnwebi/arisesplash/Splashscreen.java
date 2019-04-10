package com.johnwebi.arisesplash;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splashscreen extends AppCompatActivity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor( this, R.color.white));

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }

    }

    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView splashImageIcon = (ImageView) findViewById(R.id.splash);
        ImageView splashWordImageIcon = (ImageView) findViewById(R.id.splash);
        // Initialize calling intent
        final Intent intent = getIntent();
        splashImageIcon.setImageResource(intent.getIntExtra(AriseSplashBuilder.SPLASH_ICON_ID, 0));
        splashImageIcon.clearAnimation();
        splashImageIcon.startAnimation(anim);

        splashTread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 600) {
                        sleep(intent.getIntExtra(AriseSplashBuilder.SPLASH_DURATION, 1000) );
                        waited += 100;
                    }
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splashscreen.this.finish();
                }

            }
        };

        splashTread.start();

    }

}
