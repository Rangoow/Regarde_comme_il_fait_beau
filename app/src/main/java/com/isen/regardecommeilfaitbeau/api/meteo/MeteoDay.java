package com.isen.regardecommeilfaitbeau.api.meteo;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;
import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MeteoDay {
    @PrimaryKey() @NonNull @Embedded(prefix = "time")
    private Time time;
    private String summary;
    private String icon;
    @Embedded(prefix = "sunriseTime")
    private Time sunriseTime;
    @Embedded(prefix = "sunsetTime")
    private Time sunsetTime;

    private double moonPhase;

    private double precipIntensity;
    private double precipIntensityMax;
    @Embedded(prefix = "precipIntensityMaxTime")
    private Time precipIntensityMaxTime;
    private double precipProbability;
    private String precipType;

    private double temperatureMin;
    @Embedded(prefix = "temperatureMinTime")
    private Time temperatureMinTime;
    private double temperatureMax;
    @Embedded(prefix = "temperatureMaxTime")
    private Time temperatureMaxTime;

    private double apparentTemperatureMin;
    @Embedded(prefix = "apparentTemperatureMinTime")
    private Time apparentTemperatureMinTime;
    private double apparentTemperatureMax;
    @Embedded(prefix = "apparentTemperatureMaxTime")
    private Time apparentTemperatureMaxTime;

    private double dewPoint;
    private double humidity;
    private double pressure;

    private double windSpeed;
    private double windGust;
    @Embedded(prefix = "windGustTime")
    private Time windGustTime;
    private double windBearing;
    private double cloudCover;
    private double uvIndex;
    @Embedded(prefix = "uvIndexTime")
    private Time uvIndexTime;
    private double visibility;
    private double ozone;

    @Ignore
    private List<MeteoHour> hourByHour;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MeteoDay(JSONObject jsonObject, String timeZone, List<MeteoHour> hoursOfDay) throws NumberHoursOfDayException {
        if(hoursOfDay.size() == 24 || hoursOfDay.isEmpty()){
            hourByHour = hoursOfDay;
        }else{
            throw new NumberHoursOfDayException();
        }
        makeObject(jsonObject, timeZone);
    }

    public MeteoDay(@NonNull Time time, String summary, String icon, Time sunriseTime, Time sunsetTime, double moonPhase, double precipIntensity, double precipIntensityMax, Time precipIntensityMaxTime, double precipProbability, String precipType, double temperatureMin, Time temperatureMinTime, double temperatureMax, Time temperatureMaxTime, double apparentTemperatureMin, Time apparentTemperatureMinTime, double apparentTemperatureMax, Time apparentTemperatureMaxTime, double dewPoint, double humidity, double pressure, double windSpeed, double windGust, Time windGustTime, double windBearing, double cloudCover, double uvIndex, Time uvIndexTime, double visibility, double ozone, boolean isMake) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensity = precipIntensity;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windGustTime = windGustTime;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
        this.visibility = visibility;
        this.ozone = ozone;
        this.isMake = isMake;
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

    // Getters

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

    public List<MeteoHour> getHourByHour() {
        return hourByHour;
    }

    public boolean isMake() {
        return isMake;
    }


    // Setters

    public void setTime(@NonNull Time time) {
        this.time = time;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setSunriseTime(Time sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public void setSunsetTime(Time sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public void setPrecipIntensityMaxTime(Time precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public void setTemperatureMinTime(Time temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public void setTemperatureMaxTime(Time temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public void setApparentTemperatureMinTime(Time apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public void setApparentTemperatureMaxTime(Time apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public void setWindGustTime(Time windGustTime) {
        this.windGustTime = windGustTime;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public void setUvIndexTime(Time uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public void setHourByHour(List<MeteoHour> hourByHour) {
        this.hourByHour = hourByHour;
    }

    public void setMake(boolean make) {
        isMake = make;
    }

}