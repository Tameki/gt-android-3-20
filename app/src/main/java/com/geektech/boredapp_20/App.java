package com.geektech.boredapp_20;

import android.app.Application;

import com.geektech.boredapp_20.data.AppPreferences;

public class App extends Application {

    public static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        appPreferences = new AppPreferences(this);
    }

}
