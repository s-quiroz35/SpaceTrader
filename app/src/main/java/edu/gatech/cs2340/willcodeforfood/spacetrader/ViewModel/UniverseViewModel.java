package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.io.File;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for universe
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.6
 */
public class UniverseViewModel extends AndroidViewModel {

    private Universe universe;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
        universe = Model.getInstance().getUniverse();
    }

    /**
     * Saves game data
     *
     * @param file file to save data to
     * @return true if saved correctly, false otherwise
     */
    public boolean saveGame(File file) { return Model.getInstance().saveGame(file); }
    /**
     * Checks to see if random event occurred on travel
     *
     * @return event key
     */
    public String checkForEvent() {
        return Model.getInstance().checkForEvent();
    }
    /**
     * Adjusts market prices when traveling to planet
     *
     * @param planet destination planet
     */
    public void setMarketPrices(Planet planet) { Model.getInstance().setMarketPrices(planet); }
    /**
     * @return current player
     */
    public Player getPlayer() { return Model.getInstance().getPlayer(); }
    /**
     * @return current universe
     */
    public Universe getUniverse() { return Model.getInstance().getUniverse(); }
    /**
     *
     * @return fuel capacity
     */
    public int getFuelCapacity() { return Model.getInstance().getFuelCapacity(); }
    /**
     *
     * @return fuel contents
     */
    public int getFuelContents() { return Model.getInstance().getFuelContents(); }

    /**
     * Uses fuel
     * @param cost the fuel used
     */
    public void useFuel(int cost) { Model.getInstance().useFuel(cost);}

    /**
     * Gets the fuel price per gallon
     * @return the fuel amount
     */
    public int getFuelPrice() { return Model.getInstance().fuelPrice(); }

    /**
     * Buys fuel
     */
    public void buyFuel() { Model.getInstance().buyFuel(); }

    /**
     * Calculates the gas cost to travel to a planet
     * @return the gas cost
     */
    public int getGasCost() { return universe
            .gasPrice(this.getTravelPlanet());}

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return Model.getInstance().getCurrentPlanet(); }
    /**
     *
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() { return Model.getInstance()
            .getCurrentSolarSystem(); }
    /**
     *
     * @return the current selected planet
     */
    public Planet getTravelPlanet() { return Model.getInstance().getTravelPlanet(); }
    /**
     *
     * @param p the new current planet
     */
    public void setCurrentPlanet(Planet p) {
        Model.getInstance().setCurrentPlanet(p);
    }
    /**
     *
     * @param p the new travel planet
     */
    public void setTravelPlanet(Planet p) {
        Model.getInstance().setTravelPlanet(p);
    }
    /**
     *
     * @param s the new current solar system
     */
    public void setCurrentSolarSystem(SolarSystem s) {
        Model.getInstance().setCurrentSolarSystem(s);
    }
}
