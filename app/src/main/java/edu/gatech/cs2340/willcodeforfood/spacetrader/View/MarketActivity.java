package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles Market activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class MarketActivity extends AppCompatActivity {

    private Player player;
    private TextView credits;
    private UniverseViewModel viewModel;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market);

        credits = findViewById(R.id.player_credits);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        player = viewModel.getPlayer();
        credits.setText(String.format("Currency: %d", player.getCredits()));

        Button buyGas = findViewById(R.id.buy_gas);
        String gasPrices = "Gas Price: $" + viewModel.getFuelPrice() + " per Gallon";
        buyGas.setText(gasPrices);

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(getFuelCapacity(viewModel));
        gasBar.setProgress(getFuelContents(viewModel));

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = getFuelContents(viewModel) + "/" + getFuelCapacity(viewModel);
        gasNum.setText(num);
    }

    /**
     * Returns the fuel contents of a player's ship
     *
     * @param vm The current universe view model
     * @return the current fuel content
     */
    private int getFuelContents(UniverseViewModel vm) {
        return vm.getFuelContents();
    }

    /**
     * Return the fuel capacity of a player's ship
     *
     * @param vm The current universe view model
     * @return the total fuel capacity
     */
    private int getFuelCapacity(UniverseViewModel vm) {
        return vm.getFuelCapacity();
    }

    @Override
    public void onResume() {
        super.onResume();
        credits.setText(String.format("Currency: %d", player.getCredits()));
    }

    /**
     * Returns to planet view on button press
     *
     * @param view button pressed
     */
    public void onCancel(View view) {
        onBackPressed();
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

    /**
     * Buys fuel on button press
     *
     * @param view button pressed
     */
    public void onBuyGas(View view) {
        viewModel.buyFuel();

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(getFuelCapacity(viewModel));
        gasBar.setProgress(getFuelContents(viewModel));

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = getFuelContents(viewModel) + "/" + getFuelCapacity(viewModel);
        gasNum.setText(num);

        credits.setText(String.format("Currency: %d", player.getCredits()));
    }
}
