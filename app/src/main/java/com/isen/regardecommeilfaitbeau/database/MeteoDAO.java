package com.isen.regardecommeilfaitbeau.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MeteoDAO {

    // Meteo Hour
    @Query("SELECT * FROM MeteoHour")
    List<MeteoHour> getAllHours();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllHours(List<MeteoHour> meteo);

    @Query("DELETE FROM MeteoHour")
    void deleteAllHours();

    // Meteo Day
    @Query("SELECT * FROM MeteoDay")
    List<MeteoDay> getAllDays();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDays(List<MeteoDay> meteo);

    @Query("DELETE FROM MeteoDay")
    void deleteAllDays();

    // Alert
    @Query("SELECT * FROM Alert")
    List<Alert> getAllAlerts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllAlerts(List<Alert> alert);

    @Query("DELETE FROM Alert")
    void deleteAllAlerts();
}
