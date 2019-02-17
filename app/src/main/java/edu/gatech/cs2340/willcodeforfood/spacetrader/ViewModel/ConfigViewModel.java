package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.PlayerInteractor;

/**
 * View model for adding player
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class ConfigViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public ConfigViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }
}
