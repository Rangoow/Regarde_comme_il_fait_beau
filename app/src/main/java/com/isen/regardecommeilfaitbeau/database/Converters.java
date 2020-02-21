package com.isen.regardecommeilfaitbeau.database;

import androidx.room.TypeConverter;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import java.time.ZonedDateTime;

public class Converters {
    @TypeConverter
    public static ZonedDateTime toDate(String dateString) {
        if (dateString == null) {
            return null;
        } else {
            return ZonedDateTime.parse(dateString);
        }
    }

    @TypeConverter
    public static String toDateString(ZonedDateTime time) {
        if (time == null) {
            return null;
        } else {
            return time.toString();
        }
    }
}
