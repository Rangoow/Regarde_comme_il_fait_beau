package com.isen.regardecommeilfaitbeau.api.conversion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ConversionDaily {

    private String timeZone;
    private JSONArray dailyJSON;
    private ArrayList<MeteoDay> daily;
    private ArrayList<MeteoHour> hours;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeArray() throws JSONException {
        daily = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            //MeteoDay meteoDay = new MeteoDay(dailyJSON.getJSONObject(i), timeZone, hours);
        }
    }

}
