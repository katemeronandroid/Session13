package com.firstexample.emarkova.session13.domain.usecases;

import com.firstexample.emarkova.session13.data.DBReposImp;
import com.firstexample.emarkova.session13.data.DBRepository;
import com.firstexample.emarkova.session13.data.DayMapper;
import com.firstexample.emarkova.session13.domain.ViewDayMapper;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

import java.util.ArrayList;

public class GetWeekForecast {
    private DBRepository repository;

    public GetWeekForecast(){
        repository = new DBReposImp();
    }

    public ArrayList<ViewDay> getWeekForecast() {
        ArrayList<ViewDay> result = new ArrayList<>();
        for (int i = 0; i < repository.getDayInfo().size(); i++) {
            result.add(ViewDayMapper.mapToView(DayMapper.mapToDomain(repository.getDayInfo().get(i))));
        }
        return result;
    }
}
