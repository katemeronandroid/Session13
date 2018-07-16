package com.firstexample.emarkova.session13.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

public class DBManager {
    private DBHelper helper;
    private static final String TABNAME = "DAYS";

    public DBManager(Context context) {
        this.helper = new DBHelper(context);
    }

    public ArrayList<ArrayList<String>> getDayInfo(){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = null;
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            db.beginTransaction();
            String [] columns = new String[] { "day_name", "icon", "temp_min", "temp_max" };
            Cursor cursor = db.query(TABNAME, columns, null, null, null, null, null);
            for(int i = 0; i < columns.length; i++) {
                temp = parseCursorForInfo(cursor, columns[i]);
                result.add(temp);
            }
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
    public ArrayList<String> getDetailInfo(String day){
        ArrayList<String> result = new ArrayList<>();
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

    private ArrayList<String> parseOneItemCursor(Cursor cursor) {
        ArrayList<String> result = new ArrayList<String>();
        if(cursor.moveToFirst()) {
            //"date_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind"
            result.add(cursor.getString(cursor.getColumnIndex("day_name")));//0
            result.add(cursor.getString(cursor.getColumnIndex("icon")));//1
            result.add(cursor.getString(cursor.getColumnIndex("temp_max")));//2
            result.add(cursor.getString(cursor.getColumnIndex("press")));//3
            result.add(cursor.getString(cursor.getColumnIndex("wind")));//4
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
    private ArrayList<String> parseCursorForInfo(Cursor cursor, String col) {
        ArrayList<String> result = new ArrayList<String>();
        if(cursor.moveToFirst()) {
            result.add(cursor.getString(cursor.getColumnIndex(col)));
            while (cursor.moveToNext()) {
                result.add(cursor.getString(cursor.getColumnIndex(col)));
            }
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
