package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {
    private Time time = new Time("1581952920");

    @Test
    public void testString(){
        assertEquals("2020-02-17T16:22+01:00[Europe/Paris]", time.getInternationalFormat());
    }

    @Test
    public void testYear(){
        assertEquals(2020, time.getYears());
    }

    @Test
    public void testMonth(){
        assertEquals(2, time.getMonth());
    }

    @Test
    public void testDay(){
        assertEquals(17, time.getDay());
    }

    @Test
    public void testHour(){
        assertEquals(16, time.getHour());
    }
    @Test
    public void testMinute(){
        assertEquals(22, time.getMinute());
    }
}
