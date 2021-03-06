package com.example.shrinivas.myretrofitapp.adapters;

import android.app.LoaderManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.shrinivas.myretrofitapp.R;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;
import com.example.shrinivas.myretrofitapp.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private ArrayList<LocalMovie> movies;
    private Context mContext;
    private RecyclerTouchListener recyclerTouchListener;

    public MovieAdapter(Context mContext) {
        this.movies = new ArrayList<>();
        this.mContext = mContext;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_child_element, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        final LocalMovie movie = movies.get(position);

        holder.movieTitle.setText(movie.getTitle());
        holder.movieDate.setText(movie.getRelease_date());
        boolean adult=movie.isAdult();
        holder.movieCategory.setText("" + (adult ? "(A)":"(U)"));
        holder.mArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerTouchListener.onItemClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        TextView movieTitle;
        TextView movieDate;
        TextView movieCategory;
        ImageView mArrow;

        public MovieHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.movieName);
            movieDate = (TextView) itemView.findViewById(R.id.releasedate);
            movieCategory = (TextView) itemView.findViewById(R.id.movieCategory);
            mArrow = (ImageView) itemView.findViewById(R.id.mArrowNext);

        }
    }

    public void setUserList(List<LocalMovie> localMovies) {
        this.movies.clear();
        this.movies.addAll(localMovies);
    }

    public void setOnClickList(RecyclerTouchListener recyclerTouchListener) {
        this.recyclerTouchListener = recyclerTouchListener;
    }
}