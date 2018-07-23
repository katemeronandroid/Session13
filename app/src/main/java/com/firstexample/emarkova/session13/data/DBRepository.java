package com.firstexample.emarkova.session13.data;

import com.firstexample.emarkova.session13.data.entity.DataDay;
import com.firstexample.emarkova.session13.domain.model.Day;

import java.util.ArrayList;

public interface DBRepository {
    public ArrayList<DataDay> getDayInfo();
    public DataDay getDetailInfo(String day);
    public void setNewForecast(String country);
    public void resetTable();
    public Day mapToDay(DataDay dataDay);
}
