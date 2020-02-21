package com.isen.regardecommeilfaitbeau.api.meteo;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
public class MeteoHour {

    private boolean make;

    @NonNull @PrimaryKey() @Embedded
    private Time time;
    private String summary;
    private String icon;
    private double precipIntensity;
    private double precipProbability;
    private String precipType;
    private double temperature;
    private double apparentTemperature;
    private double dewPoint;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private double windGust;
    private double windBearing;
    private double cloudCover;
    private double uvIndex;
    private double visibility;
    private double ozone;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MeteoHour(JSONObject jsonObject, String timeZone){
        this.makeObject(jsonObject, timeZone);
    }

    public MeteoHour(boolean make, @NonNull Time time, String summary, String icon, double precipIntensity, double precipProbability/*, String precipType*/, double temperature, double apparentTemperature, double dewPoint, double humidity, double pressure, double windSpeed, double windGust, double windBearing, double cloudCover, double uvIndex, double visibility, double ozone) {
        this.make = make;
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.precipIntensity = precipIntensity;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.ozone = ozone;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private boolean makeObject(JSONObject jsonObject, String timeZone){
        try{
            time = new Time(Integer.toString(jsonObject.getInt("time")), timeZone);
            summary = jsonObject.getString("summary");
            icon = jsonObject.getString("icon");
            precipIntensity = jsonObject.getDouble("precipIntensity");
            precipProbability = jsonObject.getDouble("precipProbability");
            precipType = ""; //jsonObject.getString("precipType");
            temperature = jsonObject.getDouble("temperature");
            apparentTemperature = jsonObject.getDouble("apparentTemperature");
            dewPoint = jsonObject.getDouble("dewPoint");
            humidity = jsonObject.getDouble("humidity");
            pressure = jsonObject.getDouble("pressure");
            windSpeed = jsonObject.getDouble("windSpeed");
            windGust = jsonObject.getDouble("windGust");
            windBearing = jsonObject.getDouble("windBearing");
            cloudCover = jsonObject.getDouble("cloudCover");
            uvIndex = jsonObject.getDouble("uvIndex");
            visibility = jsonObject.getDouble("visibility");
            ozone = jsonObject.getDouble("ozone");
            make = true;
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            make = false;
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

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
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

    public double getWindBearing() {
        return windBearing;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getOzone() {
        return ozone;
    }

    public boolean isMake() {
        return make;
    }

    // Setters


    public void setMake(boolean make) {
        this.make = make;
    }

    public void setTime(@NonNull Time time) {
        this.time = time;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
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

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }
}
