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

public class DarkSkyFuturHour {

    private Position position;

    private String urlS;

    private JSONObject jsonObject;

    private JSONArray hourly;

    private FileWriter file;

    private boolean requestDone;

    public DarkSkyFuturHour(Position position) throws JSONException {
        this.position = position;
        makeObject();
    }

    private void makeObject() throws JSONException {
        makeUrlS();
        doRequest();
        makeJson();
    }

    private void makeUrlS(){
        urlS = "https://api.darksky.net/forecast/c3ee733ddd59b4b4d6abbf67c824bdab/" + position.getLatitude() +
                "," + position.getLongitude() +
                "?lang=fr&units=ca&extend=hourly&exclude=minutely&exclude=daily&exclude=currently";
    }

    private void doRequest(){
        try{
            URL url = new URL(urlS);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            jsonObject = new JSONObject(result);
            requestDone = true;
        }catch (Exception e){
            e.printStackTrace();
            requestDone = false;
        }
    }

    public boolean exportJson() throws IOException {
        file = new FileWriter("DarkSkyFuturHour.json");
        try{
            file.write(hourly.toString());
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

    private void makeJson() throws JSONException {
        hourly = jsonObject.getJSONObject("hourly").getJSONArray("data");
    }

    public String getUrlS() {
        return urlS;
    }

    public JSONArray getHourly() {
        return hourly;
    }

    public boolean isRequestDone() {
        return requestDone;
    }
}
