package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Handles planet activity
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PlanetActivity extends AppCompatActivity {
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_planet);

        planet = Model.getInstance().getCurrentPlanet();

        TextView title = findViewById(R.id.planet_title);
        String str = planet.getPlanetName();
        title.setText(str);
    }

    /**
     * Button handler for entering market
     *
     * @param view button pressed
     */
    public void onMarketPressed(View view) {
        startActivity(new Intent(PlanetActivity.this, MarketActivity.class));
    }
}
