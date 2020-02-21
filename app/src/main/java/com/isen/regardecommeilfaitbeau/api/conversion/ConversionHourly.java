package com.isen.regardecommeilfaitbeau.api.conversion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;
import com.isen.regardecommeilfaitbeau.typeData.Time;
import com.isen.regardecommeilfaitbeau.typeData.TimeStartDay;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ConversionHourly {

    private JSONArray nextHours;
    private JSONArray pastHours;

    private Time currentTime;
    private TimeStartDay startDay;

    private ArrayList<ArrayList<MeteoHour>> hoursPerDay;
    private ArrayList<MeteoHour> futurHours;

    private boolean isDone;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ConversionHourly(JSONArray nextHours, JSONArray pastHours, Time currentTime) throws JSONException {
        this.nextHours = nextHours;
        this.pastHours = pastHours;
        this.currentTime = currentTime;
        this.startDay = new TimeStartDay(currentTime.getEpochValue(), currentTime.getZoneIdS());
        this.hoursPerDay = new ArrayList<>();
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject() throws JSONException {
        convertnextHours();
        generateFirstDay();
        generateNextDay();
        this.isDone = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void convertnextHours() throws JSONException {
        futurHours = new ArrayList<>();
        for (int i = 0; i < nextHours.length(); i++){
            futurHours.add(new MeteoHour(nextHours.getJSONObject(i), currentTime.getZoneIdS()));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void generateFirstDay() throws JSONException {
        ArrayList<MeteoHour> hours = new ArrayList<>();
        futurHours = new ArrayList<>();
        for (int i = 0; i < nextHours.length(); i++){
            futurHours.add(new MeteoHour(nextHours.getJSONObject(i), currentTime.getZoneIdS()));
        }
        for (int i = 0; i < currentTime.getHour(); i++){
            MeteoHour hour = new MeteoHour(pastHours.getJSONObject(i), currentTime.getZoneIdS());
            hours.add(hour);
        }
        for (int i = currentTime.getHour(); i < 24; i++){
            hours.add(futurHours.get(0));
            futurHours.remove(0);
        }
        hoursPerDay.add(hours);
    }

    private void generateNextDay(){
        for(int i = 0; i < 6;i++){
            ArrayList<MeteoHour>hours = new ArrayList<>();
            for (int j = 0; j < 24; j++){
                hours.add(futurHours.get(0));
                futurHours.remove(0);
            }
            hoursPerDay.add(hours);
        }
    }

    public ArrayList<ArrayList<MeteoHour>> getHoursPerDay() {
        return hoursPerDay;
    }

    public ArrayList<MeteoHour> getFuturHours() {
        return futurHours;
    }

    public boolean isDone() {
        return isDone;
    }
}
