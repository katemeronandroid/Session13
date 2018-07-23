package com.firstexample.emarkova.session13.data.entity;

public class DataDay {
    private String dayName;
    private DayWeather dayWeather;

    public DataDay() {
        dayWeather = new DayWeather();
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public DayWeather getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(DayWeather dayWeather) {
        this.dayWeather = dayWeather;
    }
}
