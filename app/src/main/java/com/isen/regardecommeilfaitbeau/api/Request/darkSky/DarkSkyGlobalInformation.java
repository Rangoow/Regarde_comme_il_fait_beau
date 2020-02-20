package com.isen.regardecommeilfaitbeau.api.Request.darkSky;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.InputStreamOperations;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DarkSkyGlobalInformation {
    private Position position;

    private String urlS;

    private JSONObject jsonObject;

    private JSONObject currently;
    private JSONArray daily;
    private JSONArray alerts;

    public DarkSkyGlobalInformation(Position position) throws JSONException {
        this.position = position;
        makeObject();
    }

    private void makeObject() throws JSONException {
        makeUrlS();
        doRequest();
        makeJSONs();
    }

    private void makeUrlS(){
        urlS = "https://api.darksky.net/forecast/c3ee733ddd59b4b4d6abbf67c824bdab/" + position.getLatitude()
                + "," + position.getLongitude() + "?lang=fr&units=ca&exclude=hourly";
    }

    private void doRequest(){
        try {
            URL url = new URL(urlS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            jsonObject = new JSONObject(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void makeJSONs() throws JSONException {
        currently = jsonObject.getJSONObject("currently");
        JSONObject leading = currently.getJSONObject("daily");
        daily = leading.getJSONArray("data");
        if(jsonObject.has("alert")){
            alerts = jsonObject.getJSONArray("alerts");
        }
    }

    public String getUrlS() {
        return urlS;
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
}
