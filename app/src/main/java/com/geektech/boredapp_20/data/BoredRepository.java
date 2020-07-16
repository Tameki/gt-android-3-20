package com.geektech.boredapp_20.data;

import com.geektech.boredapp_20.data.local.IBoredStorage;
import com.geektech.boredapp_20.data.remote.BoredApiClient;
import com.geektech.boredapp_20.model.BoredAction;

import java.util.List;

public class BoredRepository {
    public BoredAction lastAction = null;

    private IBoredStorage boredStorage;
    private BoredApiClient boredApiClient;

    public BoredRepository(
        IBoredStorage boredStorage,
        BoredApiClient boredApiClient
    ) {
        this.boredStorage = boredStorage;
        this.boredApiClient = boredApiClient;
    }

    public void saveBoredAction(BoredAction boredAction) {
        boredStorage.saveBoredAction(boredAction);
    }

    public BoredAction getBoredAction(String key) {
        return boredStorage.getBoredAction(key);
    }

    public List<BoredAction> getAllActions() {
        return boredStorage.getAllActions();
    }

    public void deleteBoredAction(BoredAction boredAction) {
        boredStorage.deleteBoredAction(boredAction);
    }

    public void getAction(
            String type,
            Float minPrice,
            BoredApiClient.BoredActionCallback callback
    ) {
        boredApiClient.getAction(type, minPrice, new BoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction result) {
                lastAction = result;
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception exception) {
                callback.onFailure(exception);
            }
        });
    }
}
