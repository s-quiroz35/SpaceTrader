package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Market;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View Model for Market
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
     * @return planet market
     */
    public Market getMarket() { return Model.getInstance().getMarket(); }
}
