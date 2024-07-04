package com.example.uamcityattributeanalyzer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uamcityattributeanalyzer.model.City;
import com.example.uamcityattributeanalyzer.model.Vertiport;
import com.example.uamcityattributeanalyzer.service.CityAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText cityInput;
    private EditText distanceInput;
    private Button analyzeButton;
    private TextView resultsView;
    private List<City> cities;
    private CityAnalyzer cityAnalyzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        cityInput = findViewById(R.id.cityInput);
        distanceInput = findViewById(R.id.distanceInput);
        analyzeButton = findViewById(R.id.analyzeButton);
        resultsView = findViewById(R.id.resultsView);

        // Initialize city data
        cities = initializeCities();
        cityAnalyzer = new CityAnalyzer(cities);

        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityInput.getText().toString();
                double distance = Double.parseDouble(distanceInput.getText().toString());
                Vertiport vertiport = getVertiport(cityName);
                List<City> nearbyCities = cityAnalyzer.findCitiesWithinDistance(vertiport, distance);
                displayResults(nearbyCities);
            }
        });
    }

    private List<City> initializeCities() {
        // Initialize the list of cities with their attributes
        List<City> cities = new ArrayList<>();
        cities.add(new City("Dallas", 32.7767, -96.7970, 1350000, 9.5, 8.7));
        cities.add(new City("Fort Worth", 32.7555, -97.3308, 935000, 8.9, 8.3));
        cities.add(new City("Arlington", 32.7357, -97.1081, 400000, 7.8, 7.2));
        // Add more cities as needed
        return cities;
    }

    private Vertiport getVertiport(String cityName) {
        // Return the vertiport for the given city name
        if (cityName.equalsIgnoreCase("Lancaster")) {
            return new Vertiport("Lancaster", 32.5921, -96.7561);
        }
        // Add more cases for other cities if necessary
        return new Vertiport(cityName, 0, 0); // Default case
    }

    private void displayResults(List<City> nearbyCities) {
        StringBuilder results = new StringBuilder();
        for (City city : nearbyCities) {
            results.append("City: ").append(city.getName())
                    .append("\nPopulation: ").append(city.getPopulation())
                    .append("\nCommercial Activity Index: ").append(city.getCommercialActivityIndex())
                    .append("\nTourism Index: ").append(city.getTourismIndex())
                    .append("\n\n");
        }
        resultsView.setText(results.toString());
    }
}
