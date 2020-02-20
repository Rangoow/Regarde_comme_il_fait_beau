package com.isen.regardecommeilfaitbeau.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

//@Database(entities = {MeteoHour.class, MeteoDay.class, Alert.class}, version = 1)
public abstract class MeteoDatabase extends RoomDatabase {
    //public abstract MeteoDAO meteoDAO();
}
