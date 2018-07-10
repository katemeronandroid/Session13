package com.firstexample.emarkova.session13;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.util.Log;

import com.firstexample.emarkova.session13.database.DBManager;
import com.firstexample.emarkova.session13.datamodel.DayManager;
import com.firstexample.emarkova.session13.datamodel.DayWeather;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeatherIntentService extends IntentService {
    private static final long TIMEOUT = 1000;

    public WeatherIntentService() {
        super("WeatherIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ArrayList<String> weatherList = new ArrayList<>();
        APIHelper apiHelper = new APIHelper(new RetrofitHelper());
        apiHelper.authAsync();
        while (apiHelper.getWeatherForecast() == null) {
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Logs", "weather loop over");
        List<DayWeather> weatherForecastBig = apiHelper.getWeatherForecast().getWeekForecast().getWeatherList();
        List<DayWeather> weatherForecast = weatherForecastBig.subList(0,weatherForecastBig.size() - 1);
        DBManager dbManager = new DBManager(getApplicationContext());
        dbManager.deleteTable();
        dbManager.createTable();
        Calendar calendar = Calendar.getInstance();
        Integer day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 0; i < weatherForecast.size(); i++) {
            DayWeather dayWeather = weatherForecast.get(i);
            ArrayList<String> dayInfo = new ArrayList<String>();
            //"date_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind"
            dayInfo.add(DayManager.getDay(day));
            dayInfo.add(dayWeather.getIconString());
            dayInfo.add(getCel(dayWeather.getTemperatureMin())+" C");
            dayInfo.add(getCel(dayWeather.getTemperatureMax())+ " C");
            dayInfo.add(String.valueOf(Math.round(dayWeather.getVisibility())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getCloudCover())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getPressure())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getHumidity())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getWindSpeed())));
            dbManager.addNewDay(dayInfo);
            day = (day + 1) % 7;
        }

        Intent broadcastIntent = new Intent("emarkova.GET_WEATHER");
        sendBroadcast(broadcastIntent);

    }

    private String getCel(Double number) {
        return String.valueOf(Math.round((number-32)/1.8));
    }
}
