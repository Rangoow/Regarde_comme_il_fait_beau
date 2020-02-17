package com.isen.regardecommeilfaitbeau.api.Request.openStreetMap;

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

public class PositionByCityName {
    private String cityName;
    private String countryName;
    private String timeZone;

    private String latitudeS;
    private String longitudeS;

    private double latitude;
    private double longitude;

    private String urlS = "https://nominatim.openstreetmap.org/search.php?format=json&addressdetails=1&extratags=1&city=";
    private String urlSSTime = "http://api.timezonedb.com/v2.1/get-time-zone?key=F10IKI69VB1W&format=json&by=position&lat=";

    private JSONObject json;
    private JSONObject jsonTime;
    private FileWriter file;

    private Position completePosition;

    public PositionByCityName(Position pos){
        cityName = pos.getName();
    }

    public void makeUrl(){
        urlS = urlS + cityName;
    }

    public void makeUrlTime(){
        urlSSTime = urlSSTime + latitudeS + "&lng=" + longitudeS;
    }

    public boolean doRequest(){
        try{
            URL url = new URL(urlS);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            String result = InputStreamOperations.InputStreamToString(inputStream);
            JSONArray jsonArray = new JSONArray(result);
            json = jsonArray.getJSONObject(0);  //First city found;
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean findDateTime(){
        try{
            makeUrlTime();
            URL urlTime = new URL(urlSSTime);
            HttpURLConnection urlConnectionTime = (HttpURLConnection) urlTime.openConnection();
            urlConnectionTime.connect();
            InputStream inputStreamTime = urlConnectionTime.getInputStream();
            String resultTime = InputStreamOperations.InputStreamToString(inputStreamTime);
            jsonTime = new JSONObject(resultTime);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean exportJson() throws IOException {
        file = new FileWriter("searchByCityName.json");
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

    public void findProperties() throws JSONException {
        latitudeS = json.getString("lat");
        longitudeS = json.getString("lon");
        latitude = Double.valueOf(latitudeS);
        longitude = Double.valueOf(longitudeS);
        JSONObject address = json.getJSONObject("address");
        countryName = address.getString("country");
        timeZone = jsonTime.getString("zoneName");
    }

    public void makePositionFinal(){
        completePosition = new Position(cityName);
        completePosition.setLatitude(latitude);
        completePosition.setLongitude(longitude);
        completePosition.setCountry(countryName);
        completePosition.setTimeZone(timeZone);
    }

    public Position findPositionProperties() throws JSONException {
        makeUrl();
        doRequest();
        findDateTime();
        findProperties();
        makePositionFinal();
        return completePosition;
    }

    public Position getCompletePosition(){
        return completePosition;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getUrlS() {
        return urlS;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
