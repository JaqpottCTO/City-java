package com.example.uamcityattributeanalyzer.service;

import com.example.uamcityattributeanalyzer.model.City;
import com.example.uamcityattributeanalyzer.model.Vertiport;
import com.example.uamcityattributeanalyzer.util.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class CityAnalyzer {
    private List<City> cities;

    public CityAnalyzer(List<City> cities) {
        this.cities = cities;
    }

    public List<City> findCitiesWithinDistance(Vertiport vertiport, double distance) {
        List<City> nearbyCities = new ArrayList<>();
        for (City city : cities) {
            double calculatedDistance = DistanceCalculator.calculateDistance(
                    vertiport.getLatitude(), vertiport.getLongitude(),
                    city.getLatitude(), city.getLongitude());
            if (calculatedDistance <= distance) {
                nearbyCities.add(city);
            }
        }
        return nearbyCities;
    }
}
