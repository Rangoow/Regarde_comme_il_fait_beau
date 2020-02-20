package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.JsonExample;
import com.isen.regardecommeilfaitbeau.api.meteo.Alert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlertTest {
    private JsonExample jsonExample;

    @Test
    public void makeObjectTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject= jsonExample.getJsonObjectHourly();
        JSONArray alertJson = jsonObject.getJSONArray("alerts");
        JSONObject example = alertJson.getJSONObject(0);
        Alert alert = new Alert(example, "Europe/Paris");
        assertTrue(alert.isMake());
    }

    @Test
    public void titleTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject= jsonExample.getJsonObjectHourly();
        JSONArray alertJson = jsonObject.getJSONArray("alerts");
        JSONObject example = alertJson.getJSONObject(0);
        Alert alert = new Alert(example, "Europe/Paris");
        assertEquals("Risque modéré de crues", alert.getTitle());
    }

    @Test
    public void severityTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject= jsonExample.getJsonObjectHourly();
        JSONArray alertJson = jsonObject.getJSONArray("alerts");
        JSONObject example = alertJson.getJSONObject(0);
        Alert alert = new Alert(example, "Europe/Paris");
        assertEquals("warning", alert.getSeverity());
    }

    @Test
    public void startTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject= jsonExample.getJsonObjectHourly();
        JSONArray alertJson = jsonObject.getJSONArray("alerts");
        JSONObject example = alertJson.getJSONObject(0);
        Alert alert = new Alert(example, "Europe/Paris");
        assertEquals(2020, alert.getStart().getYears());
        assertEquals(2, alert.getStart().getMonth());
        assertEquals(20, alert.getStart().getDay());
        assertEquals(6, alert.getStart().getHour());
        assertEquals(0, alert.getStart().getMinute());
        assertEquals(0, alert.getStart().getSecond());
        assertEquals("Europe/Paris", alert.getStart().getZoneIdS());
    }

    @Test
    public void expiresTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject= jsonExample.getJsonObjectHourly();
        JSONArray alertJson = jsonObject.getJSONArray("alerts");
        JSONObject example = alertJson.getJSONObject(0);
        Alert alert = new Alert(example, "Europe/Paris");
        assertEquals(2020, alert.getExpires().getYears());
        assertEquals(2, alert.getExpires().getMonth());
        assertEquals(21, alert.getExpires().getDay());
        assertEquals(6, alert.getExpires().getHour());
        assertEquals(0, alert.getExpires().getMinute());
        assertEquals(0, alert.getExpires().getSecond());
        assertEquals("Europe/Paris", alert.getExpires().getZoneIdS());
    }
}
