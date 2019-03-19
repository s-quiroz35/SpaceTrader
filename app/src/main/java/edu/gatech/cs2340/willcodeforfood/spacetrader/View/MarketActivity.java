package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Handles Market activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market);
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
