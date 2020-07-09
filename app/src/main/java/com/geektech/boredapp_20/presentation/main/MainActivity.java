package com.geektech.boredapp_20.presentation.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.geektech.boredapp_20.App;
import com.geektech.boredapp_20.R;
import com.geektech.boredapp_20.data.BoredApiClient;
import com.geektech.boredapp_20.model.BoredAction;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoredAction boredAction = App.boredStorage.getBoredAction("6098037");
        Log.d("ololo", "Stored " + boredAction);

        App.boredApiClient.getAction(null, null, new BoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction boredAction) {
                App.boredStorage.saveBoredAction(boredAction);

                Log.d("ololo", "Receive " + boredAction.toString());

                for (BoredAction action : App.boredStorage.getAllActions()) {
                    Log.d("ololo", action.toString());
                }
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("ololo", exception.getMessage());
            }
        });
    }
}