package com.firstexample.emarkova.session13.data.API;

import com.firstexample.emarkova.session13.data.entity.WeatherForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServer {

    @GET("/forecast/{token}/{lat},{long}")
    Call<WeatherForecast> getForecast(@Path("token") String token, @Path("lat") double latitude, @Path("long") double longitude);
}
