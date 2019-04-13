package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;

/**
 * View model for market
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class MarketViewModel extends AndroidViewModel {

    private Model model;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public MarketViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance();
    }

    /**
     * @return current planet market
     */
    public Map<GoodType, Integer> getMarket() { return model.getMarket(); }

    /**
     * @return player cargo
     */
    public Cargo getCargo() { return model.getCargo(); }

    /**
     * Buys item
     *
     * @param good good to be bought
     * @param trader trader if it exists
     * @return true if bought item, false otherwise
     */
    public boolean buyItem(GoodType good, Trader trader) {
        return Model.getInstance().buyItem(good, trader);
    }

    /**
     * Sells item
     *
     * @param good good to be sold
     * @param trader trader if it exists
     * @return true if sold item, false otherwise
     */
    public boolean sellItem(GoodType good, Trader trader) {
        return Model.getInstance().sellItem(good, trader);
    }
}
