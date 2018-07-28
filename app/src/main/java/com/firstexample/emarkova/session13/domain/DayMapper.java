package com.firstexample.emarkova.session13.domain;

import com.firstexample.emarkova.session13.data.entity.DataDay;
import com.firstexample.emarkova.session13.domain.model.Day;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


public class DayMapper {

    public static Day mapToDomain(DataDay dataDay) {
        Day result = new Day();
        result.setDayName(dataDay.getDayName());
        result.setTime(dataDay.getDayWeather().getTime());
        result.setIconString(dataDay.getDayWeather().getIconString());
        result.setTemperatureMax(dataDay.getDayWeather().getTemperatureMax());
        result.setTemperatureMin(dataDay.getDayWeather().getTemperatureMin());
        result.setVisibility(dataDay.getDayWeather().getVisibility());
        result.setCloudCover(dataDay.getDayWeather().getCloudCover());
        result.setPressure(dataDay.getDayWeather().getPressure());
        result.setHumidity(dataDay.getDayWeather().getHumidity());
        result.setWindSpeed(dataDay.getDayWeather().getWindSpeed());
        return result;
    }
}
