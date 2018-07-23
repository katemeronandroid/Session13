package com.firstexample.emarkova.session13.data.entity;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast {
    @SerializedName("daily")
    private WeekWeather weekForecast;

    public WeekWeather getWeekForecast() {
        return weekForecast;
    }

    public void setWeekForecast(WeekWeather weekForecast) {
        this.weekForecast = weekForecast;
    }
}
