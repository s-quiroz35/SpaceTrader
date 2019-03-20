package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for universe
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class UniverseViewModel extends AndroidViewModel {

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * @return current planet market
     */
    public Map<GoodType, Integer> getMarket() { return Model.getInstance().getMarket(); }

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return Model.getInstance().getCurrentPlanet(); }
}
