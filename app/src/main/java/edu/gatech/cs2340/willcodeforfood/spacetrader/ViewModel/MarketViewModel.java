package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for market
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketViewModel extends AndroidViewModel {

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public MarketViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * @return current planet market
     */
    public Map<GoodType, Integer> getMarket() { return Model.getInstance().getMarket(); }

    /**
     * @return player cargo
     */
    public Cargo getCargo() { return Model.getInstance().getCargo(); }

    /**
     * Buys item
     *
     * @param good good to be bought
     * @return true if bought item, false otherwise
     */
    public boolean buyItem(GoodType good) {
        return Model.getInstance().buyItem(good);
    }

    /**
     * Sells item
     *
     * @param good good to be sold
     * @return true if sold item, false otherwise
     */
    public boolean sellItem(GoodType good) {
        return Model.getInstance().sellItem(good);
    }
}
