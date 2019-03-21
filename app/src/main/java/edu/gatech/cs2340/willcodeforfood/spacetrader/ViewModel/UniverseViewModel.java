package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for universe
 *
 * @author Matt Bernet
 * @version 1.3
 */
public class UniverseViewModel extends AndroidViewModel {

    private Player player = Model.getInstance().getPlayer();
    private Planet currentPlanet = Model.getInstance().getCurrentPlanet();

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
     * @return current universe
     */
    public Universe getUniverse() { return Model.getInstance().getUniverse(); }

    /**
     * @return current planet market
     */
    public Map<GoodType, Integer> getMarket() { return Model.getInstance().getMarket(); }

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return currentPlanet; }

    /**
     * @return player cargo
     */
    public Cargo getCargo() { return Model.getInstance().getCargo(); }

    /**
     * Buys item if possible
     *
     * @param good bought item
     * @return true if item bought, false otherwise
     */
    public boolean buyItem(GoodType good) {
        if (player.getCredits() < good.getPrice()) {
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

    /**
     * Sells item if possible
     *
     * @param good sold item
     * @return true if item sold, false otherwise
     */
    public boolean sellItem(GoodType good) {
        Map<GoodType, Integer> inventory = player.getCargo().getInventory();
        if (inventory.get(good) == null || inventory.get(good) < 1) {
            return false;
        }

        if (!good.canSell(currentPlanet.getTechLevel())) {
            return false;
        }

        Model.getInstance().sellItem(good);
        player.setCredits(player.getCredits() + good.getPrice());
        return true;
    }
}
