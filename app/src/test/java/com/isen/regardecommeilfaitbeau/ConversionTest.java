package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.JsonExample;
import com.isen.regardecommeilfaitbeau.api.conversion.ConversionDaily;
import com.isen.regardecommeilfaitbeau.api.conversion.ConversionHourly;
import com.isen.regardecommeilfaitbeau.api.conversion.ConvertionAlerts;
import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;
import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;
import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConversionTest {

    private JSONArray nextHour;
    private JSONArray pastHour;
    private JSONArray nexDays;
    private JSONArray alertJson;
    private JSONObject jsonObject;

    private ArrayList<ArrayList<MeteoHour>> allHours;
    private ArrayList<MeteoDay> allDays;
    private ArrayList<Alert> alerts;

    private JsonExample jsonExample;

    private ConversionHourly hourly;
    private ConversionDaily daily;
    private ConvertionAlerts alert;

    @Before
    public void makeTest() throws JSONException, NumberHoursOfDayException {
        Time time = new Time("1582187333", "Europe/Paris");
        jsonExample = new JsonExample();
        jsonObject = jsonExample.getJsonObject();
        pastHour = jsonExample.getJsonObjectFisrtHourly().getJSONObject("hourly").getJSONArray("data");
        nextHour = jsonExample.getJsonObjectHourly().getJSONObject("hourly").getJSONArray("data");
        hourly = new ConversionHourly(nextHour, pastHour, time);
        allHours = hourly.getHoursPerDay();
        nexDays = jsonObject.getJSONObject("daily").getJSONArray("data");
        daily = new ConversionDaily(nexDays, time, allHours);
        allDays = daily.getDaily();
        alertJson = jsonExample.getJsonObjectHourly().getJSONArray("alerts");
        alert = new ConvertionAlerts(alertJson, time);
    }

    @Test
    public void hourlyIsMake(){
        assertTrue(hourly.isDone());
    }

    @Test
    public void generateFisrtDay(){
        assertEquals(24, allHours.get(0).size());
    }

    @Test
    public void generateAllDays(){
        assertEquals(7, allHours.size());
    }

    @Test
    public void numberHoursPerDayIsCorrect(){
        assertEquals(24, allHours.get(1).size());
        assertEquals(24, allHours.get(2).size());
        assertEquals(24, allHours.get(3).size());
        assertEquals(24, allHours.get(4).size());
        assertEquals(24, allHours.get(5).size());
        assertEquals(24, allHours.get(6).size());
    }

    @Test
    public void dailyIsMake(){
        assertTrue(daily.isMake());
    }

    @Test
    public void numberDays(){
        assertEquals(7, daily.getDaily().size());
    }

    @Test
    public void alertIsMake(){
        assertTrue(alert.isMake());
    }

    @Test
    public void alertArrayTest(){
        assertEquals(2, alert.getAlerts().size());
    }

}
