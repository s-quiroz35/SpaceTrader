package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ConfigViewModel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Help the planet event screen
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class HelpPlanetActivity extends AppCompatActivity {

    UniverseViewModel viewModel;
    Planet currPlanet;
    TextView msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_help_planet);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        currPlanet = viewModel.getCurrentPlanet();
        msg = findViewById(R.id.plea);

        String problem;

        if (currPlanet.getResourceLevel().equals(ResourceLevel.DESERT)) {
            problem = "a terrible drought";
        } else if (currPlanet.getResourceLevel().equals(ResourceLevel.MINERALPOOR)) {
            problem = "near total depletion of natural resources";
        } else if (currPlanet.getResourceLevel().equals(ResourceLevel.POORSOIL)) {
            problem = "a terrible famine";
        } else {
            problem = "too many mouths to feed and not enough to go around";
        }

        String string1 = "Sir, " + currPlanet.getPlanetName()
                + " has yet to be saved by the great Titan. We suffer from ";
        String string2 = ". Please, we are forced to ask for your help as we await true balance.";

        String msgComplete = string1 + problem + string2;
        msg.setText(msgComplete);
    }

    /**
     * Donate $100 to the people of the planet
     *
     * @param view button pressed
     */
    public void donate(View view) {
        if (viewModel.donate(100)) {
            Toast toast = Toast.makeText(HelpPlanetActivity.this,
                    "Thank You! Your honor has increased.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            startActivity(new Intent(HelpPlanetActivity.this, WarpAnimActivity.class));
        } else {
            Toast toast = Toast.makeText(HelpPlanetActivity.this,
                    "Unable to donate", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * Go straight to the planet
     *
     * @param view button pressed
     */
    public void refuse(View view) {
        viewModel.getPlayer().setHonor(viewModel.getPlayer().getHonor() - 1);
        startActivity(new Intent(HelpPlanetActivity.this, WarpAnimActivity.class));
    }
}
