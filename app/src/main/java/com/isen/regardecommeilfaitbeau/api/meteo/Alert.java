package com.isen.regardecommeilfaitbeau.api.meteo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONObject;

public class Alert {
    private String title;
    private String severity;

    private Time time;
    private Time start;
    private Time expires;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Alert(JSONObject jsonObject, String timeZone){
        makeObject(jsonObject, timeZone);
        traductTitle();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject(JSONObject jsonObject, String timeZone){
        try{
            title = jsonObject.getString("title");
            severity = jsonObject.getString("severity");
            start = new Time(Integer.toString(jsonObject.getInt("time")), timeZone);
            expires = new Time(Integer.toString(jsonObject.getInt("expires")), timeZone);
            isMake = true;
        }catch (Exception e){
            isMake = false;
            e.printStackTrace();
        }
    }

    private void traductTitle() {
        switch (this.title) {
            case "Moderate Flooding Warning":
                this.title = "Risque modéré d'innondations";
                break;
            case "Moderate Wind Warning":
                this.title = "Vents forts";
                break;
            case "Moderate Thunderstorm Warning":
                this.title = "Risque modéré d'orages";
            default:
                break;
        }
    }

    public String getSeverity() {
        return severity;
    }

    public Time getTime() {
        return time;
    }
    public Time getStart() {
        return start;
    }
    public Time getExpires() {
        return expires;
    }

    public boolean isMake() {
        return isMake;
    }

    public String getTitle() {
        return title;
    }
}