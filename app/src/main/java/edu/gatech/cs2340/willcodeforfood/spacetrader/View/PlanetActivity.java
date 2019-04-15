package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles Planet activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class PlanetActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_planet);

        UniverseViewModel viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        Planet currPlanet = viewModel.getCurrentPlanet();

        TextView planetName = findViewById(R.id.planet_name);
        planetName.setText(currPlanet.getPlanetName());
    }

    /**
     * Transitions to market on button press
     *
     * @param view button pressed
     */
    public void onMarketPressed(View view) {
        startActivity(new Intent(PlanetActivity.this, MarketActivity.class));
    }

    /**
     * Travel is pressed and the player is directed to the travel screen
     * @param view a button
     */
    public void onTravelPressed(View view) {
        startActivity(new Intent(PlanetActivity.this, UniverseActivity.class));
    }
}
