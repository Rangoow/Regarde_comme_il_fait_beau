package com.isen.regardecommeilfaitbeau.api.conversion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;
import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;
import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ConversionDaily {

    private String timeZone;
    private JSONArray dailyJSON;
    private ArrayList<MeteoDay> daily;
    private ArrayList<ArrayList<MeteoHour>> hours;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ConversionDaily(JSONArray jsonArray, Time currentTime, ArrayList<ArrayList<MeteoHour>> hoursPerDays) throws JSONException, NumberHoursOfDayException {
        dailyJSON = jsonArray;
        this.timeZone = currentTime.getZoneIdS();
        hours =  hoursPerDays;
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject() throws JSONException, NumberHoursOfDayException {
        daily = new ArrayList<>();
        makeArray();
        isMake = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeArray() throws JSONException, NumberHoursOfDayException {
        daily = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            MeteoDay meteoDay = new MeteoDay(dailyJSON.getJSONObject(i), timeZone, hours.get(i));
            daily.add(meteoDay);
        }
    }

    public ArrayList<MeteoDay> getDaily() {
        return daily;
    }

    public boolean isMake() {
        return isMake;
    }
}
