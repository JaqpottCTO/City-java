package com.example.uamcityattributeanalyzer.model;

public class City {
    private String name;
    private double latitude;
    private double longitude;
    private int population;
    private double commercialActivityIndex;
    private double tourismIndex;

    public City(String name, double latitude, double longitude, int population, double commercialActivityIndex, double tourismIndex) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.commercialActivityIndex = commercialActivityIndex;
        this.tourismIndex = tourismIndex;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getCommercialActivityIndex() {
        return commercialActivityIndex;
    }

    public void setCommercialActivityIndex(double commercialActivityIndex) {
        this.commercialActivityIndex = commercialActivityIndex;
    }

    public double getTourismIndex() {
        return tourismIndex;
    }

    public void setTourismIndex(double tourismIndex) {
        this.tourismIndex = tourismIndex;
    }
}

