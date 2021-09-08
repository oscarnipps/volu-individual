package com.example.volu_individual.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.volu_individual.data.dao.AuthDao;
import com.example.volu_individual.data.local.user.User;

@Database(
        entities = {User.class},
        exportSchema = false,
        version = 1
)
public abstract class AppDatabase  extends RoomDatabase {

    public abstract AuthDao getAuthDao();
}
