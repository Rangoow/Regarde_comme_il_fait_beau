package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.Request;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RequestTest {

    private Request requestCoordonate;
    private Request requestCity;

    @Before
    public void makeTestCoordonate() throws JSONException {
        requestCoordonate = new Request(50.72301, 2.73896);
        requestCity = new Request("Bailleul");
    }

    @Test
    public void isMakeCoordonate(){
        assertTrue(requestCoordonate.isDone());
    }

    @Test
    public void positionTestCoordonate(){
        Position position = requestCoordonate.getPosition();
        assertEquals("Bailleul", position.getName());
        assertEquals("France", position.getCountry());
        assertEquals(50.72301, position.getLatitude(), 0.0);
        assertEquals(2.73896, position.getLongitude(), 0.0);
        assertEquals("Europe/Paris", position.getTimeZone());
    }

    @Test
    public void actualTimeTestCoordonate(){
        assertNotNull(requestCoordonate.getActualTime());
    }

    @Test
    public void currentlyTestCoordonate(){
        assertNotNull(requestCoordonate.getCurrently());
    }

    @Test
    public void dailyTestCoordonate(){
        assertNotNull(requestCoordonate.getDaily());
    }

    @Test
    public void alertTestCoordonate(){
        assertNull(requestCoordonate.getAlerts());
    }

    @Test
    public void pastHourTestCoordonate(){
        assertNotNull(requestCoordonate.getPastHours());
    }

    @Test
    public void futurHourTestCoordonate(){
        assertNotNull(requestCoordonate.getFuturHours());
    }

    @Test
    public void isMakeCity(){
        assertTrue(requestCity.isDone());
    }

    @Test
    public void positionTestCity(){
        Position position = requestCity.getPosition();
        assertEquals("Bailleul", position.getName());
        assertEquals("France", position.getCountry());
        assertEquals(50.7396668, position.getLatitude(), 0.0);
        assertEquals(2.7349286, position.getLongitude(), 0.0);
        assertEquals("Europe/Paris", position.getTimeZone());
    }

    @Test
    public void actualTimeTestCity(){
        assertNotNull(requestCity.getActualTime());
    }

    @Test
    public void currentlyTestCity(){
        assertNotNull(requestCity.getCurrently());
    }

    @Test
    public void dailyTestCity(){
        assertNotNull(requestCity.getDaily());
    }

    @Test
    public void alertTestCity(){
        assertNull(requestCity.getAlerts());
    }

    @Test
    public void pastHourCity(){
        assertNotNull(requestCity.getPastHours());
    }

    @Test
    public void futurHourCity(){
        assertNotNull(requestCity.getFuturHours());
    }

}
