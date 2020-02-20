package com.isen.regardecommeilfaitbeau.api.conversion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.meteo.Alert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConvertionAlerts {

    private String timeZone;
    private JSONArray alertsJSON;
    private ArrayList<Alert> alerts;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ConvertionAlerts(JSONArray alertsJSON, String timeZone) throws JSONException {
        this.alertsJSON = alertsJSON;
        this.timeZone = timeZone;
        makeArray();
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
}
