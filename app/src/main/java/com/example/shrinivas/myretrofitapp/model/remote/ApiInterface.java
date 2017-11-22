package com.example.shrinivas.myretrofitapp.model.remote;

import com.example.shrinivas.myretrofitapp.model.dto.MovieResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("movie/upcoming")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}