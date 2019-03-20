package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

/**
 * Welcome Screen View
 *
 * @author Emma Chadwick and Matt Bernet
 * @version 1.1
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome);
    }

    /**
     * When button create new game is pressed, it takes the person to a player creation screen
     *
     * @param view button pressed
     */
    public void createNewGame(View view) {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }

    /**
     * Continue game on button press
     *
     * @param view button pressed
     */
    public void continueGame(View view) {
        startActivity(new Intent(this, UniverseActivity.class));
    }
}
