package com.firstexample.emarkova.session13.presentation.MVP;

import com.firstexample.emarkova.session13.domain.usecases.GetOneDayInfo;
import com.firstexample.emarkova.session13.domain.usecases.GetWeekForecast;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

import java.util.ArrayList;

public class MVPModelImp implements MVPModel {
    private GetOneDayInfo getter;
    private GetWeekForecast weekGetter;

    public MVPModelImp() {
        this.getter = new GetOneDayInfo();
        this.weekGetter = new GetWeekForecast();
    }

    @Override
    public ViewDay getData(String day) {
        return getter.getOneDay(day);
    }

    @Override
    public ArrayList<ViewDay> getDataAdapter() {
        return weekGetter.getWeekForecast();
    }

}
