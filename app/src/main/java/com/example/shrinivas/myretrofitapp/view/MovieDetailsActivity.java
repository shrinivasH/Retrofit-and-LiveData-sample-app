package com.example.shrinivas.myretrofitapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shrinivas.myretrofitapp.R;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView mMovieName, mMovieDetails, mMovieRatings;
    private LocalMovie localMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        mMovieName = (TextView) findViewById(R.id.MovieName);
        mMovieDetails = (TextView) findViewById(R.id.MovieDescription);
        mMovieRatings = (TextView) findViewById(R.id.MovieRating);
        Bundle getData = getIntent().getExtras();
        if (getData != null) {
            localMovie = getData.getParcelable("Movie");
        }
        mMovieName.setText(localMovie.getOriginal_title());
        mMovieDetails.setText(localMovie.getOverview());
        mMovieRatings.setText(""+localMovie.getPopularity());
    }
}
