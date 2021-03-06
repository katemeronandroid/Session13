package com.firstexample.emarkova.session13.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.firstexample.emarkova.session13.DaggerContextComponent;
import com.firstexample.emarkova.session13.MyApplication;

import java.util.ArrayList;

import javax.inject.Inject;


public class DBHelper extends SQLiteOpenHelper {
    private static final String TABNAME = "DAYS";
    private static final String DB_NAME = "weather_database";
    private static final int VERSION_DB = 1;
    Double test = 0.0;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Inject
    public DBHelper() {
        this(MyApplication.getContext(), DB_NAME, null, VERSION_DB);
    }

   /* public DBHelper(Context context) {
        this(context, DB_NAME, null, VERSION_DB);
        //this(DaggerContextComponent.builder().build().getApp().context, DB_NAME, null, VERSION_DB);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    public void createTable(SQLiteDatabase sqLiteDatabase) {
        //{ "day_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind" };
        sqLiteDatabase.execSQL(" CREATE TABLE "+TABNAME+"( day_id integer PRIMARY KEY, day_name text NOT NULL, icon text, temp_min text, temp_max text, visib text, cloud text, press text, humid text, wind text)");
        //тут могла быть вторая табла, но ее тут нет
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        deleteTable(sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }

    public void deleteTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABNAME);
    }

    public ContentValues getContentValues(ArrayList<String> list) {
        String [] columns = new String[] { "day_name", "icon", "temp_min", "temp_max", "visib", "cloud", "press", "humid", "wind" };
        ContentValues values = new ContentValues();
        for(int i = 0; i < columns.length; i++) {
            values.put(columns[i], list.get(i));
        }
        return values;
    }

}
