package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Prevision;
import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.api.meteo.Currently;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;
import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PrevisionTest {

    private Prevision previsionCoordonate;
    private Prevision previsionCity;

    @Before
    public void makePrevision() throws JSONException, NumberHoursOfDayException {
        previsionCoordonate = new Prevision(50.72301, 2.73896);
        previsionCity = new Prevision("Bailleul");
    }

    @Test
    public void currentlyTest(){
        System.out.println("Test Currently");
        Currently currentlyCoordonate = previsionCoordonate.getCurrently();
        System.out.println(currentlyCoordonate.getSummary());
        System.out.println(currentlyCoordonate.getIcon());
        Currently currentlyCity = previsionCity.getCurrently();
        System.out.println(currentlyCity.getSummary());
        System.out.println(currentlyCity.getIcon());
    }

    @Test
    public void alertsTest(){
        System.out.println("Test Alerts");
        ArrayList<Alert> alertsCoordonate = previsionCoordonate.getAlerts();
        System.out.println(alertsCoordonate.size());
        if(!alertsCoordonate.isEmpty()){
            System.out.println(alertsCoordonate.get(0).getTitle());
        }
        ArrayList<Alert> alertsCity = previsionCity.getAlerts();
        System.out.println(alertsCity.size());
        if(!alertsCity.isEmpty()){
            System.out.println(alertsCity.get(0).getTitle());
        }
    }

    @Test
    public void previsionTest(){
        System.out.println("Test Previsions");
        ArrayList<MeteoDay> dailyCoordonate = previsionCoordonate.getMeteoDay();
        assertEquals(7, dailyCoordonate.size());
        for(MeteoDay i:dailyCoordonate){
            assertEquals(24, i.getHourByHour().size());
        }
        ArrayList<MeteoDay> dailyCity = previsionCity.getMeteoDay();
        assertEquals(7, dailyCity.size());
        for(MeteoDay i:dailyCity){
            assertEquals(24, i.getHourByHour().size());
        }
    }

    @Test
    public void sunsetTest(){
        System.out.println("Test Sunset");
        assertEquals(18, previsionCoordonate.getMeteoDay().get(0).getSunsetTime().getHour());
        assertEquals(18, previsionCity.getMeteoDay().get(0).getSunsetTime().getHour());
    }


    @Test
    public void sunriseTest(){
        System.out.println("Test sunrise");
        assertEquals(7, previsionCoordonate.getMeteoDay().get(0).getSunriseTime().getHour());
        assertEquals(7, previsionCoordonate.getMeteoDay().get(0).getSunriseTime().getHour());
    }
}
