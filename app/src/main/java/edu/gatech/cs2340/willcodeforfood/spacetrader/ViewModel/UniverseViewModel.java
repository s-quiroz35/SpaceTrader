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

    private final Universe universe;
    private final Model model;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance();
        universe = model.getUniverse();
    }

    /**
     * Saves game data
     *
     * @param file file to save data to
     * @return true if saved correctly, false otherwise
     */
    public boolean saveGame(File file) { return model.saveGame(file); }
    /**
     * Checks to see if random event occurred on travel
     *
     * @return event key
     */
    public String checkForEvent() {
        return model.checkForEvent();
    }
    /**
     * Adjusts market prices when traveling to planet
     *
     * @param planet destination planet
     */
    public void setMarketPrices(Planet planet) { model.setMarketPrices(planet); }
    /**
     * @return current player
     */
    public Player getPlayer() { return model.getPlayer(); }
    /**
     * @return current universe
     */
    public Universe getUniverse() { return model.getUniverse(); }
    /**
     *
     * @return fuel capacity
     */
    public int getFuelCapacity() { return model.getFuelCapacity(); }
    /**
     *
     * @return fuel contents
     */
    public int getFuelContents() { return model.getFuelContents(); }

    /**
     * Uses fuel
     * @param cost the fuel used
     */
    public void useFuel(int cost) { model.useFuel(cost);}

    /**
     * Gets the fuel price per gallon
     * @return the fuel amount
     */
    public int getFuelPrice() { return model.fuelPrice(); }

    /**
     * Buys fuel
     */
    public void buyFuel() { model.buyFuel(); }

    /**
     * Calculates the gas cost to travel to a planet
     * @return the gas cost
     */
    public int getGasCost() { return universe
            .gasPrice(this.getTravelPlanet());}

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return model.getCurrentPlanet(); }
    /**
     *
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() { return model
            .getCurrentSolarSystem(); }
    /**
     *
     * @return the current selected planet
     */
    public Planet getTravelPlanet() { return model.getTravelPlanet(); }
    /**
     *
     * @param p the new current planet
     */
    public void setCurrentPlanet(Planet p) {
        model.setCurrentPlanet(p);
    }
    /**
     *
     * @param p the new travel planet
     */
    public void setTravelPlanet(Planet p) {
        model.setTravelPlanet(p);
    }
    /**
     *
     * @param s the new current solar system
     */
    public void setCurrentSolarSystem(SolarSystem s) {
        model.setCurrentSolarSystem(s);
    }
}
