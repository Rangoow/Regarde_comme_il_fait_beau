package com.isen.regardecommeilfaitbeau.api.meteo;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import java.util.ArrayList;

@Entity
public class MeteoDay {

    @NonNull @PrimaryKey @Embedded
    private Time sunriseTime;
    @Embedded
    private Time sunsetTime;

    private String moonPhase;

    private double precipIntensityMax;
    @Embedded
    private Time precipIntensityMaxTime;
    private String precipType;

    private double temperatureHigh;
    @Embedded
    private Time temperatureHighTime;
    private double temperatureLow;
    @Embedded
    private Time temperatureLowTime;

    private double temperatureMin;
    @Embedded
    private Time temperatureMinTime;
    private double temperatureMax;
    @Embedded
    private Time temperatureMaxTime;

    private double apparentTemperatureMin;
    @Embedded
    private Time apparentTemperatureMinTime;
    private double apparentTemperatureMax;
    @Embedded
    private Time apparentTemperatureMaxTime;

    @Embedded
    private Time windGustTime;
    @Embedded
    private Time uvIndexTime;

    @Ignore
    private ArrayList<MeteoHour> hourByHour;

    public ArrayList<MeteoHour> getHourByHour() {
        return this.hourByHour;
    }

    public Time getSunriseTime() {
        return sunriseTime;
    }

    public Time getSunsetTime() {
        return sunsetTime;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public Time getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public String getPrecipType() {
        return precipType;
    }

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public Time getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public double getTemperatureLow() {
        return temperatureLow;
    }

    public Time getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public Time getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public Time getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public Time getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public Time getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public Time getWindGustTime() {
        return windGustTime;
    }

    public Time getUvIndexTime() {
        return uvIndexTime;
    }
}
