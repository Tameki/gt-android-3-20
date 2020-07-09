package com.geektech.boredapp_20.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geektech.boredapp_20.data.local.BoredDao;
import com.geektech.boredapp_20.model.BoredAction;

@Database(
        entities = { BoredAction.class },
        version = BoredDatabase.VERSION,
        exportSchema = false
)
public abstract class BoredDatabase extends RoomDatabase {
    public final static int VERSION = 1;

    public abstract BoredDao boredDao();
}
