package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.io.File;
import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for universe
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.5
 */
public class UniverseViewModel extends AndroidViewModel {

    private Player player = Model.getInstance().getPlayer();
    private Planet currentPlanet = Model.getInstance().getCurrentPlanet();
    private SolarSystem currentSolarSystem = Model.getInstance().getCurrentSolarSystem();

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
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
    public Player getPlayer() { return player; }

    /**
     * @return current universe
     */
    public Universe getUniverse() { return Model.getInstance().getUniverse(); }

    public int getFuelCapacity() { return Model.getInstance().getFuelCapacity(); }

    public int getFuelContents() { return Model.getInstance().getFuelContents(); }

    public void useFuel(int cost) { Model.getInstance().useFuel(cost);}

    public int getFuelPrice() { return Model.getInstance().fuelPrice(); }

    public void buyFuel() { Model.getInstance().buyFuel(); }

    public int getGasCost() { return Model.getInstance().getUniverse().gasPrice(this.getTravelPlanet());}

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return currentPlanet; }

    public SolarSystem getCurrentSolarSystem() { return currentSolarSystem; }

    public Planet getTravelPlanet() { return Model.getInstance().getTravelPlanet(); }

    public void setCurrentPlanet(Planet p) {
        currentPlanet = p;
        Model.getInstance().setCurrentPlanet(currentPlanet);
    }
    public void setTravelPlanet(Planet p) {
        Model.getInstance().setTravelPlanet(p);
    }

    public void setCurrentSolarSystem(SolarSystem s) {
        currentSolarSystem = s;
        Model.getInstance().setCurrentSolarSystem(currentSolarSystem);
    }

    /**
     * @return player cargo
     */
    public Cargo getCargo() { return Model.getInstance().getCargo(); }
}
