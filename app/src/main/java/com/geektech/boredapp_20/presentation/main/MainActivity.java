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

        App.boredApiClient.getAction(null, null, new BoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction boredAction) {
                Log.d("ololo", boredAction.toString());
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("ololo", exception.getMessage());
            }
        });
    }
}