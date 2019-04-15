package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.io.File;
import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;

/**
 * Handles business logic
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.8
 */
public final class Model {

    private final Repository repo;

    //creates universal access
    private static final Model instance = new Model();

    /**
     * @return model instance
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * Initializes model
     */
    private Model() {
        repo = new Repository();
    }

    /* Game functionality */

    /**
     * Adds game to system
     *
     * @param game new game
     */
    public void addGame(Game game) { instance.repo.addGame(game); }

    /**
     * Checks for saved game and loads it if possible
     *
     * @param file file with game data
     * @return true if load successful, false otherwise
     */
    public boolean loadGame(File file) { return instance.repo.loadGame(file); }

    /**
     * Saves game data
     *
     * @param file file to save data to
     * @return true if saved correctly, false otherwise
     */
    public boolean saveGame(File file) { return instance.repo.saveGame(file); }

    /**
     * Adjusts market prices when traveling to planet
     *
     * @param planet destination planet
     */
    public void setMarketPrices(Planet planet) { instance.repo.setMarketPrices(planet); }

    /**
     * @return current player
     */
    public Player getPlayer() { return instance.repo.getPlayer(); }

    /**
     * @return current universe
     */
    public Universe getUniverse() { return instance.repo.getUniverse(); }

    /**
     * @return player cargo
     */
    public Cargo getCargo() { return instance.repo.getCargo(); }

    /**
     * @return planet market
     */
    public Map<GoodType, Integer> getMarket() { return instance.repo.getMarket(); }

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return instance.repo.getCurrentPlanet(); }

    /**
     *
     * @param p new current planet
     */
    public void setCurrentPlanet(Planet p) { instance.repo.setCurrentPlanet(p);}

    /**
     * @return current planet
     */
    public Planet getTravelPlanet() { return instance.repo.getTravelPlanet(); }

    /**
     *
     * @param p new current planet
     */
    public void setTravelPlanet(Planet p) { instance.repo.setTravelPlanet(p);}

    /**
     * @return current planet
     */
    public SolarSystem getCurrentSolarSystem() { return instance.repo.getCurrentSolarSystem(); }

    /**
     *
     * @param s new current planet
     */
    public void setCurrentSolarSystem(SolarSystem s) { instance.repo.setSolarSystem(s);}

    /**
     *
     * @return fuel capacity
     */
    public int getFuelCapacity() { return instance.repo.getFuelCapacity(); }

    /**
     *
     * @return fuel contents
     */
    public int getFuelContents() { return instance.repo.getFuelContents(); }

    /**
     * Uses fuel in the ship
     * @param cost the fuel used
     */
    public void useFuel(int cost) { instance.repo.useFuel(cost);}

    /**
     * Buys more fuel
     */
    public void buyFuel() { instance.repo.buyFuel();}

    /**
     *
     * @return the price of fuel per gallon
     */
    public int fuelPrice() { return instance.repo.fuelPrice();}


    /**
     * Buys item
     *
     * @param good bought item
     * @param trader trader if it exists
     * @return if the item was bought
     */
    public boolean buyItem(GoodType good, Trader trader) {
        return instance.repo.buyItem(good, trader);
    }

    /**
     * Sells item
     *
     * @param good sold item
     * @param trader trader if it exists
     * @return if the item was sold
     */
    public boolean sellItem(GoodType good, Trader trader) {
        return instance.repo.sellItem(good, trader);
    }

    /**
     * Checks to see if random event occurred on travel
     *
     * @return event key
     */
    public String checkForEvent() { return instance.repo.checkForEvent(); }
}
