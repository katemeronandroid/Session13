package com.firstexample.emarkova.session13.data;

import com.firstexample.emarkova.session13.data.API.APIHelper;
import com.firstexample.emarkova.session13.data.API.RetrofitHelper;
import com.firstexample.emarkova.session13.data.entity.WeatherForecast;

public class APIReposImp implements APIRepositoty {
    private APIHelper helper;

    public APIReposImp() {
        this.helper = new APIHelper(new RetrofitHelper());
    }
    @Override
    public WeatherForecast getWeatherForecast() {
        return helper.getWeatherForecast();
    }

    @Override
    public void setWeatherForecast(WeatherForecast weatherForecast) {
        helper.setWeatherForecast(weatherForecast);
    }

    @Override
    public void authAsync(String country) {
        helper.authAsync(country);
    }
}
