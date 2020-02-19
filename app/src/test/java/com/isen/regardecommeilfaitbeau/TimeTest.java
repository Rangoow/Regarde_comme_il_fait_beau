package com.isen.regardecommeilfaitbeau;

import com.isen.regardecommeilfaitbeau.typeData.Time;
import com.isen.regardecommeilfaitbeau.typeData.TimeStartDay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {
    private Time time = new Time("1581952920", "Europe/Paris");
    private TimeStartDay timeStartDay= new TimeStartDay("1581952920", "Europe/Paris");

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

    @Test
    public void testStringZero(){
        assertEquals("2020-02-17T00:00+01:00[Europe/Paris]", timeStartDay.getInternationalFormat());
    }

    @Test
    public void testYearZero(){
        assertEquals(2020, timeStartDay.getYears());
    }

    @Test
    public void testMonthZero(){
        assertEquals(2, timeStartDay.getMonth());
    }

    @Test
    public void testDayZero(){
        assertEquals(17, timeStartDay.getDay());
    }

    @Test
    public void testHourZero(){
        assertEquals(0, timeStartDay.getHour());
    }
    @Test
    public void testMinuteZero(){
        assertEquals(0, timeStartDay.getMinute());
    }

    @Test
    public void testTimestamp(){
        assertEquals(1581894000, timeStartDay.getTimetamp());
    }
}
