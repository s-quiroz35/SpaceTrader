package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Pirate;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.WeaponType;
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
    private Player player;
    private Ship ship;
    private Pirate pirate;
    private TextView playerHealth;
    private TextView pirateHealth;

    private static final int CURRENCY = 100;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pirate);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        Universe universe = viewModel.getUniverse();
        ship = viewModel.getShip();
        pirate = universe.getPirate();
        player = viewModel.getPlayer();

        playerHealth = findViewById(R.id.player_health);
        pirateHealth = findViewById(R.id.pirate_health);

        playerHealth.setText(String.format("HP: %d", ship.getHealth()));
        pirateHealth.setText(String.format("HP: %d", pirate.getHealth()));
    }

    /**
     * Damage both entities by weapon damage on press
     *
     * @param view button pressed
     */
    public void onAttackPressed(View view) {
        WeaponType playerWeapon = ship.getWeaponType();
        WeaponType pirateWeapon = pirate.getWeaponType();
        pirate.setHealth(pirate.getHealth() - playerWeapon.getWeaponDamage());
        pirateHealth.setText(String.format("HP: %d", pirate.getHealth()));
        if (pirate.getHealth() <= 0) {
            player.setCredits(player.getCredits() + CURRENCY);
            Toast toast = Toast.makeText(PirateActivity.this,
                    "+100 Credits", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            startActivity(new Intent(PirateActivity.this, PlanetActivity.class));
        }
        ship.setHealth(ship.getHealth() - pirateWeapon.getWeaponDamage());
        playerHealth.setText(String.format("HP: %d", ship.getHealth()));
        if (ship.getHealth() <= 0) {
            player.setCredits(player.getCredits() - CURRENCY);
            Toast toast = Toast.makeText(PirateActivity.this,
                    "-100 Credits", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            startActivity(new Intent(PirateActivity.this, PlanetActivity.class));
        }
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
