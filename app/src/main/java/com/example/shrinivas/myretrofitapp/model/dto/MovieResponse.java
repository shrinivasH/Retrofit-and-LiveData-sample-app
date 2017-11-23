package com.example.shrinivas.myretrofitapp.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse implements Parcelable {
    @SerializedName("results")
    Movie[] results;
    ArrayList<LocalMovie> localMovies;

    public MovieResponse(Movie[] results) {
        this.results = results;
    }


    protected MovieResponse(Parcel in) {
        this.localMovies = in.readArrayList(null);
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    public Movie[] getResultsArray() {
        return results;
    }

    public ArrayList<LocalMovie> getResults() {
        ArrayList<Movie> movieResponses = new ArrayList<Movie>();
        ArrayList<LocalMovie> localMovies = new ArrayList<>();
        for (Movie movie : results) {
            movieResponses.add(movie);
            LocalMovie localMovie = new LocalMovie(movie.getId(), movie.getVote_count(),
                    movie.isVideo(), movie.getVote_average(), movie.getTitle(), movie.getPopularity(),
                    movie.getPoster_path(), movie.getOriginal_language(), movie.getOriginal_title(),
                    movie.getBackdrop_path(), movie.isAdult(), movie.getOverview(), movie.getRelease_date());
            localMovies.add(localMovie);

        }

        return localMovies;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(localMovies);
    }

}