package com.firstexample.emarkova.session13.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeekWeather {
    //@SerializedName("icon")
    //private List<String> icons;

    @SerializedName("data")
    private List<DayWeather> weatherList;

    public List<DayWeather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<DayWeather> weatherList) {
        this.weatherList = weatherList;
    }

}
