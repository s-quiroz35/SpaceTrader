package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
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
 * @version 1.2
 */
public class UniverseActivity extends AppCompatActivity {

    private SolarSystem currSolarSystem;
    private UniverseViewModel viewModel;
    private Universe universe;
    private List<SolarSystem> solarSystems;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_universe);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(UniverseViewModel.class);
        currSolarSystem = viewModel.getCurrentSolarSystem();
        universe = viewModel.getUniverse();
        solarSystems = universe.getSolarSystems();

        ProgressBar gasBar = findViewById(R.id.gas_bar);
        gasBar.setMax(getFuelCapacity(viewModel));
        gasBar.setProgress(getFuelContents(viewModel));

        TextView gasNum = findViewById(R.id.gas_numbers);
        String num = getFuelContents(viewModel) + "/" + getFuelCapacity(viewModel);
        gasNum.setText(num);

        TextView cSolarSystem = findViewById(R.id.current_solar_system);
        String ssCurrent = "Current Solar System "
                + currSolarSystem.getSolarSystemName();
        cSolarSystem.setText(ssCurrent);

        //look into layout params for positioning image views, you can use the solar system
        //coordinate to position the image view with setMargins
        //there could be alternatives

        // i'm gonna look into this for solar system view because it doesn't apply for solar systems
    }

    /**
     *
     * @param vm current view model
     * @return fuel contents
     */
    private int getFuelContents(UniverseViewModel vm) {
        return vm.getFuelContents();
    }

    /**
     *
     * @param vm current view model
     * @return fuel capacity
     */
    private int getFuelCapacity(UniverseViewModel vm) {
        return vm.getFuelCapacity();
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
