package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Handles market buy activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketBuyActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_buy);
    }
}
