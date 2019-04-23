package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Police;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.WeaponType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles police fight activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PoliceFightActivity extends AppCompatActivity {
    private UniverseViewModel viewModel;
    private Player player;
    private Ship ship;
    private Police police;
    private TextView playerHealth;
    private TextView policeHealth;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_police_fight);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        Universe universe = viewModel.getUniverse();
        ship = viewModel.getShip();
        police = universe.getPolice();
        player = viewModel.getPlayer();

        playerHealth = findViewById(R.id.player_health);
        policeHealth = findViewById(R.id.police_health);

        playerHealth.setText(String.format("HP: %d", ship.getHealth()));
        policeHealth.setText(String.format("HP: %d", police.getHealth()));
    }

    /**
     * Damage both entities by weapon damage on press
     *
     * @param view button pressed
     */
    public void onAttackPressed(View view) {
        WeaponType playerWeapon = ship.getWeaponType();
        WeaponType policeWeapon = police.getWeaponType();
        police.setHealth(police.getHealth() - playerWeapon.getWeaponDamage());
        policeHealth.setText(String.format("HP: %d", police.getHealth()));
        if (police.getHealth() <= 0) {
            player.setHonor(player.getHonor() - 10);
            Toast toast = Toast.makeText(PoliceFightActivity.this,
                    "Wanted Level Increased!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            startActivity(new Intent(PoliceFightActivity.this,
                    WarpAnimActivity.class));
        }
        ship.setHealth(ship.getHealth() - policeWeapon.getWeaponDamage());
        playerHealth.setText(String.format("HP: %d", ship.getHealth()));
        if (ship.getHealth() <= 0) {
            player.setCredits(player.getCredits() - player.calcFine());
            Toast toast = Toast.makeText(PoliceFightActivity.this,
                    "Forced fine payment", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            startActivity(new Intent(PoliceFightActivity.this,
                    WarpAnimActivity.class));
        }
    }
}
