package com.isen.regardecommeilfaitbeau.api.Request.darkSky;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.InputStreamOperations;
import com.isen.regardecommeilfaitbeau.typeData.Position;
import com.isen.regardecommeilfaitbeau.typeData.Time;
import com.isen.regardecommeilfaitbeau.typeData.TimeStartDay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DarkSkyPastHour {

    private Position position;

    private TimeStartDay time;

    private String urlS;

    private JSONObject jsonObject;
    private JSONArray hourly;

    private boolean requestDone;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DarkSkyPastHour(Position position, TimeStartDay timeStartDay) throws JSONException {
        this.position = position;
        time = timeStartDay;
        makeObject();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeObject() throws JSONException {
        makeUrlS();
        doRequest();
        makeJson();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeUrlS(){
        urlS = "https://api.darksky.net/forecast/e0f1f6291c16dd9d522e7aed11b10bd6/" + position.getLatitude()
                + "," + position.getLongitude() + "," + time.getTimetamp() + "?lang=fr&units=ca&extend=hourly" +
                "&exclude=minutely&exclude=daily&exclude=currently";
    }

    private void doRequest(){
        try {
            URL url = new URL(urlS);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            jsonObject = new JSONObject(result);
            requestDone = true;
        }catch (Exception e){
            e.printStackTrace();
            requestDone = false;
        }
    }

    private void makeJson() throws JSONException {
        JSONObject leading = jsonObject.getJSONObject("hourly");
        hourly = leading.getJSONArray("data");
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
