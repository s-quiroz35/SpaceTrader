package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles Market activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
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

        Button buyGas = findViewById(R.id.buy_gas);
        String gasPrices = "Gas Price: $" + viewModel.getFuelPrice() + " per Gallon";
        buyGas.setText(gasPrices);

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(viewModel.getFuelCapacity());
        gasBar.setProgress(viewModel.getFuelContents());

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = viewModel.getFuelContents() + "/" + viewModel.getFuelCapacity();
        gasNum.setText(num);
    }

    @Override
    public void onResume() {
        super.onResume();
        credits.setText(String.format("Currency: %d", viewModel.getPlayer().getCredits()));
    }

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

    public void onBuyGas(View view) {
        viewModel.buyFuel();

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(viewModel.getFuelCapacity());
        gasBar.setProgress(viewModel.getFuelContents());

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = viewModel.getFuelContents() + "/" + viewModel.getFuelCapacity();
        gasNum.setText(num);

        credits.setText(String.format("Currency: %d", viewModel.getPlayer().getCredits()));
    }
}
