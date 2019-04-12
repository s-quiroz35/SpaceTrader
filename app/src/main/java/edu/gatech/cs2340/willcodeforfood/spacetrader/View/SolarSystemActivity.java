package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * handles solar system views
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class SolarSystemActivity extends AppCompatActivity {

    private SolarSystem solarSystem;
    private List<Planet> planets;
    private UniverseViewModel viewModel;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_solar_system);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        solarSystem = viewModel.getCurrentSolarSystem();
        planets = solarSystem.getPlanets();

        TextView solarSystemName = findViewById(R.id.solar_system_title);
        solarSystemName.setText(solarSystem.getSolarSystemName());

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(viewModel.getFuelCapacity());
        gasBar.setProgress(viewModel.getFuelContents());

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = viewModel.getFuelContents() + "/" + viewModel.getFuelCapacity();
        gasNum.setText(num);

        TextView cPlanet = findViewById(R.id.planet_current);
        String currentPlanet = "Current Planet " + viewModel.getCurrentPlanet().getPlanetName();
        cPlanet.setText(currentPlanet);

    }

    /**
     * Returns to previous activity
     * @param view the button
     */
    public void onCancel(View view) {
        onBackPressed();
    }

    /**
     * Selects Planet One
     * @param view button pressed
     */
    public void onPlanetOne(View view) {
        viewModel.setTravelPlanet(planets.get(0));
        startActivity(new Intent(SolarSystemActivity.this, TravelPopUp.class));
    }
    /**
     * Selects Planet Two
     * @param view button pressed
     */
    public void onPlanetTwo(View view) {
        viewModel.setTravelPlanet(planets.get(1));
        startActivity(new Intent(SolarSystemActivity.this, TravelPopUp.class));
    }
    /**
     * Selects Planet Three
     * @param view button pressed
     */
    public void onPlanetThree(View view) {
        viewModel.setTravelPlanet(planets.get(2));
        startActivity(new Intent(SolarSystemActivity.this, TravelPopUp.class));
    }
}

