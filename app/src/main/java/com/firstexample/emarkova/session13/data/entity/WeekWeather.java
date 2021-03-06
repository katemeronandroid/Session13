package com.firstexample.emarkova.session13.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeekWeather {

    @SerializedName("data")
    private List<DayWeather> weatherList;

    public List<DayWeather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<DayWeather> weatherList) {
        this.weatherList = weatherList;
    }

}
