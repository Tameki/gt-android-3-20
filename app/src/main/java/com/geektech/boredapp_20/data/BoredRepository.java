package com.geektech.boredapp_20.data;

import androidx.annotation.Nullable;

import com.geektech.boredapp_20.data.local.IBoredStorage;
import com.geektech.boredapp_20.data.remote.BoredApiClient;
import com.geektech.boredapp_20.model.BoredAction;

import java.util.List;
import java.util.Objects;

public class BoredRepository {
    @Nullable
    private BoredAction mLastAction = null;

    private IBoredStorage boredStorage;
    private BoredApiClient boredApiClient;

    public BoredRepository(
            IBoredStorage boredStorage,
            BoredApiClient boredApiClient
    ) {
        this.boredStorage = boredStorage;
        this.boredApiClient = boredApiClient;
    }

    private void fetchAction(
            String type,
            Float minPrice,
            BoredApiClient.BoredActionCallback callback
    ) {
        boredApiClient.getAction(type, minPrice, new BoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction result) {
                BoredAction savedAction = getBoredAction(result.getKey());
                result.setSaved(savedAction != null);

                mLastAction = result;
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception exception) {
                callback.onFailure(exception);
            }
        });
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

        if (Objects.equals(boredAction.getKey(), mLastAction.getKey())) {
            mLastAction.setSaved(false);
        }
    }

    public void getAction(
            Boolean fromCache,
            String type,
            Float minPrice,
            BoredApiClient.BoredActionCallback callback
    ) {
        if (fromCache) {
            if (mLastAction == null) {
                fetchAction(type, minPrice, callback);
            } else {
                callback.onSuccess(mLastAction);
            }
        } else {
            fetchAction(type, minPrice, callback);
        }
    }
}
