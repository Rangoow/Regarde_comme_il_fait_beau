package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.JsonExample;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeteoHourTest {

    private JsonExample jsonExample;

    @Test
    public void makeObjectTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertTrue(meteoHour.isMake());
    }

    @Test
    public void timeTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(2020, meteoHour.getTime().getYears());
        assertEquals(2, meteoHour.getTime().getMonth());
        assertEquals(18, meteoHour.getTime().getDay());
        assertEquals(22, meteoHour.getTime().getHour());
        assertEquals(0, meteoHour.getTime().getMinute());
        assertEquals(0, meteoHour.getTime().getSecond());
        assertEquals("Europe/Paris", meteoHour.getTime().getZoneIdS());
    }

    @Test
    public void summaryTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals("Ciel Dégagé",meteoHour.getSummary());
    }

    @Test
    public void iconTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals("clear-night",meteoHour.getIcon());
    }

    @Test
    public void precipIntensityTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0.0094,meteoHour.getPrecipIntensity(), 0);
    }

    @Test
    public void precipProbabilityTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0.01,meteoHour.getPrecipProbability(), 0);
    }

    @Test
    public void precipTypeTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals("rain",meteoHour.getPrecipType());
    }

    @Test
    public void temperatureTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(5.4,meteoHour.getTemperature(), 0);
    }

    @Test
    public void apparentTemperatureTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(3.46,meteoHour.getApparentTemperature(), 0);
    }

    @Test
    public void dewPointTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(-0.43,meteoHour.getDewPoint(), 0);
    }

    @Test
    public void humidityTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0.66,meteoHour.getHumidity(), 0);
    }

    @Test
    public void pressureTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(1031.1,meteoHour.getPressure(),0);
    }

    @Test
    public void windSpeedTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(8.62,meteoHour.getWindSpeed(), 0);
    }

    @Test
    public void windGust() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(10.09,meteoHour.getWindGust(), 0);
    }

    @Test
    public void windBearingTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0,meteoHour.getWindBearing(),0);
    }

    @Test
    public void cloudCoverTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0,meteoHour.getCloudCover(), 0);
    }

    @Test
    public void uvIndexTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(0,meteoHour.getUvIndex(),0);
    }

    @Test
    public void visibilityTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(16.093,meteoHour.getVisibility(), 0);
    }

    @Test
    public void ozoneTest() throws JSONException {
        jsonExample = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject hourly = jsonObject.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        JSONObject firstHour = data.getJSONObject(0);
        MeteoHour meteoHour = new MeteoHour(firstHour, "Europe/Paris");
        assertEquals(317.4,meteoHour.getOzone(), 0);
    }
}
