package com.example.shrinivas.myretrofitapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.shrinivas.myretrofitapp.model.MovieRepository;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MovieViewModel extends AndroidViewModel {
    private final MovieRepository movieRepository;
    private final Executor executor = Executors.newFixedThreadPool(2);

    public MovieViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }

    public void addMovieList(final List<LocalMovie> localMovies) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                movieRepository.addMovieList(localMovies);
            }
        });
    }

    //Since room DAO returns LiveData, it runs on background thread.
    public LiveData<List<LocalMovie>> getAllMovies() {
        return movieRepository.getAllMovies();
    }
}