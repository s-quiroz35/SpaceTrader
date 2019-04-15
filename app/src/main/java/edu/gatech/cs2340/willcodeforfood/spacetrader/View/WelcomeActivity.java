package edu.gatech.cs2340.willcodeforfood.spacetrader.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import edu.gatech.cs2340.willcodeforfood.spacetrader.R;
import edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel.ConfigViewModel;

/**
 * Welcome Screen View
 *
 * @author Emma Chadwick and Matt Bernet
 * @version 1.2
 */
public class WelcomeActivity extends AppCompatActivity {

    private ConfigViewModel viewModel;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(ConfigViewModel.class);
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
        File file = new File(this.getFilesDir(), "save.txt");
        if (viewModel.loadGame(file)) {
            startActivity(new Intent(WelcomeActivity.this, UniverseActivity.class));
        } else {
            Toast toast = Toast.makeText(WelcomeActivity.this,
                    "No Saved Game!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}
