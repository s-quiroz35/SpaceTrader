package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.PlayerInit;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ConfigViewModel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Difficulty;

/**
 * Handles Player Config Activity
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.4
 */
public class ConfigActivity extends AppCompatActivity {

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

        player = new Player(new PlayerInit("Matt"), 0, 0, 0, 0);
        pointsCount.setText(String.format("%d", 16));
        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(ConfigViewModel.class);
    }

    /**
     * Button handler for Create Player
     *
     * @param view button pressed
     */
    public void onCreatePlayerPressed(View view) {
        CharSequence pilotChar = pilotCount.getText();
        CharSequence fighterChar = fighterCount.getText();
        CharSequence traderChar = traderCount.getText();
        CharSequence engineerChar = engineerCount.getText();
        CharSequence pointsChar = pointsCount.getText();

        int pilot = Integer.parseInt(pilotChar.toString());
        int fighter = Integer.parseInt(fighterChar.toString());
        int trader = Integer.parseInt(traderChar.toString());
        int engineer = Integer.parseInt(engineerChar.toString());
        int points = Integer.parseInt(pointsChar.toString());

        if (points != 0) {
            Toast toastText = Toast.makeText(this, "Must use all skill points",
                    Toast.LENGTH_SHORT);
            toastText.show();
        } else {
            CharSequence nameChar = name.getText();
            if ((name.length() != 0) && (!"Enter name".equals(nameChar.toString()))) {
                player.setName(nameChar.toString());
            } else {
                player.setName("Guardian");
            }
            player.setSkillPoints(points);
            player.setSkills(new int[]{pilot, fighter, trader, engineer});

            Difficulty diff = (Difficulty) diffSpinner.getSelectedItem();
            Universe universe = new Universe();
            viewModel.addGame(new Game(player, diff, universe));

            Intent intent = new Intent(this, PlanetActivity.class);
            startActivity(intent);
        }

    }

    /**
     * Cancel button takes user back a page
     *
     * @param view button pressed
     */
    public void onCancel(View view) {
        onBackPressed();
    }

    /**
     * Button handler for Pilot Add Button
     *
     * @param view button pressed
     */
    public void pilotIncPressed(View view) {
        CharSequence pointsChar = pointsCount.getText();
        CharSequence pilotChar = pilotCount.getText();
        int points = Integer.parseInt(pointsChar.toString());
        int pilotPoints = Integer.parseInt(pilotChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence pilotChar = pilotCount.getText();
        int points = Integer.parseInt(pointsChar.toString());
        int pilotPoints = Integer.parseInt(pilotChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence fighterChar = fighterCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int fighterPoints = Integer.parseInt(fighterChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence fighterChar = fighterCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int fighterPoints = Integer.parseInt(fighterChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence traderChar = traderCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int traderPoints = Integer.parseInt(traderChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence traderChar = traderCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int traderPoints = Integer.parseInt(traderChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence engineerChar = engineerCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int engineerPoints = Integer.parseInt(engineerChar.toString());
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
        CharSequence pointsChar = pointsCount.getText();
        CharSequence engineerChar = engineerCount.getText();

        int points = Integer.parseInt(pointsChar.toString());
        int engineerPoints = Integer.parseInt(engineerChar.toString());
        if (engineerPoints != 0) {
            engineerPoints--;
            points++;
        }
        engineerCount.setText(String.format("%d", engineerPoints));
        pointsCount.setText(String.format("%d", points));
    }
}
