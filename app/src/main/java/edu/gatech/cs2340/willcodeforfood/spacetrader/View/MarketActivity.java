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
 * Handles Market activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketActivity extends AppCompatActivity {

    private TextView credits;
    private UniverseViewModel viewModel;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market);

        credits = findViewById(R.id.player_credits);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        credits.setText(String.format("Currency: %d", viewModel.getPlayer().getCredits()));
    }

    @Override
    public void onResume() {
        super.onResume();
        credits.setText(String.format("Currency: %d", viewModel.getPlayer().getCredits()));
    }

    /**
     * Transitions to buy screen on button press
     *
     * @param view button pressed
     */
    public void onBuyPressed(View view) {
        startActivity(new Intent(MarketActivity.this, MarketBuyActivity.class));
    }

    /**
     * Transitions to sell screen on button press
     *
     * @param view button pressed
     */
    public void onSellPressed(View view) {
        startActivity(new Intent(MarketActivity.this, MarketSellActivity.class));
    }
}
