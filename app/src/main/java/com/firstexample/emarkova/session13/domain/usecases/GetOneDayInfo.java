package com.firstexample.emarkova.session13.domain.usecases;

import com.firstexample.emarkova.session13.data.DBReposImp;
import com.firstexample.emarkova.session13.data.DBRepository;
import com.firstexample.emarkova.session13.domain.DayMapper;
import com.firstexample.emarkova.session13.domain.ViewDayMapper;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

public class GetOneDayInfo {

    private DBRepository repository;

    public GetOneDayInfo(){
        repository = new DBReposImp();
    }

     public ViewDay getOneDay(String day) {
        return ViewDayMapper.mapToView(DayMapper.mapToDomain(repository.getDetailInfo(day)));
    }
}
