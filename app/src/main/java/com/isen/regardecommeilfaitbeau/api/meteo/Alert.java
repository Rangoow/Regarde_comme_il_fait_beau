package com.isen.regardecommeilfaitbeau.api.meteo;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.isen.regardecommeilfaitbeau.typeData.Time;

@Entity
public class Alert {
    private String title;
    private String severity;

    @NonNull @PrimaryKey @Embedded
    private Time time;
    @Embedded
    private Time expires;

    private void traductTitle() {
        switch(this.title) {
            case "Moderate Flooding Warning":
                this.title = "Risque modéré de crues";
                break;
            case "Moderate Wind Warning":
                this.title = "Vents forts";
                break;
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

    public Time getTime() {
        return time;
    }

    public Time getExpires() {
        return expires;
    }
}
