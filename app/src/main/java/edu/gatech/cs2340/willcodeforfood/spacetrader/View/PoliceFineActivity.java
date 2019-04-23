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

    //This activity will only activate if player wanted level is greater than 0 in future
    private UniverseViewModel viewModel;
    private Player player;

    private TextView wantedMessage;
    private TextView fineMessage;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_police_fine);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        player = viewModel.getPlayer();

        wantedMessage = findViewById(R.id.wanted_message);
        fineMessage = findViewById(R.id.fine_message);
        wantedMessage.setText(String.format("Wanted level: %d", player.getHonor()));
        fineMessage.setText(String.format("Fine: %d", player.calcFine()));
    }

    /**
     * Pay fine and continue to planet on button press
     *
     * @param view button pressed
     */
    public void onPayPressed(View view) {
        player.setCredits(player.getCredits() - player.calcFine());
        player.setHonor(0);
        startActivity(new Intent(this, WarpAnimActivity.class));
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
