package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.PlayerInteractor;

/**
 * View model for player list
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PlayerListingViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public PlayerListingViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * @return the players from model
     */
    public List<Player> getPlayers() { return interactor.getPlayers(); }
}
