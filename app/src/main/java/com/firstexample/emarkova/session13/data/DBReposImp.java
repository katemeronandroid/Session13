package com.firstexample.emarkova.session13.data;

import com.firstexample.emarkova.session13.data.API.APIHelper;
import com.firstexample.emarkova.session13.data.API.APIModule;
import com.firstexample.emarkova.session13.data.database.DBComponent;
import com.firstexample.emarkova.session13.data.database.DBManager;
import com.firstexample.emarkova.session13.data.database.DaggerDBComponent;
import com.firstexample.emarkova.session13.data.entity.DataDay;
import com.firstexample.emarkova.session13.data.entity.DayWeather;
import com.firstexample.emarkova.session13.domain.DayMapper;
import com.firstexample.emarkova.session13.domain.model.Day;
import com.firstexample.emarkova.session13.presentation.datamodel.DayManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBReposImp implements DBRepository {
    private static final long TIMEOUT = 1000;
    private DBManager dbManager;
    private APIHelper apiHelper;

    public DBReposImp(){
        DBComponent component = DaggerDBComponent.builder().aPIModule(new APIModule(new APIHelper())).build();
        dbManager = component.getDBManager();
        apiHelper = component.getHelper();
    }

    @Override
    public ArrayList<DataDay> getDayInfo() {
        return dbManager.getDayInfo();
    }

    @Override
    public DataDay getDetailInfo(String day) {
        return dbManager.getDetailInfo(day);
    }

    @Override
    public void setNewForecast(String country) {
        apiHelper.authAsync(country);
        while (apiHelper.getWeatherForecast() == null) {
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<DayWeather> weatherForecastBig = apiHelper.getWeatherForecast().getWeekForecast().getWeatherList();
        List<DayWeather> weatherForecast = weatherForecastBig.subList(0,weatherForecastBig.size() - 1);
        Calendar calendar = Calendar.getInstance();
        Integer day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 0; i < weatherForecast.size(); i++) {
            DayWeather dayWeather = weatherForecast.get(i);
            ArrayList<String> dayInfo = new ArrayList<String>();
            //"date_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind"
            dayInfo.add(DayManager.getDay(day));
            dayInfo.add(dayWeather.getIconString());
            dayInfo.add(getCel(dayWeather.getTemperatureMin()));
            dayInfo.add(getCel(dayWeather.getTemperatureMax()));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getVisibility())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getCloudCover())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getPressure())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getHumidity())));
            dayInfo.add(String.valueOf(Math.round(dayWeather.getWindSpeed())));
            dbManager.addNewDay(dayInfo);
            day = (day + 1) % 7;
        }
    }

    private String getCel(Double number) {
        return String.valueOf(Math.round((number-32)/1.8));
    }

    @Override
    public void resetTable() {
        dbManager.deleteTable();
        dbManager.createTable();
    }

    @Override
    public Day mapToDay(DataDay dataDay) {
        return DayMapper.mapToDomain(dataDay);
    }
}
