package com.example.shrinivas.myretrofitapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shrinivas.myretrofitapp.model.dto.Constants;
import com.example.shrinivas.myretrofitapp.model.remote.ApiCallImplementation;
import com.example.shrinivas.myretrofitapp.model.remote.NetworkInteractor;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkInteractor.Receiver {

    public NetworkInteractor mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver = new NetworkInteractor(new Handler());
        mReceiver.setReceiver(this);
        final Intent intent = new Intent(getApplicationContext(), ApiCallImplementation.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("command", "query");
        startService(intent);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {

            case Constants.STATUS_FINISHED:
                List results = resultData.getParcelableArrayList("results");
                // do something interesting
                // hide progress
                break;
            case Constants.STATUS_ERROR:
                // handle the error;
                break;
        }


    }
    @Override
    protected void onPause () {
        super.onPause();
        mReceiver.setReceiver(null);
    }
}
