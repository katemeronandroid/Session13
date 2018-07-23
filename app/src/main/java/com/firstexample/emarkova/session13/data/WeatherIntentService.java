package com.firstexample.emarkova.session13.data;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class WeatherIntentService extends IntentService {
    private static final long TIMEOUT = 1000;
    private static final String KEY = "country";
    DBReposImp dbReposImp;

    public WeatherIntentService() {
        super("WeatherIntentService");
        dbReposImp = new DBReposImp();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        dbReposImp.resetTable();
        String country = intent.getStringExtra(KEY);
        dbReposImp.setNewForecast(country);
        Intent broadcastIntent = new Intent("emarkova.GET_WEATHER");
        sendBroadcast(broadcastIntent);
    }

    private String getCel(Double number) {
        return String.valueOf(Math.round((number-32)/1.8));
    }
}
