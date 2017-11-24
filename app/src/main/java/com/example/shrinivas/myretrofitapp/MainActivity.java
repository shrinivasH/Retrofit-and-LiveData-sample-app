package com.example.shrinivas.myretrofitapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shrinivas.myretrofitapp.adapters.MovieAdapter;
import com.example.shrinivas.myretrofitapp.model.dto.Constants;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;
import com.example.shrinivas.myretrofitapp.model.remote.ApiCallImplementation;
import com.example.shrinivas.myretrofitapp.model.remote.NetworkInteractor;
import com.example.shrinivas.myretrofitapp.viewModel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkInteractor.Receiver {

    public NetworkInteractor mReceiver;
    private MovieViewModel movieViewModel;
    private RecyclerView mRecyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.movieRecycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(getApplicationContext());
        mRecyclerView.setAdapter(movieAdapter);
        mReceiver = new NetworkInteractor(new Handler());
        mReceiver.setReceiver(this);
        final Intent intent = new Intent(getApplicationContext(), ApiCallImplementation.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("command", "query");
        startService(intent);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getAllMovies().observe(this, new Observer<List<LocalMovie>>() {
            @Override
            public void onChanged(@Nullable List<LocalMovie> localMovies) {
                if (localMovies == null) {
                    Log.d("mess", "mess");
                } else {
                    setRecyclerView(localMovies);
                }

            }
        });
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {

            case Constants.STATUS_FINISHED:
                ArrayList<LocalMovie> results = resultData.getParcelableArrayList("results");
                // do something interesting
                // hide progress
                movieViewModel.addMovieList(results);
                Log.d("mess", "mess");
                Log.d("mess", "mess");
                break;
            case Constants.STATUS_ERROR:
                // handle the error;
                break;
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        mReceiver.setReceiver(null);
    }

    private void setRecyclerView(List<LocalMovie> recycleList) {
        movieAdapter.setUserList(recycleList);
        movieAdapter.notifyDataSetChanged();

    }
}
