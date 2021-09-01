package com.example.volu.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.volu.data.dao.AuthDao;
import com.example.volu.data.local.user.User;

@Database(
        entities = {User.class},
        exportSchema = false,
        version = 1
)
public abstract class AppDatabase  extends RoomDatabase {

    public abstract AuthDao getAuthDao();
}
