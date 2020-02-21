package com.isen.regardecommeilfaitbeau.api.meteo;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONObject;

@Entity
public class Alert {
    private String title;
    private String severity;

    @NonNull @PrimaryKey() @Embedded(prefix = "start")
    private Time start;
    @Embedded(prefix = "expires")
    private Time expires;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Alert(JSONObject jsonObject, String timeZone){
        makeObject(jsonObject, timeZone);
        traductTitle();
    }

    public Alert(String title, String severity, @NonNull Time start, Time expires, boolean isMake) {
        this.title = title;
        this.severity = severity;
        this.start = start;
        this.expires = expires;
        this.isMake = isMake;
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
                break;
            case "Moderate Snow-ice Warning":
                this.title = "Risque de chute modéré de neige";
                break;
            default:
                break;
        }
    }

    // Getters

    public String getSeverity() {
        return severity;
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

    // Setters


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setStart(@NonNull Time start) {
        this.start = start;
    }

    public void setExpires(Time expires) {
        this.expires = expires;
    }

    public void setMake(boolean make) {
        isMake = make;
    }
}