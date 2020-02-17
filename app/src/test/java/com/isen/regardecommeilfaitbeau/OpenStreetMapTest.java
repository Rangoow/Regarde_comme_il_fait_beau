package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCityName;
import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCoordonate;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenStreetMapTest {
    private Position position = new Position(50.72301, 2.73896);
    private Position positionCity = new Position("Bailleul");
    private PositionByCoordonate testPositionByCoordonate = new PositionByCoordonate(position);
    @Test
    public void endPosition() throws JSONException {
        testPositionByCoordonate.madeUrl();
        testPositionByCoordonate.doRequest();
        testPositionByCoordonate.getLocationProperties();
        testPositionByCoordonate.createPosition();
        double latitude = 50.72301;
        double longitude = 2.73896;
        assertEquals("Bailleul", testPositionByCoordonate.getPosition().getName());
        assertEquals("France", testPositionByCoordonate.getPosition().getCountry());
        assertEquals(latitude, testPositionByCoordonate.getPosition().getLatitude(), 0.0);
        assertEquals(longitude, testPositionByCoordonate.getPosition().getLongitude(), 0.0);
    }
    @Test
    public void urlIsCorrect() {
        testPositionByCoordonate.madeUrl();
        assertEquals("https://nominatim.openstreetmap.org/reverse?format=json&lat=50.72301&lon=2.73896", testPositionByCoordonate.getUrl());
    }
    @Test
    public void canDoRequest(){
        testPositionByCoordonate.madeUrl();
        assertTrue(testPositionByCoordonate.doRequest());
    }
    @Test
    public void exportJson() throws IOException {
        testPositionByCoordonate.madeUrl();
        testPositionByCoordonate.doRequest();
        assertTrue(testPositionByCoordonate.exportJson());
    }
    @Test
    public void locationProperties() throws JSONException {
        testPositionByCoordonate.madeUrl();
        testPositionByCoordonate.doRequest();
        testPositionByCoordonate.getLocationProperties();
        assertEquals("Bailleul", testPositionByCoordonate.getCityName());
        assertEquals("France", testPositionByCoordonate.getCountryName());
    }
    @Test
    public void testGlobalFunction() throws JSONException {
        PositionByCoordonate coordonatePositionFinal = new PositionByCoordonate(position);
        Position finalPosition = coordonatePositionFinal.findPositionProperties();
        assertEquals(50.72301, finalPosition.getLatitude(), 0.0);
        assertEquals(2.73896, finalPosition.getLongitude(), 0.0);
        assertEquals("Bailleul", finalPosition.getName());
        assertEquals("France", finalPosition.getCountry());
    }
    @Test
    public void urlIsCorrectCity(){
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        positionByCityName.makeUrl();
        assertEquals("https://nominatim.openstreetmap.org/search.php?format=json&addressdetails=1&extratags=1&city=Bailleul", positionByCityName.getUrlS());
    }
    @Test
    public void requestHttpCity(){
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        positionByCityName.makeUrl();
        assertTrue(positionByCityName.doRequest());
    }
    @Test
    public void exportJsonCity() throws IOException {
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        positionByCityName.makeUrl();
        positionByCityName.doRequest();
        assertTrue(positionByCityName.exportJson());
    }
    @Test
    public void findCityProperties() throws JSONException {
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        positionByCityName.makeUrl();
        positionByCityName.doRequest();
        positionByCityName.findProperties();
        assertEquals("France", positionByCityName.getCountryName());
        assertEquals(50.7396668, positionByCityName.getLatitude(), 0.0);
        assertEquals(2.7349286, positionByCityName.getLongitude(), 0.0);
    }
    @Test
    public void makePositionFinalTest() throws JSONException {
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        positionByCityName.makeUrl();
        positionByCityName.doRequest();
        positionByCityName.findProperties();
        positionByCityName.makePositionFinal();
        Position endPositionCity = positionByCityName.getCompletePosition();
        assertEquals("France", endPositionCity.getCountry());
        assertEquals("Bailleul", endPositionCity.getName());
        assertEquals(50.7396668, endPositionCity.getLatitude(), 0.0);
        assertEquals(2.7349286, endPositionCity.getLongitude(), 0.0);
    }
    @Test
    public void findPositionProperties() throws JSONException {
        PositionByCityName positionByCityName  = new PositionByCityName(positionCity);
        Position endPositionCity = positionByCityName.findPositionProperties();
        assertEquals("France", endPositionCity.getCountry());
        assertEquals("Bailleul", endPositionCity.getName());
        assertEquals(50.7396668, endPositionCity.getLatitude(), 0.0);
        assertEquals(2.7349286, endPositionCity.getLongitude(), 0.0);
    }
}
