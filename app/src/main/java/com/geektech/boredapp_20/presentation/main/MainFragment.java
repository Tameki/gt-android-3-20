package com.geektech.boredapp_20.presentation.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.boredapp_20.App;
import com.geektech.boredapp_20.R;
import com.geektech.boredapp_20.data.remote.BoredApiClient;
import com.geektech.boredapp_20.model.BoredAction;

public class MainFragment extends Fragment {

    public MainFragment() { }

    public static Fragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fetchBoredAction(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchBoredAction(true);
    }

    private void fetchBoredAction(Boolean fromCache) {
        //TODO: Collect params
        //TODO: Show loading progress bar
        App.boredRepository.getAction(
                fromCache,
                "",
                null,
                new BoredApiClient.BoredActionCallback() {
                    @Override
                    public void onSuccess(BoredAction result) {
                        //TODO: Hide loading progress bar
                        renderAction(result);
                    }

                    @Override
                    public void onFailure(Exception exception) {
                        //TODO: Show error message
                    }
                });
    }

    private void renderAction(BoredAction boredAction) {
        Boolean isSaved = App.boredRepository
                .getBoredAction(boredAction.getKey()) != null;

        if (isSaved) {
            //TODO: Set filled
        } else {
            //TODO: Set empty
        }
    }
}