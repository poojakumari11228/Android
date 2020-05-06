package com.example.user.lab10sqllitedatabases;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@android.arch.persistence.room.Database(entities = {Student.class} , version = 1)
public abstract class Database extends RoomDatabase {
    public abstract DAO dao();
    public static Database getData(Context context) {
        if (MainActivity.database == null) {
            MainActivity.database = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "Student").allowMainThreadQueries().build();

        }
        return MainActivity.database;


    }



}
