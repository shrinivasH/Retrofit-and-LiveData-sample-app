package com.example.shrinivas.myretrofitapp.model.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

@Entity
public class LocalMovie {
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @SerializedName("id")
    private int id;
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    private int vote_count;
    @ColumnInfo(name = "video")
    @SerializedName("video")
    @TypeConverters(MyConverters.class)
    private boolean video;
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    @TypeConverters(MyConverters.class)
    private float vote_average;
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;
    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    @TypeConverters(MyConverters.class)
    private float popularity;
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String poster_path;
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    private String original_language;
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    private String original_title;
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    @TypeConverters(MyConverters.class)
    private boolean adult;
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private String release_date;

    public LocalMovie(int id, int vote_count, boolean video, float vote_average, String title,
                      float popularity, String poster_path, String original_language, String original_title,
                      String backdrop_path, boolean adult, String overview, String release_date) {
        this.id = id;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}