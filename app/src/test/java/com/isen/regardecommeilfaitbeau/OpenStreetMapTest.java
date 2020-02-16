package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCoordonate;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenStreetMapTest {
    private Position position = new Position(50.72301, 2.73896);
    private PositionByCoordonate testPositionByCoordonate = new PositionByCoordonate(position);
    @Test
    public void urlIsCorrect() {
        testPositionByCoordonate.madeUrl();
        assertEquals("https://nominatim.openstreetmap.org/reverse?format=json&lat=50.72301&lon=2.73896", testPositionByCoordonate.getUrl());
    }

    @Test
    public void canDoRequest(){
        assertTrue(testPositionByCoordonate.doRequest());
    }

    @Test
    public void exportJson() throws IOException {
        assertTrue(testPositionByCoordonate.exportJson());
    }
}
