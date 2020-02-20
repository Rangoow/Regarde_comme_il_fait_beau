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

    @NonNull
    @PrimaryKey
    @Embedded
    private Time start;
    @Embedded
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
        switch(this.title) {
            case "Moderate Flooding Warning":
                this.title = "Risque modéré de crues";
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

    public String getTitle() {
        return title;
    }

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
}
