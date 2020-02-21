package com.isen.regardecommeilfaitbeau.api.conversion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.meteo.Alert;
import com.isen.regardecommeilfaitbeau.typeData.Time;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ConvertionAlerts {

    private String timeZone;
    private JSONArray alertsJSON;
    private ArrayList<Alert> alerts;

    private boolean isMake;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ConvertionAlerts(JSONArray alertsJSON, Time time) throws JSONException {
        this.alertsJSON = alertsJSON;
        this.timeZone = time.getZoneIdS();
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject() throws JSONException {
        makeArray();
        isMake = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeArray() throws JSONException {
        alerts = new ArrayList<>();
        for (int i = 0; i < alertsJSON.length(); i++){
            Alert alert = new Alert(alertsJSON.getJSONObject(i), timeZone);
            alerts.add(alert);
        }
    }

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public JSONArray getAlertsJSON() {
        return alertsJSON;
    }

    public boolean isMake() {
        return isMake;
    }
}
