package com.geektech.boredapp_20;

import android.app.Application;

import androidx.room.Room;

import com.geektech.boredapp_20.data.AppPreferences;
import com.geektech.boredapp_20.data.BoredRepository;
import com.geektech.boredapp_20.data.remote.BoredApiClient;
import com.geektech.boredapp_20.data.db.BoredDatabase;
import com.geektech.boredapp_20.data.local.BoredStorage;


public class App extends Application {

    private static BoredDatabase boredDatabase;

    public static AppPreferences appPreferences;

    public static BoredRepository boredRepository;

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

        appPreferences = new AppPreferences(this);

        BoredStorage boredStorage = new BoredStorage(boredDatabase.boredDao());
        BoredApiClient boredApiClient = new BoredApiClient();
        boredRepository = new BoredRepository(boredStorage, boredApiClient);
    }

}
