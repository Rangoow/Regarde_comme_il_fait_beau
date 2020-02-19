package com.isen.regardecommeilfaitbeau.typeData;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Time {

    private String epochValue;
    private String zoneIdS;

    protected ZonedDateTime zonedDateTime;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Time(String timeValue, String timeZone){
        epochValue = timeValue;
        zoneIdS = timeZone;
        makeZonedDateTime();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeZonedDateTime(){
        long epoch = Long.parseLong(epochValue);
        //epoch = epoch/1000;
        ZoneId zoneId = ZoneId.of(zoneIdS);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(epoch, 0,
                ZoneId.of(zoneIdS).getRules().getOffset(Instant.now()));
        zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getSecond(){
        return zonedDateTime.getSecond();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getMinute(){
        return zonedDateTime.getMinute();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getHour(){
        return zonedDateTime.getHour();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getDay(){
        return zonedDateTime.getDayOfMonth();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getMonth(){
        return zonedDateTime.getMonthValue();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getYears(){
        return zonedDateTime.getYear();
    }

    public String getInternationalFormat(){
        return zonedDateTime.toString();
    }

    public String getZoneIdS(){
        return zoneIdS;
    }

}
