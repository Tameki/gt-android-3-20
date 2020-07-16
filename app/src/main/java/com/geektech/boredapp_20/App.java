package com.geektech.boredapp_20;

import android.app.Application;

import androidx.room.Room;

import com.geektech.boredapp_20.data.AppPreferences;
import com.geektech.boredapp_20.data.remote.BoredApiClient;
import com.geektech.boredapp_20.data.db.BoredDatabase;
import com.geektech.boredapp_20.data.local.BoredStorage;

public class App extends Application {

    private static BoredDatabase boredDatabase;

    public static AppPreferences appPreferences;
    public static BoredApiClient boredApiClient;
    public static BoredStorage boredStorage;

    @Override
    public void onCreate() {
        super.onCreate();

        boredDatabase = Room.databaseBuilder(
                this,
                BoredDatabase.class,
                "bored.db"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        boredStorage = new BoredStorage(boredDatabase.boredDao());

        appPreferences = new AppPreferences(this);
        boredApiClient = new BoredApiClient();
    }

}
