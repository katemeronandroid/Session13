package com.firstexample.emarkova.session13.datamodel;

public class DayManager {
    /*public static enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }*/
    public  static String [] Day = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    public static String getDay(int i) {
        return Day[i];
    }
}
