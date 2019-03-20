package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for universe
 *
 * @author Matt Bernet
 * @version 1.1
 */
public class UniverseViewModel extends AndroidViewModel {

    private Player player = Model.getInstance().getPlayer();

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * @return current player
     */
    public Player getPlayer() { return player; }

    /**
     * @return current planet market
     */
    public Map<GoodType, Integer> getMarket() { return Model.getInstance().getMarket(); }

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return Model.getInstance().getCurrentPlanet(); }

    /**
     * Buys item if possible
     *
     * @param good bought item
     * @return true if item bought, false otherwise
     */
    public boolean buyItem(GoodType good) {
        if (player.getCredits() < good.getPrice()) {
            Log.w("Market", "Insufficient credits");
            return false;
        }
        int contents = player.getCargo().getContents();
        int capacity = player.getCargo().getCapacity();

        if ((contents + 1) > capacity) {
            return false;
        }
        Model.getInstance().buyItem(good);
        player.setCredits(player.getCredits() - good.getPrice());
        return true;
    }
}
