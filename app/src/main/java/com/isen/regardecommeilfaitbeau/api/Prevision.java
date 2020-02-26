package com.isen.regardecommeilfaitbeau.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.Request.Request;
import com.isen.regardecommeilfaitbeau.api.conversion.ConversionDaily;
import com.isen.regardecommeilfaitbeau.api.conversion.ConversionHourly;
import com.isen.regardecommeilfaitbeau.api.conversion.ConvertionAlerts;
import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.Currently;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;
import com.isen.regardecommeilfaitbeau.typeData.Position;
import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Prevision {

    private Position position;
    private Time time;
    private String timeZone;

    private Request request;

    private JSONObject currentlyJSON;
    private JSONArray alertsJSON;
    private JSONArray pastHours;
    private JSONArray futurHours;
    private JSONArray dailyJson;

    private ConvertionAlerts convertionAlerts;
    private ConversionHourly conversionHourly;
    private ConversionDaily conversionDaily;

    private Currently currently;
    private ArrayList<Alert> alerts;
    private ArrayList<MeteoDay> meteoDay;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Prevision(double latitude, double longitude) throws JSONException, NumberHoursOfDayException {
        request = new Request(latitude, longitude);
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Prevision(String nameCity) throws JSONException, NumberHoursOfDayException {
        request = new Request(nameCity);
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject() throws JSONException, NumberHoursOfDayException {
        getRequestProperties();
        convertionJSON();
    }

    private void getRequestProperties(){
        position = request.getPosition();
        time  = request.getActualTime();
        timeZone = time.getZoneIdS();
        currentlyJSON = request.getCurrently();
        if(request.getAlerts() != null){
            alertsJSON = request.getAlerts();
        }
        pastHours = request.getPastHours();
        futurHours = request.getFuturHours();
        dailyJson = request.getDaily();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void convertionJSON() throws JSONException, NumberHoursOfDayException {
        currently = new Currently(currentlyJSON, timeZone);
        if(alertsJSON != null){
            convertionAlerts = new ConvertionAlerts(alertsJSON, time);
            alerts = convertionAlerts.getAlerts();
        }else {
            alerts = new ArrayList<>();
        }
        conversionHourly = new ConversionHourly(futurHours, pastHours, time);
        conversionDaily = new ConversionDaily(dailyJson, time, conversionHourly.getHoursPerDay());
        meteoDay = conversionDaily.getDaily();
    }

    public Position getPosition() {
        return position;
    }

    public Time getTime() {
        return time;
    }

    public Currently getCurrently() {
        return currently;
    }

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public ArrayList<MeteoDay> getMeteoDay() {
        return meteoDay;
    }
}
