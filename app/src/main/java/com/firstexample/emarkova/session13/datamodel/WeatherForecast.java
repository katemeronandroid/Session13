package com.firstexample.emarkova.session13.datamodel;

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
