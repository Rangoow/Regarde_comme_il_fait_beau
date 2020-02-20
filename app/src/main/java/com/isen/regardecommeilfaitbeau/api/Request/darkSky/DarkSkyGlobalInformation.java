package com.isen.regardecommeilfaitbeau.api.Request.darkSky;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.InputStreamOperations;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
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

    private FileWriter file;
    private boolean requestDone;

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
                + "," + position.getLongitude() + "?lang=fr&units=ca&exclude=hourly&exclude=minutely";
    }

    private void doRequest(){
        try {
            URL url = new URL(urlS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            jsonObject = new JSONObject(result);
            requestDone = true;
        } catch (Exception e){
            e.printStackTrace();
            requestDone = false;
        }
    }

    private void makeJSONs() throws JSONException {
        currently = jsonObject.getJSONObject("currently");
        JSONObject leading = jsonObject.getJSONObject("daily");
        daily = leading.getJSONArray("data");
        if(jsonObject.has("alert")){
            alerts = jsonObject.getJSONArray("alerts");
        }
    }

    public boolean exportJson() throws IOException {
        file = new FileWriter("DarkSkyGlobalInformation.json");
        try{
            file.write(jsonObject.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try{
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public boolean isRequestDone() {
        return requestDone;
    }
}
