package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.UniverseInteractor;

/**
 * View model for player configuration
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class ConfigViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;
    private UniverseInteractor uInteractor;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public ConfigViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
        uInteractor = Model.getInstance().getUniverseInteractor();
    }

    /**
     * Sends player to model to be added
     *
     * @param player new player
     */
    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }

    /**
     * Sends universe to model to be added
     * @param universe new universe
     */
    public void addUniverse(Universe universe) {
        uInteractor.addUniverse(universe);
    }
}
