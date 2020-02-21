package com.isen.regardecommeilfaitbeau.api.Request;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyFuturHour;
import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyGlobalInformation;
import com.isen.regardecommeilfaitbeau.api.Request.darkSky.DarkSkyPastHour;
import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCityName;
import com.isen.regardecommeilfaitbeau.api.Request.openStreetMap.PositionByCoordonate;
import com.isen.regardecommeilfaitbeau.typeData.Position;
import com.isen.regardecommeilfaitbeau.typeData.Time;
import com.isen.regardecommeilfaitbeau.typeData.TimeStartDay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {

    private Position position;
    private Time actualTime;
    private TimeStartDay timeStartDay;
    private JSONObject currently;
    private JSONArray daily;
    private JSONArray alerts;
    private JSONArray pastHours;
    private JSONArray futurHours;

    private boolean isDone;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Request(String cityName) throws JSONException {
        Position initialPosistion = new Position(cityName);
        PositionByCityName positionByCityName = new PositionByCityName(initialPosistion);
        position = positionByCityName.findPositionProperties();
        makeGlobalInformation();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Request(double latitude, double longitude) throws JSONException {
        Position initialPosition = new Position(latitude, longitude);
        PositionByCoordonate positionByCoordonate = new PositionByCoordonate(initialPosition);
        position = positionByCoordonate.findPositionProperties();
        makeGlobalInformation();
    }

    public Position getPosition() {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeGlobalInformation() throws JSONException {
        DarkSkyGlobalInformation globalInformation = new DarkSkyGlobalInformation(position);
        currently = globalInformation.getCurrently();
        daily = globalInformation.getDaily();
        if(globalInformation.getAlerts() != null){
            alerts = globalInformation.getAlerts();
        }
        actualTime = new Time(Integer.toString(currently.getInt("time")), position.getTimeZone());
        timeStartDay = new TimeStartDay(Integer.toString(currently.getInt("time")), position.getTimeZone());
        DarkSkyPastHour darkSkyPastHour = new DarkSkyPastHour(position, timeStartDay);
        pastHours = darkSkyPastHour.getHourly();
        DarkSkyFuturHour darkSkyFuturHour = new DarkSkyFuturHour(position);
        futurHours = darkSkyFuturHour.getHourly();
        isDone = true;
    }

    public Time getActualTime() {
        return actualTime;
    }

    public JSONObject getCurrently() {
        return currently;
    }

    public JSONArray getDaily() {
        return daily;
    }

    public JSONArray getAlerts() {
        return alerts;
    }

    public JSONArray getPastHours() {
        return pastHours;
    }

    public JSONArray getFuturHours() {
        return futurHours;
    }

    public boolean isDone() {
        return isDone;
    }
}
