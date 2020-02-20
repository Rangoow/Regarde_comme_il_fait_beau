package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.JsonExample;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoDay;
import com.isen.regardecommeilfaitbeau.api.meteo.MeteoHour;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeteoDayTest {

    private JsonExample jsonExample;

    @Test
    public void makeObjectTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertTrue(meteoDay.isMake());
    }

    @Test
    public void hourByHourTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0, meteoDay.getHourByHour().size());
    }

    @Test
    public void timeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getTime().getYears());
        assertEquals(2, meteoDay.getTime().getMonth());
        assertEquals(20, meteoDay.getTime().getDay());
        assertEquals(0, meteoDay.getTime().getHour());
        assertEquals(0, meteoDay.getTime().getMinute());
        assertEquals(0, meteoDay.getTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getTime().getZoneIdS());
    }

    @Test
    public void summaryTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals("Ciel dégagé toute la journée.", meteoDay.getSummary());
    }

    @Test
    public void iconTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals("clear-day", meteoDay.getIcon());
    }

    @Test
    public void sunriseTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getSunriseTime().getYears());
        assertEquals(2, meteoDay.getSunriseTime().getMonth());
        assertEquals(20, meteoDay.getSunriseTime().getDay());
        assertEquals(7, meteoDay.getSunriseTime().getHour());
        assertEquals(35, meteoDay.getSunriseTime().getMinute());
        assertEquals(0, meteoDay.getSunriseTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getSunriseTime().getZoneIdS());

    }

    @Test
    public void sunsetTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getSunsetTime().getYears());
        assertEquals(2, meteoDay.getSunsetTime().getMonth());
        assertEquals(20, meteoDay.getSunsetTime().getDay());
        assertEquals(18, meteoDay.getSunsetTime().getHour());
        assertEquals(15, meteoDay.getSunsetTime().getMinute());
        assertEquals(0, meteoDay.getSunsetTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getSunsetTime().getZoneIdS());
    }

    @Test
    public void moonPhaseTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.91, meteoDay.getMoonPhase(), 0.0);
    }

    @Test
    public void precipIntensityTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.0035, meteoDay.getPrecipIntensity(), 0);
    }

    @Test
    public void precipIntensityMaxTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.0105, meteoDay.getPrecipIntensityMax(), 0);
    }

    @Test
    public void precipIntensityMaxTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getPrecipIntensityMaxTime().getYears());
        assertEquals(2, meteoDay.getPrecipIntensityMaxTime().getMonth());
        assertEquals(20, meteoDay.getPrecipIntensityMaxTime().getDay());
        assertEquals(11, meteoDay.getPrecipIntensityMaxTime().getHour());
        assertEquals(0, meteoDay.getPrecipIntensityMaxTime().getMinute());
        assertEquals(0, meteoDay.getPrecipIntensityMaxTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getPrecipIntensityMaxTime().getZoneIdS());
    }

    @Test
    public void precipProbabilityTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.04, meteoDay.getPrecipProbability(), 0);
    }

    @Test
    public void precipTypeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals("rain", meteoDay.getPrecipType());
    }

    @Test
    public void temperatureMinTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.35, meteoDay.getTemperatureMin(), 0);
    }

    @Test
    public void temperatureMinTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getTemperatureMinTime().getYears());
        assertEquals(2, meteoDay.getTemperatureMinTime().getMonth());
        assertEquals(20, meteoDay.getTemperatureMinTime().getDay());
        assertEquals(6, meteoDay.getTemperatureMinTime().getHour());
        assertEquals(49, meteoDay.getTemperatureMinTime().getMinute());
        assertEquals(0, meteoDay.getTemperatureMinTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getTemperatureMinTime().getZoneIdS());
    }

    @Test
    public void temperatureMaxTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(15.74, meteoDay.getTemperatureMax(), 0);
    }

    @Test
    public void temperatureMaxTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getTemperatureMaxTime().getYears());
        assertEquals(2, meteoDay.getTemperatureMaxTime().getMonth());
        assertEquals(20, meteoDay.getTemperatureMaxTime().getDay());
        assertEquals(15, meteoDay.getTemperatureMaxTime().getHour());
        assertEquals(51, meteoDay.getTemperatureMaxTime().getMinute());
        assertEquals(0, meteoDay.getTemperatureMaxTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getTemperatureMaxTime().getZoneIdS());
    }

    @Test
    public void apparentTemperatureMinTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(-1.05, meteoDay.getApparentTemperatureMin(), 0);
    }

    @Test
    public void apparentTemperatureMinTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getApparentTemperatureMinTime().getYears());
        assertEquals(2, meteoDay.getApparentTemperatureMinTime().getMonth());
        assertEquals(20, meteoDay.getApparentTemperatureMinTime().getDay());
        assertEquals(6, meteoDay.getApparentTemperatureMinTime().getHour());
        assertEquals(35, meteoDay.getApparentTemperatureMinTime().getMinute());
        assertEquals(0, meteoDay.getApparentTemperatureMinTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getApparentTemperatureMinTime().getZoneIdS());
    }

    @Test
    public void apparentTemperatureMaxTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.0105, meteoDay.getPrecipIntensityMax(), 0);
    }

    @Test
    public void apparentTemperatureMaxTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getApparentTemperatureMaxTime().getYears());
        assertEquals(2, meteoDay.getApparentTemperatureMaxTime().getMonth());
        assertEquals(20, meteoDay.getApparentTemperatureMaxTime().getDay());
        assertEquals(15, meteoDay.getApparentTemperatureMaxTime().getHour());
        assertEquals(51, meteoDay.getApparentTemperatureMaxTime().getMinute());
        assertEquals(0, meteoDay.getApparentTemperatureMaxTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getApparentTemperatureMaxTime().getZoneIdS());
    }

    @Test
    public void dewPointTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(1.85, meteoDay.getDewPoint(), 0);
    }

    @Test
    public void humidityTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.72, meteoDay.getHumidity(), 0);
    }

    @Test
    public void pressureTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(1025.8, meteoDay.getPressure(), 0);
    }

    @Test
    public void windSpeedTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(7.66, meteoDay.getWindSpeed(), 0);
    }

    @Test
    public void windGustTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(25.82, meteoDay.getWindGust(), 0);
    }

    @Test
    public void windGustTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getWindGustTime().getYears());
        assertEquals(2, meteoDay.getWindGustTime().getMonth());
        assertEquals(20, meteoDay.getWindGustTime().getDay());
        assertEquals(16, meteoDay.getWindGustTime().getHour());
        assertEquals(24, meteoDay.getWindGustTime().getMinute());
        assertEquals(0, meteoDay.getWindGustTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getWindGustTime().getZoneIdS());
    }

    @Test
    public void windBearingTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(195.0, meteoDay.getWindBearing(), 0);
    }

    @Test
    public void cloudCoverTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(0.19, meteoDay.getCloudCover(), 0);
    }

    @Test
    public void uvIndexTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(3.0, meteoDay.getUvIndex(),0);
    }

    @Test
    public void uvIndexTimeTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(2020, meteoDay.getUvIndexTime().getYears());
        assertEquals(2, meteoDay.getUvIndexTime().getMonth());
        assertEquals(20, meteoDay.getUvIndexTime().getDay());
        assertEquals(13, meteoDay.getUvIndexTime().getHour());
        assertEquals(0, meteoDay.getUvIndexTime().getMinute());
        assertEquals(0, meteoDay.getUvIndexTime().getSecond());
        assertEquals("Europe/Paris", meteoDay.getUvIndexTime().getZoneIdS());
    }

    @Test
    public void visibilityTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(16.093, meteoDay.getVisibility(), 0);
    }

    @Test
    public void ozoneTest() throws JSONException {
        jsonExample  = new JsonExample();
        JSONObject jsonObject = jsonExample.getJsonObject();
        JSONObject daily = jsonObject.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        JSONObject firstDay = data.getJSONObject(0);
        ArrayList<MeteoHour> hours = new ArrayList<>();
        MeteoDay meteoDay = new MeteoDay(firstDay, "Europe/Paris",hours);
        assertEquals(314.2, meteoDay.getOzone(), 0);
    }

}
