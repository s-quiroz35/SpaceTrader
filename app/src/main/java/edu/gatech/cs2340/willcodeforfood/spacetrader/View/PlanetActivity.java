package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles Planet activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PlanetActivity extends AppCompatActivity {

    private TextView planetName;
    private UniverseViewModel viewModel;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_planet);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        planetName = findViewById(R.id.planet_name);
        planetName.setText(viewModel.getCurrentPlanet().getPlanetName());
    }

    /**
     * Transitions to market on button press
     *
     * @param view button pressed
     */
    public void onMarketPressed(View view) {
        startActivity(new Intent(PlanetActivity.this, MarketActivity.class));
    }
}
