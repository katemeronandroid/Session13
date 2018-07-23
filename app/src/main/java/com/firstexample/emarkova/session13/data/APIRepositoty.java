package com.firstexample.emarkova.session13.data;

import com.firstexample.emarkova.session13.data.entity.WeatherForecast;

public interface APIRepositoty {
    public WeatherForecast getWeatherForecast();
    public void setWeatherForecast(WeatherForecast weatherForecast);
    public void authAsync(String country);
}
