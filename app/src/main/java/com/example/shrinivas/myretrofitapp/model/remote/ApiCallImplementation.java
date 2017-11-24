package com.example.shrinivas.myretrofitapp.model.remote;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.shrinivas.myretrofitapp.model.dto.Constants;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;
import com.example.shrinivas.myretrofitapp.model.dto.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.DownloadManager.STATUS_RUNNING;

public class ApiCallImplementation extends IntentService {
    private ApiInterface apiInterface;
    private NetworkInteractor interactor;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public ApiCallImplementation() {
        super(ApiCallImplementation.class.getName());
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        this.apiInterface = ApiClient.getRetrofitClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getTopRatedMovies("b7cd3340a794e5a2f35e3abb820b497f");
        final ArrayList<LocalMovie> movieResponses = new ArrayList<LocalMovie>();
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        String command = intent.getStringExtra("command");
        final Bundle b = new Bundle();
        if (command.equals("query")) {
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    int statusCode = response.code();
                    ArrayList<LocalMovie> movieResponsesTemp = response.body().getResults();
                    movieResponses.addAll(movieResponsesTemp);
                    b.putParcelableArrayList("results", movieResponses);
                    receiver.send(Constants.STATUS_FINISHED, b);
                    Log.d("mess", "mess");
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Log.d("Error", t.toString());
                    b.putString(Intent.EXTRA_TEXT, t.toString());
                    receiver.send(Constants.STATUS_ERROR, b);
                }
            });
        }
    }
}