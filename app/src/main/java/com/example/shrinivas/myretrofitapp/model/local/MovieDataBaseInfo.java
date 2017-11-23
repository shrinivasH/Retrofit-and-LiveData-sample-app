package com.example.shrinivas.myretrofitapp.model.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;

@Database(entities = {LocalMovie.class}, version = 1)
public abstract class MovieDataBaseInfo extends RoomDatabase {
    public abstract MovieDAO userDatabase();
}