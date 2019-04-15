package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.TechLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles Trader activity
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class TraderActivity extends AppCompatActivity{
    private TextView credits;
    private TextView techLevel;
    private UniverseViewModel viewModel;
    private Trader trader;
    private Player player;
    private TechLevel level;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_trader);

        credits = findViewById(R.id.player_credits);

        techLevel = findViewById(R.id.trader_techLevel);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        player = viewModel.getPlayer();
        credits.setText(String.format("Currency: %d", player.getCredits()));

        level = trader.getTechLevel();

        trader = new Trader();

        techLevel.setText(String.format("TechLevel: %s (%d)", level,
                                                    level.getTechLevel()));
    }

    @Override
    public void onResume() {
        super.onResume();
        credits.setText(String.format("Currency: %d", player.getCredits()));
        techLevel.setText(String.format("TechLevel: %s (%d)", level,
                                                    level.getTechLevel()));

    }

    /**
     * Transfers to the planet activity
     *
     * @param view Button pressed
     */
    public void onCancel(View view) {
        startActivity(new Intent(TraderActivity.this, PlanetActivity.class));
    }


    /**
     * Transitions to buy screen on button press
     *
     * @param view button pressed
     */
    public void onBuyPressed(View view) {
        Intent intent = new Intent(TraderActivity.this, MarketBuyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Trader", trader);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Transitions to sell screen on button press
     *
     * @param view button pressed
     */
    public void onSellPressed(View view) {
        Intent intent = new Intent(TraderActivity.this, MarketSellActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Trader", trader);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
