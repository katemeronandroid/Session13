package com.firstexample.emarkova.session13.datamodel;

import com.google.gson.annotations.SerializedName;

public class DayWeather {

    @SerializedName("time")
    private int time;

    @SerializedName("summary")
    private String iconString;

    @SerializedName("temperatureMin")
    private double temperatureMin;

    @SerializedName("temperatureMax")
    private double temperatureMax;

    @SerializedName("visibility")
    private double visibility;

    @SerializedName("cloudCover")
    private double cloudCover;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("windSpeed")
    private double windSpeed;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getIconString() {
        return iconString;
    }

    public void setIconString(String iconString) {
        this.iconString = iconString;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
