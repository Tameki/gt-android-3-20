package com.geektech.boredapp_20.data.local;

import com.geektech.boredapp_20.model.BoredAction;

import java.util.List;

public interface IBoredStorage {
    void saveBoredAction(BoredAction boredAction);

    BoredAction getBoredAction(String key);

    List<BoredAction> getAllActions();

    void deleteBoredAction(BoredAction boredAction);
}
