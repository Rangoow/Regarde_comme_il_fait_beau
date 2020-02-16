package com.isen.regardecommeilfaitbeau.api.Request.openStreetMap;

import com.isen.regardecommeilfaitbeau.api.Request.ComptementaryClass.InputStreamOperations;
import com.isen.regardecommeilfaitbeau.typeData.Position;

import java.lang.String;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;

public class PositionByCoordonate {

    private String latitudeS;
    private String longitudeS;

    private double latitude;
    private double longitude;

    private String cityName;
    private String countryName;

    private String urlS = "https://nominatim.openstreetmap.org/reverse?format=json&lat=";

    private JSONObject json;
    private FileWriter file;

    public PositionByCoordonate(Position pos){
        latitude = pos.getLatitude();
        longitude = pos.getLongitude();
        latitudeS = Double.toString(latitude);
        longitudeS = Double.toString(longitude);
    }

    public void madeUrl(){
        urlS = urlS + latitudeS + "&lon=" + longitudeS;
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
            System.out.println(result);
            json = new JSONObject(result);
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
            //System.out.println("chat");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try{
                file.flush();
                file.close();
                //System.out.println("chien");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
