package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
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
     * @return player ship cargo
     */
    public Cargo getCargo() { return Model.getInstance().getCargo(); }

    /**
     * Sells a cargo item
     *
     * @param item item to sell
     */
    public void sellItem(CargoItem item) { Model.getInstance().sellItem(item); }

    /**
     * Buys a cargo item
     *
     * @param item item to buy
     */
    public void buyItem(CargoItem item) { Model.getInstance().buyItem(item); }
}
