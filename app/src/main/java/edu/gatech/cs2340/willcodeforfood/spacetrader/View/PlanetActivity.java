package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Handles Planet Activity
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class PlanetActivity extends AppCompatActivity {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_planet);
        //TextView nameTextView = (TextView) findViewById(R.id.planet_name);
        //TextView techLevelTextView = (TextView) findViewById(R.id.techLevel);
        Intent intent = getIntent();
        String planetName = intent.getStringExtra("planetName");
        String techLevel = intent.getStringExtra("techLevel");
        //nameTextView.setText(planetName);
        String techLvlString = "TechLevel: " + techLevel;
        //techLevelTextView.setText(techLvlString);
    }

    public void onMarketPressed(View view) {
        Intent intent = new Intent(this, MarketWelcomeActivity.class);
        startActivity(intent);
    }
}
