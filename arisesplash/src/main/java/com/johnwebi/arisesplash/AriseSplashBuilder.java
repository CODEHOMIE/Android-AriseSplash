package com.johnwebi.arisesplash;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

public class AriseSplashBuilder {
    //Variables as objects
    private Activity activity;
    private Intent intent;
    static final String SPLASH_ICON_ID = "";
    static final String SPLASH_WORD_ICON_ID = "";
    static final String TEXT_FADE_IN_DURATION = "";
    public static final int SPLASH_SCREEN_FINISHED = 10001;

    private AriseSplashBuilder(Activity activity) {
        this.activity = activity;
        this.intent = new Intent(activity, Splashscreen.class);
    }

    public static AriseSplashBuilder getInstance(Activity activity) {
        return new AriseSplashBuilder(activity);
    }

    public AriseSplashBuilder setIconImage(@NonNull int res_id) {
        intent.putExtra(SPLASH_ICON_ID, res_id);
        return this;
    }

    public AriseSplashBuilder setWordImage(@NonNull int res_id) {
        intent.putExtra(SPLASH_WORD_ICON_ID, res_id);
        return this;
    }

    public AriseSplashBuilder setTextFadeInDuration(@NonNull int millis) {
        intent.putExtra(TEXT_FADE_IN_DURATION, millis);
        return this;
    }

    public void show() {
        if(!intent.hasExtra(AriseSplashBuilder.SPLASH_WORD_ICON_ID) || !intent.hasExtra(AriseSplashBuilder.SPLASH_ICON_ID)) throw new RuntimeException("You have to pass the wordIcon-id AND the image-id to open up the splash screen. Please use the methods setIconImage() and setWordImage().");
        activity.startActivityForResult(intent, SPLASH_SCREEN_FINISHED);
    }
}
