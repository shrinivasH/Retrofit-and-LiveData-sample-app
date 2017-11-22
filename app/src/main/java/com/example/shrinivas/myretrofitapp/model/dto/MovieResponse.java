package com.example.shrinivas.myretrofitapp.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    Movie[] results;

    public MovieResponse(Movie[] results) {
        this.results = results;
    }

    public Movie[] getResultsArray() {


        return results;
    }

    public List<LocalMovie> getResults() {
        ArrayList<Movie> movieResponses = new ArrayList<Movie>();
        List<LocalMovie> localMovies = new ArrayList<>();
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
}