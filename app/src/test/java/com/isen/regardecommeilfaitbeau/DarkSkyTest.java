package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyFuturHour;
import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyGlobalInformation;
import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyPastHour;
import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCoordonate;
import com.isen.regardecommeilfaitbeau.typeData.Position;
import com.isen.regardecommeilfaitbeau.typeData.TimeStartDay;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DarkSkyTest {
    private DarkSkyGlobalInformation globalInformation;
    private DarkSkyFuturHour futurHour;
    private DarkSkyPastHour pastHour;

    @Before
    public void makeGlobalInformationTest() throws JSONException {
        Position position = new Position(50.72301, 2.73896);
        PositionByCoordonate positionByCoordonate = new PositionByCoordonate(position);
        Position endPosition = positionByCoordonate.findPositionProperties();
        globalInformation = new DarkSkyGlobalInformation(endPosition);
    }

    @Before
    public void makeFuturHourTest() throws JSONException {
        Position position = new Position(50.72301, 2.73896);
        PositionByCoordonate positionByCoordonate = new PositionByCoordonate(position);
        Position endPosition = positionByCoordonate.findPositionProperties();
        futurHour = new DarkSkyFuturHour(endPosition);
    }

    @Before
    public void makePastHourTest() throws JSONException {
        TimeStartDay timeStartDay = new TimeStartDay("1582236147", "Europe/Paris");
        Position position = new Position(50.72301, 2.73896);
        PositionByCoordonate positionByCoordonate = new PositionByCoordonate(position);
        Position endPosition = positionByCoordonate.findPositionProperties();
        pastHour = new DarkSkyPastHour(endPosition, timeStartDay);
    }

    @Test
    public void makeUrlGlobalTest() {
        assertEquals("https://api.darksky.net/forecast/c3ee733ddd59b4b4d6abbf67c824bdab/" +
                "50.72301,2.73896?lang=fr&units=ca&exclude=hourly&exclude=minutely", globalInformation.getUrlS());
    }

    @Test
    public void doRequestGlobalTest() {
        assertTrue(globalInformation.isRequestDone());
    }

    @Test
    public void currentlyGlobalTest(){
        assertNotNull(globalInformation.getCurrently());
    }

    @Test
    public void dailyGlobalTest(){
        assertNotNull(globalInformation.getDaily());
    }

    @Test
    public void makeUrlFuturTest() {
        assertEquals("https://api.darksky.net/forecast/c3ee733ddd59b4b4d6abbf67c824bdab" +
                "/50.72301,2.73896?lang=fr&units=ca&extend=hourly&exclude=minutely&exclude=daily" +
                "&exclude=currently", futurHour.getUrlS());
    }

    @Test
    public void doRequestFuturTest() {
        assertTrue(futurHour.isRequestDone());
    }

    @Test
    public void hourlyFuturTest(){
        assertNotNull(futurHour.getHourly());
    }

    @Test
    public void makeUrlPastTest(){
        assertEquals("https://api.darksky.net/forecast/e0f1f6291c16dd9d522e7aed11b10bd6" +
                "/50.72301,2.73896,1582153200?lang=fr&units=ca&extend=hourly&exclude=minutely" +
                "&exclude=daily&exclude=currently", pastHour.getUrlS());
    }

    @Test
    public void doRequestPastTest(){
        assertTrue(pastHour.isRequestDone());
    }

    @Test
    public void hourlyPastTest() throws JSONException {
        assertNotNull(pastHour.getHourly());
        assertEquals(1582153200, pastHour.getHourly().getJSONObject(0).getInt("time"));
    }

}
