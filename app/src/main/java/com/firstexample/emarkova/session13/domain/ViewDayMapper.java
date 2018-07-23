package com.firstexample.emarkova.session13.domain;

import com.firstexample.emarkova.session13.domain.model.Day;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

public class ViewDayMapper {
    public static ViewDay mapToView(Day day) {
        ViewDay result = new ViewDay();
        result.setDayName(day.getDayName());
        result.setIconString(day.getIconString());
        result.setPressure(day.getPressure());
        result.setTemperatureMax(day.getTemperatureMax());
        result.setWindSpeed(day.getWindSpeed());
        return result;
    }
}
