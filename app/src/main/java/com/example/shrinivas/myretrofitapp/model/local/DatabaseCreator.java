package com.example.shrinivas.myretrofitapp.model.local;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseCreator {
    private static MovieDataBaseInfo userDatabase;
    private static final Object LOCK = new Object();

    public synchronized static MovieDataBaseInfo getMovieDatabase(Context context) {
        if (userDatabase == null) {
            synchronized (LOCK) {
                if (userDatabase == null) {
                    userDatabase = Room.databaseBuilder(context,
                            MovieDataBaseInfo.class, "movie db").build();
                }
            }
        }
        return userDatabase;
    }
}