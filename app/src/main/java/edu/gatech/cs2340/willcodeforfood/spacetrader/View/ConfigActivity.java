package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ConfigViewModel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Difficulty;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ServiceViewModel;

/**
 * Handles Player Config Activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class ConfigActivity extends AppCompatActivity {

    private ServiceViewModel serviceViewModel;
    private ConfigViewModel viewModel;
    private Player player;

    private EditText name;
    private Spinner diffSpinner;
    private TextView pilotCount;
    private TextView fighterCount;
    private TextView traderCount;
    private TextView engineerCount;
    private TextView pointsCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_config_player);

        name = findViewById(R.id.player_name_input);
        diffSpinner = findViewById(R.id.diff_spinner);
        pilotCount = findViewById(R.id.pilot_count);
        fighterCount = findViewById(R.id.fighter_count);
        traderCount = findViewById(R.id.trader_count);
        engineerCount = findViewById(R.id.engineer_count);
        pointsCount = findViewById(R.id.player_points_count);

        ArrayAdapter<Difficulty> diffAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Difficulty.values());
        diffAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diffSpinner.setAdapter(diffAdapter);

        player = new Player("Matt", 16, 0, 0, 0, 0);
        pointsCount.setText(String.format("%d", 16 ));
        viewModel = ViewModelProviders.of(this).get(ConfigViewModel.class);
        serviceViewModel = ViewModelProviders.of(this).get(ServiceViewModel.class);
    }

    /**
     * Button handler for Create Player
     *
     * @param view button pressed
     */
    public void onCreatePlayerPressed(View view) {
        int pilot = Integer.parseInt(pilotCount.getText().toString());
        int fighter = Integer.parseInt(fighterCount.getText().toString());
        int trader = Integer.parseInt(traderCount.getText().toString());
        int engineer = Integer.parseInt(engineerCount.getText().toString());
        int points = Integer.parseInt(pointsCount.getText().toString());

        if (points != 0) {
            Toast.makeText(this, serviceViewModel.makeLowPointRequest("Too low points"),
                    Toast.LENGTH_LONG).show();
        } else {
            if (name.length() != 0) {
                player.setName(name.getText().toString());
            } else {
                player.setName("Guardian");
            }
            player.setSkillPoints(points);
            player.setSkills(new int[]{pilot, fighter, trader, engineer});
            //set difficulty of game here after implemented game class
            Log.w("Add", "Player added: " + player.toString());
            viewModel.addPlayer(player);
        }
    }

    /**
     * Cancel button takes user back to main screen
     *
     * @param view button pressed
     */
    public void onCancel(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Button handler for Pilot Add Button
     *
     * @param view button pressed
     */
    public void pilotIncPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int pilotPoints = Integer.parseInt(pilotCount.getText().toString());
        if (points > 0) {
            pilotPoints++;
            points--;
        }
        pilotCount.setText(String.format("%d", pilotPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Pilot Subtract Button
     *
     * @param view button pressed
     */
    public void pilotDecPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int pilotPoints = Integer.parseInt(pilotCount.getText().toString());
        if (pilotPoints != 0) {
            pilotPoints--;
            points++;
        }
        pilotCount.setText(String.format("%d", pilotPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Fighter Add Button
     *
     * @param view button pressed
     */
    public void fighterIncPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int fighterPoints = Integer.parseInt(fighterCount.getText().toString());
        if (points > 0) {
            fighterPoints++;
            points--;
        }
        fighterCount.setText(String.format("%d", fighterPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Fighter Subtract Button
     *
     * @param view button pressed
     */
    public void fighterDecPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int fighterPoints = Integer.parseInt(fighterCount.getText().toString());
        if (fighterPoints != 0) {
            fighterPoints--;
            points++;
        }
        fighterCount.setText(String.format("%d", fighterPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Trader Add Button
     *
     * @param view button pressed
     */
    public void traderIncPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int traderPoints = Integer.parseInt(traderCount.getText().toString());
        if (points > 0) {
            traderPoints++;
            points--;
        }
        traderCount.setText(String.format("%d", traderPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Trader Subtract Button
     *
     * @param view button pressed
     */
    public void traderDecPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int traderPoints = Integer.parseInt(traderCount.getText().toString());
        if (traderPoints != 0) {
            traderPoints--;
            points++;
        }
        traderCount.setText(String.format("%d", traderPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Engineer Add Button
     *
     * @param view button pressed
     */
    public void engineerIncPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int engineerPoints = Integer.parseInt(engineerCount.getText().toString());
        if (points > 0) {
            engineerPoints++;
            points--;
        }
        engineerCount.setText(String.format("%d", engineerPoints));
        pointsCount.setText(String.format("%d", points));
    }

    /**
     * Button handler for Engineer Subtract Button
     *
     * @param view button pressed
     */
    public void engineerDecPressed(View view) {
        int points = Integer.parseInt(pointsCount.getText().toString());
        int engineerPoints = Integer.parseInt(engineerCount.getText().toString());
        if (engineerPoints != 0) {
            engineerPoints--;
            points++;
        }
        engineerCount.setText(String.format("%d", engineerPoints));
        pointsCount.setText(String.format("%d", points));
    }
}
