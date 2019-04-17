package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Pirate;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles pirate fight activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PirateActivity extends AppCompatActivity {

    private UniverseViewModel viewModel;
    private Universe universe;
    private Ship ship;
    private Pirate pirate;
    private ImageView playerIcon;
    private ImageView pirateIcon;
    private TextView playerHealth;
    private TextView pirateHealth;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pirate);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        universe = viewModel.getUniverse();
        ship = viewModel.getShip();
        pirate = universe.getPirate();

        playerHealth = findViewById(R.id.player_health);
        pirateHealth = findViewById(R.id.pirate_health);
        playerIcon = findViewById(R.id.player_ship);
        pirateIcon = findViewById(R.id.pirate_ship);

        playerHealth.setText(ship.getHealth());
        pirateHealth.setText(pirate.getHealth());
    }

    /**
     * Return to planet previously traveling to on button press
     *
     * @param view button pressed
     */
    public void onFleePressed(View view) {
        startActivity(new Intent(PirateActivity.this, PlanetActivity.class));
    }
}
