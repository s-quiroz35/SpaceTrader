package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Welcome Screen View
 *
 * @author Emma Chadwick
 * @version 1.0
 */
import edu.gatech.cs2340.willcodeforfood.spacetrader.R;

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
     * When button continue game is pressed, this is not implemented yet
     *
     * @param view button pressed
     */
    public void continueGame(View view) {

    }
}
