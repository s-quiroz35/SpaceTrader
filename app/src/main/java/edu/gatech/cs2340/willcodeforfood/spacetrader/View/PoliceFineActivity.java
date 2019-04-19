package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles data for initial police interaction
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PoliceFineActivity extends AppCompatActivity {

    private UniverseViewModel viewModel;
    private Player player;

    private TextView fineMessage;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_police_fine);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        player = viewModel.getPlayer();

        fineMessage = findViewById(R.id.fine_message);
        fineMessage.setText(String.format("Wanted level: %d, You must pay: %d",
                player.getWantedLevel(), player.calcFine()));
    }

    /**
     * Pay fine and continue to planet on button press
     *
     * @param view button pressed
     */
    public void onPayPressed(View view) {
        player.setCredits(player.getCredits() - player.calcFine());
        player.setWantedLevel(0);
        startActivity(new Intent(this, PlanetActivity.class));
    }

    /**
     * On refusal, battle police officer
     *
     * @param view button pressed
     */
    public void onRefusePressed(View view) {
        viewModel.getUniverse().createPolice();
        startActivity(new Intent(this, PoliceFightActivity.class));
    }
}
