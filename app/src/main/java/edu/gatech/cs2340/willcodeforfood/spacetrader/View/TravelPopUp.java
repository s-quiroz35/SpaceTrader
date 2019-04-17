package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Travel pop up
 *
 * @author Emma Chadwick and Matt Bernet
 * @version 1.3
 */
public class TravelPopUp extends AppCompatActivity {

    private Planet travelPlanet;
    private UniverseViewModel viewModel;
    private int fuelCost;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_travel);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = getWindowManager();
        Display display = manager.getDefaultDisplay();

        display.getMetrics(dm);

        int width = (int) (dm.widthPixels * .8);
        int height = (int)(dm.heightPixels * .6);

        Window newWindow = getWindow();
        newWindow.setLayout(width,height);

        travelPlanet = viewModel.getTravelPlanet();

        TextView tPlanet = findViewById(R.id.travel_title);
        String newTitle = "Travel to " + travelPlanet.getPlanetName();
        tPlanet.setText(newTitle);

        TextView planetData = findViewById(R.id.planet_data);
        planetData.setText(travelPlanet.toString());

        fuelCost = viewModel.getGasCost();
        TextView fuel = findViewById(R.id.gas_cost);
        String fuelString = "Gas cost for travel: " + fuelCost + " gallons";
        fuel.setText(fuelString);

    }

    /**
     * Returns to previous activity
     * @param view a button
     */
    public void onCancel(View view) {
        onBackPressed();
    }

    /**
     * Travels to the desired Planet
     * @param view a button
     */
    public void onTravel(View view) {
        int fuel = viewModel.getFuelContents();
        if ((fuel - fuelCost) >= 0) {
            viewModel.useFuel(fuelCost);
            viewModel.setCurrentPlanet(travelPlanet);
            viewModel.setMarketPrices(travelPlanet);
            String event = viewModel.checkForEvent();
            if ("pirate".equals(event)) {
                viewModel.getUniverse().createPirate();
                startActivity(new Intent(TravelPopUp.this, PirateActivity.class));
            } else {
                startActivity(new Intent(TravelPopUp.this, PlanetActivity.class));
            }
        } else {
            Toast toast = Toast.makeText(TravelPopUp.this,
                    "Unable to travel", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}