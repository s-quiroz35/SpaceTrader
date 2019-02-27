package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.PlayerInteractor;

/**
 * View model for player configuration
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class ConfigViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public ConfigViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * Sends player to model to be added
     *
     * @param player new player
     */
    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }
}
