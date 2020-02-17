package com.isen.regardecommeilfaitbeau.typeData;

public class Position {

    private String name;

    private String country;

    private double latitude;

    private double longitude;

    private String timeZone;

    public Position(String nameCity){
        this.name = nameCity;

    }

    public Position(double lat, double lon){
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getName() {
        return name;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double lat){
        latitude = lat;
    }

    public void setLongitude(double lon){
        longitude = lon;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
