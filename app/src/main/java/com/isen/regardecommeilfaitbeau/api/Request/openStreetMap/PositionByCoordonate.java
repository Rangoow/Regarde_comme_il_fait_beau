package com.isen.regardecommeilfaitbeau.api.Request.openStreetMap;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.InputStreamOperations;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import java.lang.String;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PositionByCoordonate {

    private String latitudeS;
    private String longitudeS;

    private double latitude;
    private double longitude;

    private String cityName;
    private String countryName;
    private String timeZone;

    private String urlS = "https://nominatim.openstreetmap.org/reverse?format=json&lat=";
    private String urlSSTime = "http://api.timezonedb.com/v2.1/get-time-zone?key=F10IKI69VB1W&format=json&by=position&lat=";

    private JSONObject json;
    private JSONObject jsonTime;
    private FileWriter file;

    private Position completePosition;

    public PositionByCoordonate(Position pos){
        latitude = pos.getLatitude();
        longitude = pos.getLongitude();
        latitudeS = Double.toString(latitude);
        longitudeS = Double.toString(longitude);
    }

    public Position findPositionProperties() throws JSONException {
        madeUrl();
        doRequest();
        getLocationProperties();
        createPosition();
        return completePosition;
    }

    public void madeUrl(){
        urlS = urlS + latitudeS + "&lon=" + longitudeS;
        urlSSTime = urlSSTime + latitudeS + "&lng=" + longitudeS;
    }

    public String getUrl(){
        return urlS;
    }

    public boolean doRequest() {
        try{
            URL osm = new URL(urlS);
            HttpURLConnection connection = (HttpURLConnection) osm.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            json = new JSONObject(result);

            URL urlTime = new URL(urlSSTime);
            HttpURLConnection connectionTime = (HttpURLConnection) urlTime.openConnection();
            //connection.setConnectTimeout(5000); // 5s
            //connection.setReadTimeout(5000);
            connectionTime.connect();
            InputStream inputStreamTime = connectionTime.getInputStream();
            String resultTime = InputStreamOperations.InputStreamToString(inputStreamTime);
            jsonTime = new JSONObject(resultTime);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportJson() throws IOException {
        file = new FileWriter("searchByCoordonate.json");
        try{
            file.write(json.toString());
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

    public void getLocationProperties() throws JSONException {
        JSONObject adress = json.getJSONObject("address");
        if(adress.has("city")){
            cityName = adress.getString("city");
        }else if(adress.has("town")){
            cityName = adress.getString("town");
        }
        timeZone = jsonTime.getString("zoneName");
        countryName = adress.getString("country");
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void createPosition(){
        completePosition = new Position(latitude, longitude);
        completePosition.setName(cityName);
        completePosition.setCountry(countryName);
        completePosition.setTimeZone(timeZone);
    }

    public Position getPosition(){
        return completePosition;
    }

    public String getUrlSSTime() {
        return urlSSTime;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
