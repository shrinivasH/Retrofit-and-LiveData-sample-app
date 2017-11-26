package com.example.shrinivas.myretrofitapp.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.shrinivas.myretrofitapp.MainActivity;
import com.example.shrinivas.myretrofitapp.model.dto.LocalMovie;

public interface RecyclerTouchListener {
    void onItemClick(LocalMovie movie);
}