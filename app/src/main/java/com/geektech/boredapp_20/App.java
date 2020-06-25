package com.geektech.boredapp_20;

import android.app.Application;

import com.geektech.boredapp_20.data.AppPreferences;
import com.geektech.boredapp_20.data.BoredApiClient;

public class App extends Application {

    public static AppPreferences appPreferences;
    public static BoredApiClient boredApiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        appPreferences = new AppPreferences(this);
        boredApiClient = new BoredApiClient();
    }

}
