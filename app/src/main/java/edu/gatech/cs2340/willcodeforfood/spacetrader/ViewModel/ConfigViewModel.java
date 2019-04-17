package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.io.File;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;

/**
 * View model for game configuration
 *
 * @author Matt Bernet
 * @version 1.2
 */
public class ConfigViewModel extends AndroidViewModel {

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public ConfigViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Sends game to model to be added
     *
     * @param game new game
     */
    public void addGame(Game game) {
        Model.getInstance().addGame(game);
    }

    /**
     * Checks for saved game and loads it if possible
     *
     * @param file file with game data
     * @return true if load successful, false otherwise
     */
    public boolean loadGame(File file) { return Model.getInstance().loadGame(file); }
}
