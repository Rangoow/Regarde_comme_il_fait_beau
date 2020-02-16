package com.isen.regardecommeilfaitbeau.typeData;

public class Position {

    private String name;

    private String region;

    private String department;

    private String country;

    private double latitude;

    private double longitude;

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
}
