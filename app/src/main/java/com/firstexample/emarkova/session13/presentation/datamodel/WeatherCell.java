package com.firstexample.emarkova.session13.presentation.datamodel;

import android.os.Parcel;
import android.os.Parcelable;


public class WeatherCell implements Parcelable {
    String day;
    String weather;

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public WeatherCell(String day, String weather) {
        this.day = day;
        this.weather = weather;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
