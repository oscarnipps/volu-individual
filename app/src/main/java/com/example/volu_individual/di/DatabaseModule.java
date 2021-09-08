package com.example.volu_individual.di;

import android.app.Application;

import androidx.room.Room;

import com.example.volu_individual.data.Constants;
import com.example.volu_individual.data.local.AppDatabase;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    //todo: add migrations here

    public static AppDatabase provideDatabase(Application context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                Constants.DATABASE_NAME
        ).build();
    }
}
