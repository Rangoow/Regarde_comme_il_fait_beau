package com.isen.regardecommeilfaitbeau.api.meteo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONObject;

import java.util.ArrayList;

public class MeteoDay {

    private Time time;
    private String summary;
    private String icon;
    private Time sunriseTime;
    private Time sunsetTime;

    private double moonPhase;

    private double precipIntensity;
    private double precipIntensityMax;
    private Time precipIntensityMaxTime;
    private double precipProbability;
    private String precipType;

    private double temperatureMin;
    private Time temperatureMinTime;
    private double temperatureMax;
    private Time temperatureMaxTime;

    private double apparentTemperatureMin;
    private Time apparentTemperatureMinTime;
    private double apparentTemperatureMax;
    private Time apparentTemperatureMaxTime;

    private double dewPoint;
    private double humidity;
    private double pressure;

    private double windSpeed;
    private double windGust;
    private Time windGustTime;
    private double windBearing;
    private double cloudCover;
    private double uvIndex;
    private Time uvIndexTime;
    private double visibility;
    private double ozone;

    private ArrayList<MeteoHour> hourByHour;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MeteoDay(JSONObject jsonObject, String timeZone, ArrayList<MeteoHour> hoursOfDay){
        hourByHour = hoursOfDay;
        makeObject(jsonObject, timeZone);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private boolean makeObject(JSONObject jsonObject, String timeZone){
        try{
            time = new Time(Integer.toString(jsonObject.getInt("time")),  timeZone);
            summary = jsonObject.getString("summary");
            icon = jsonObject.getString("icon");
            sunriseTime = new Time(Integer.toString(jsonObject.getInt("sunriseTime")), timeZone);
            sunsetTime = new Time(Integer.toString(jsonObject.getInt("sunsetTime")), timeZone);
            moonPhase = jsonObject.getDouble("moonPhase");
            precipIntensity = jsonObject.getDouble("precipIntensity");
            precipIntensityMax = jsonObject.getDouble("precipIntensityMax");
            precipIntensityMaxTime = new Time(Integer.toString(jsonObject.getInt("precipIntensityMaxTime")), timeZone);
            precipProbability = jsonObject.getDouble("precipProbability");
            precipType = jsonObject.getString("precipType");
            temperatureMax = jsonObject.getDouble("temperatureMax");
            temperatureMaxTime = new Time(Integer.toString(jsonObject.getInt("temperatureMaxTime")), timeZone);
            temperatureMin = jsonObject.getDouble("temperatureMin");
            temperatureMinTime = new Time(Integer.toString(jsonObject.getInt("temperatureMinTime")), timeZone);
            apparentTemperatureMax = jsonObject.getDouble("apparentTemperatureMax");
            apparentTemperatureMaxTime = new Time(Integer.toString(jsonObject.getInt("apparentTemperatureMaxTime")), timeZone);
            apparentTemperatureMin = jsonObject.getDouble("apparentTemperatureMin");
            apparentTemperatureMinTime = new Time(Integer.toString(jsonObject.getInt("apparentTemperatureMinTime")), timeZone);
            dewPoint = jsonObject.getDouble("dewPoint");
            humidity = jsonObject.getDouble("humidity");
            pressure = jsonObject.getDouble("pressure");
            windSpeed = jsonObject.getDouble("windSpeed");
            windGust = jsonObject.getDouble("windGust");
            windGustTime = new Time(Integer.toString(jsonObject.getInt("windGustTime")), timeZone);
            windBearing = jsonObject.getDouble("windBearing");
            cloudCover = jsonObject.getDouble("cloudCover");
            uvIndex = jsonObject.getDouble("uvIndex");
            uvIndexTime = new Time(Integer.toString(jsonObject.getInt("uvIndexTime")), timeZone);
            visibility = jsonObject.getDouble("visibility");
            ozone = jsonObject.getDouble("ozone");
            isMake = true;
            return true;
        }catch(Exception e){
            e.printStackTrace();
            isMake = false;
            return false;
        }
    }

    public Time getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public Time getSunriseTime() {
        return sunriseTime;
    }

    public Time getSunsetTime() {
        return sunsetTime;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public Time getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
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

    public double getDewPoint() {
        return dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public Time getWindGustTime() {
        return windGustTime;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public Time getUvIndexTime() {
        return uvIndexTime;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public ArrayList<MeteoHour> getHourByHour() {
        return hourByHour;
    }

    public boolean isMake() {
        return isMake;
    }
}