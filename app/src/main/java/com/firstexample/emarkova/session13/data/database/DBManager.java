package com.firstexample.emarkova.session13.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.firstexample.emarkova.session13.data.entity.DataDay;

import java.util.ArrayList;

public class DBManager {
    private DBHelper helper;
    private static final String TABNAME = "DAYS";

    public DBManager(Context context) {
        this.helper = new DBHelper(context);
    }

    public ArrayList<DataDay> getDayInfo(){
        ArrayList<DataDay> result = new ArrayList<>();
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            db.beginTransaction();
            String [] columns = new String[] { "day_name", "icon", "temp_min", "temp_max" };
            Cursor cursor = db.query(TABNAME, columns, null, null, null, null, null);
            result = parseCursorForInfo(cursor);
            cursor.close();
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.v("SQLiteException", e.getMessage());
        }
        finally {
            if(db != null){
                if(db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
            }
        }
        return result;
    }
    public DataDay getDetailInfo(String day){
        DataDay result = new DataDay();
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            db.beginTransaction();
            String query = "SELECT * FROM " + TABNAME + " WHERE day_name='"+ day + "'";
            Cursor cursor = db.rawQuery(query, null);
            result = parseOneItemCursor(cursor);
            cursor.close();
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.v("SQLiteException", e.getMessage());
        }
        finally {
            if(db != null){
                if(db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
            }
        }
        return result;
    }

    private DataDay parseOneItemCursor(Cursor cursor) {
     DataDay result = new DataDay();
        if(cursor.moveToFirst()) {
            //"date_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind"
            result.setDayName(cursor.getString(cursor.getColumnIndex("day_name")));//0
            result.getDayWeather().setIconString(cursor.getString(cursor.getColumnIndex("icon")));
            result.getDayWeather().setTemperatureMax(Double.parseDouble(cursor.getString(cursor.getColumnIndex("temp_max"))));//2
            result.getDayWeather().setPressure(Double.parseDouble(cursor.getString(cursor.getColumnIndex("press"))));//3
            result.getDayWeather().setWindSpeed(Double.parseDouble(cursor.getString(cursor.getColumnIndex("wind"))));//4
        }
        return result;
    }

    public void addNewDay(ArrayList<String> list) {
        SQLiteDatabase db = null;
        try {
            db = helper.getWritableDatabase();
            db.beginTransaction();
            ContentValues values = helper.getContentValues(list);
            db.insert(TABNAME, null, values);
            db.setTransactionSuccessful();
        }catch (SQLiteException e) {
            Log.v("SQLiteException", e.getMessage());
        } finally {
            if(db != null){
                if(db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
            }
        }
    }
    private ArrayList<DataDay> parseCursorForInfo(Cursor cursor) {
        ArrayList<DataDay> result = new ArrayList<DataDay>();
        DataDay newDay;
        if(cursor.moveToFirst()) {
            do {
                newDay = new DataDay();
                newDay.setDayName(cursor.getString(cursor.getColumnIndex("day_name")));//0
                newDay.getDayWeather().setTemperatureMax(Double.parseDouble(cursor.getString(cursor.getColumnIndex("temp_max"))));//2
                newDay.getDayWeather().setTemperatureMin(Double.parseDouble(cursor.getString(cursor.getColumnIndex("temp_min"))));
                result.add(newDay);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public void deleteTable() {
        SQLiteDatabase db = null;
        try {
            db = helper.getWritableDatabase();
            helper.deleteTable(db);
        }catch (SQLiteException e) {
            Log.v("SQLiteException", e.getMessage());
        } finally {
            if(db != null){
                if(db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
            }
        }
    }
    public void createTable() {
        SQLiteDatabase db = null;
        try {
            db = helper.getWritableDatabase();
            helper.createTable(db);
        }catch (SQLiteException e) {
            Log.v("SQLiteException", e.getMessage());
        } finally {
            if(db != null){
                if(db.inTransaction()) {
                    db.endTransaction();
                }
                db.close();
            }
        }
    }

}
