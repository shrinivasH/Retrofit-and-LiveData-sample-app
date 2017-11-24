package com.example.shrinivas.myretrofitapp.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;
import com.example.shrinivas.myretrofitapp.model.local.DatabaseCreator;
import com.example.shrinivas.myretrofitapp.model.local.MovieDAO;

import java.util.List;

public class MovieRepository {
    private final MovieDAO movieDAO;

    public MovieRepository(Application application) {
        movieDAO = DatabaseCreator.getMovieDatabase(application).userDatabase();
    }

    public void addMovieList(List<LocalMovie> localMovieList) {
        for (LocalMovie localMovie : localMovieList) {
            long rec = movieDAO.insertUser(localMovie);
            Log.d("db insert ", "added " + rec);
        }

    }

    public LiveData<List<LocalMovie>> getAllMovies() {
        LiveData<List<LocalMovie>> test = movieDAO.getData();
        Log.d("TAG", "TAG");
        return movieDAO.getData();
    }
}