package com.example.shrinivas.myretrofitapp.model.dto;

import android.arch.persistence.room.TypeConverter;

public class MyConverters {
    @TypeConverter
    public static int booleanToInt(boolean val) {
        return val ? 1 : 0;
    }

    @TypeConverter
    public static boolean intToBoolean(int val) {
        return val == 1 ? true : false;
    }

    @TypeConverter
    public static String floatToString(float val) {
        String returnVal = String.valueOf(val);
        return returnVal;
    }

    @TypeConverter
    public static float StringToFloat(String val) {
        float returnVal = Float.valueOf(val);
        return returnVal;
    }
}