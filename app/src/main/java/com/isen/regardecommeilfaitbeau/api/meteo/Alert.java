package com.isen.regardecommeilfaitbeau.api.meteo;

import com.isen.regardecommeilfaitbeau.typeData.Time;

public class Alert {
    private String title;
    private String severity;

    private Time time;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getExpires() {
        return expires;
    }

    public void setExpires(Time expires) {
        this.expires = expires;
    }
}
