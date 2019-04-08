package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.UniverseViewModel;

/**
 * Handles universe activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class UniverseActivity extends AppCompatActivity {

    private UniverseViewModel viewModel;
    private Universe universe;
    private List<SolarSystem> solarSystems;

    private ImageView solarSystem1;
    private ImageView solarSystem2;
    private ImageView solarSystem3;
    private ImageView solarSystem4;
    private ImageView solarSystem5;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_universe);

        solarSystem1 = findViewById(R.id.solar_system_1);
        solarSystem2 = findViewById(R.id.solar_system_2);
        solarSystem3 = findViewById(R.id.solar_system_3);
        solarSystem4 = findViewById(R.id.solar_system_4);
        solarSystem5 = findViewById(R.id.solar_system_5);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        universe = viewModel.getUniverse();
        solarSystems = universe.getSolarSystems();

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(viewModel.getFuelCapacity());
        gasBar.setProgress(viewModel.getFuelContents());

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = viewModel.getFuelContents() + "/" + viewModel.getFuelCapacity();
        gasNum.setText(num);

        TextView cSolarSystem = findViewById(R.id.current_solar_system);
        String ssCurrent = "Current Solar System " + viewModel.getCurrentSolarSystem().getSolarSystemName();
        cSolarSystem.setText(ssCurrent);

        //look into layout params for positioning image views, you can use the solar system
        //coordinate to position the image view with setMargins
        //there could be alternatives

        // i'm gonna look into this for solar system view because it doesn't apply for solar systems
    }

    /**
     * Saves game on button press
     *
     * @param view button pressed
     */
    public void onSavePressed(View view) {
        File file = new File(this.getFilesDir(), "save.txt");
        if (viewModel.saveGame(file)) {
            Toast toast = Toast.makeText(UniverseActivity.this,
                    "Save Successful!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            Toast toast = Toast.makeText(UniverseActivity.this,
                    "Save Failed!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * Returns to previous activity
     * @param view button pressed
     */
    public void onCancel(View view) {
        onBackPressed();
    }

    /**
     * Selects Solar System One
     * @param view button pressed
     */
    public void onSSOne(View view) {
        viewModel.setCurrentSolarSystem(solarSystems.get(0));
        startActivity(new Intent(UniverseActivity.this, SolarSystemActivity.class));
    }
    /**
     * Selects Solar System Two
     * @param view button pressed
     */
    public void onSSTwo(View view) {
        viewModel.setCurrentSolarSystem(solarSystems.get(1));
        startActivity(new Intent(UniverseActivity.this, SolarSystemActivity.class));
    }
    /**
     * Selects Solar System Three
     * @param view button pressed
     */
    public void onSSThree(View view) {
        viewModel.setCurrentSolarSystem(solarSystems.get(2));
        startActivity(new Intent(UniverseActivity.this, SolarSystemActivity.class));
    }
    /**
     * Selects Solar System Four
     * @param view button pressed
     */
    public void onSSFour(View view) {
        viewModel.setCurrentSolarSystem(solarSystems.get(3));
        startActivity(new Intent(UniverseActivity.this, SolarSystemActivity.class));
    }
    /**
     * Selects Solar System Five
     * @param view button pressed
     */
    public void onSSFive(View view) {
        viewModel.setCurrentSolarSystem(solarSystems.get(4));
        startActivity(new Intent(UniverseActivity.this, SolarSystemActivity.class));
    }

}
