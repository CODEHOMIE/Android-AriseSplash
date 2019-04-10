# Android-AriseSplash
Android library for getting a amazing animated SlashScreen into your Android app.



![20190410_210122](https://user-images.githubusercontent.com/48721096/55905578-f4d35700-5bda-11e9-933c-7d54f18ed19b.gif)





# Installation
Up to now, the library is only available in JitPack. Please add this code to your build.gradle file on project level:

```java
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

To load the library into your project use this code in the build.gradle file within the app module:

    implementation 'com.github.johnwebi:Android-AriseSplash:v1.0'

# Usage
To use the SplashScreen, paste this code to the beginning of the onCreate method of the launcher activity of your app. For better performance, we recommend to do this before setContentView().

 ```java
AriseSplashBuilder.getInstance(this)
                .setIconImage(R.drawable.logo)
                .setWordImage(R.drawable.word_logo)
                .setSplashDurationTime(1000)
                .show();
```

You can customize the appearance of the SplashScreen using following arguments when building the Activity with AriseSplashBuilder:

Method | Description
------------ | -------------
setIconImage(int res_id) | Sets the image of the SplashScreen that moves from down to the middle. You have to pass this argument, otherwise the app will get an error.
setWordImage(int res_id) | Sets the word image of that will appear in the middle below the icon image animation.
setSplashDurationTime(int millis) | You can call this method to set the duration of the splashscreen to sleep.

Thank you for using the SplashScreen!

© 2019-2020 (Designed and developed by John Webi)

# By me coffee:
    Twitter: https://twitter.com/johnswebi
    Email: johnwebi@icloud.com
    Phone: +254796190644
    
    
Happy coding :smiley: :sunglasses:
