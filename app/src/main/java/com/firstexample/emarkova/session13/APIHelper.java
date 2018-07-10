package com.firstexample.emarkova.session13;

import com.firstexample.emarkova.session13.datamodel.WeatherForecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIHelper {
    public static String KEY = "f05abbdbbf17122b68d1be8757b0cd10";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static RetrofitHelper retrofit = null;
    private WeatherForecast weatherForecast = null;
    private static double lat = 37.3357;// 55.4507;
    private static double lon = 126.5842;//37.3656;


    public WeatherForecast getWeatherForecast() {
        return weatherForecast;
    }
    public void setWeatherForecast(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }
    public APIHelper(RetrofitHelper helper) {
        this.retrofit = helper;
    }

    public void authAsync() {
        retrofit.getService().getForecast(lat,lon).enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                weatherForecast = response.body();
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {

            }
        });
    }
}
