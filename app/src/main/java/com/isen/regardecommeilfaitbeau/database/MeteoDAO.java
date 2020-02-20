package com.isen.regardecommeilfaitbeau.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

import java.util.ArrayList;

@Dao
public interface MeteoDAO {
    // Meteo Hour
    @Query("SELECT * FROM MeteoHour")
    ArrayList<MeteoHour> getAllHours();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllHours(ArrayList<MeteoHour> meteo);

    @Query("DELETE FROM MeteoHour")
    void deleteAllHours();

    // Meteo Day
    @Query("SELECT * FROM MeteoDay")
    ArrayList<MeteoDay> getAllDays();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDays(ArrayList<MeteoDay> meteo);

    @Query("DELETE FROM MeteoDay")
    void deleteAllDays();

    // Alert
    @Query("SELECT * FROM Alert")
    ArrayList<Alert> getAllAlerts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllAlerts(ArrayList<Alert> alert);

    @Query("DELETE FROM Alert")
    void deleteAllAlerts();
}
