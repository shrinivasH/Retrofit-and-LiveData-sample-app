package com.example.shrinivas.myretrofitapp.model.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;

import java.util.List;
@Dao
public interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertUser(LocalMovie movieInfo);

    @Query("SELECT * FROM LocalMovie")
    public LiveData<List<LocalMovie>> getData();
}