package com.isen.regardecommeilfaitbeau.typeData;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class TimeStartDay extends Time {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public TimeStartDay(String timeValue, String timeZone) {
        super(timeValue, timeZone);
        zonedDateTime = this.zonedDateTime.minusHours(this.getHour());
        zonedDateTime = this.zonedDateTime.minusMinutes(this.getMinute());
        zonedDateTime = this.zonedDateTime.minusSeconds(this.getSecond());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long getTimetamp(){
        return zonedDateTime.toEpochSecond();
    }

}
