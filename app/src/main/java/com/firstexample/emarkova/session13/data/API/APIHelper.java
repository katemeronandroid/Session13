package com.firstexample.emarkova.session13.data.API;

import com.firstexample.emarkova.session13.data.entity.WeatherForecast;

import javax.inject.Inject;

import dagger.Module;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIHelper {
    public static String KEY = "939831d11127fa45dc1d812a64d53af2";
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

    @Inject
    public APIHelper() {
        this.retrofit = new RetrofitHelper();
    }

    public void authAsync(String country) {
        setCountry(country);
        retrofit.getService().getForecast(KEY,lat,lon).enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                weatherForecast = response.body();
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {

            }
        });
    }

    private void setCountry(String country) {
        switch (country){
            case "moscow":
                lat =  55.4507;
                lon = 37.3656;
                break;
            case "seul":
                lat = 37.3357;
                lon = 126.5842;
                break;
            case "london":
                lat = 51.3030;
                lon = 0.0732;
                break;
            case "la":
                lat = 34.0308;
                lon = -118.1437;
        }
    }


}
