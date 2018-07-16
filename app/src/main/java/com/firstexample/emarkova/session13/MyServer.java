package com.firstexample.emarkova.session13;

import com.firstexample.emarkova.session13.datamodel.WeatherForecast;
import com.firstexample.emarkova.session13.datamodel.WeekWeather;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyServer {

    @GET("/forecast/{token}/{lat},{long}")
    Call<WeatherForecast> getForecast(@Path("token") String token, @Path("lat") double latitude, @Path("long") double longitude);
}
