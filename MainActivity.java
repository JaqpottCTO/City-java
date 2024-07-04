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

        // Initialize UI elements and data
        cityInput = findViewById(R.id.cityInput);
        distanceInput = findViewById(R.id.distanceInput);
       
