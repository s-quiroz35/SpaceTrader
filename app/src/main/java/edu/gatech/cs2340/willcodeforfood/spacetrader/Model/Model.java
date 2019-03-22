package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;

/**
 * Handles business logic
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.5
 */
public class Model {

    private Repository repo;

    //creates universal access
    private static Model instance = new Model();

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
     * @return current game
     */
    public Game getGame() { return instance.repo.getGame(); }

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

    public int getFuelCapacity() { return instance.repo.getFuelCapacity(); }

    public int getFuelContents() { return instance.repo.getFuelContents(); }

    public void useFuel(int cost) { instance.repo.useFuel(cost);}

    public void buyFuel() { instance.repo.buyFuel();}

    public int fuelPrice() { return instance.repo.fuelPrice();}


    /**
     * Buys item
     *
     * @param good bought item
     */
    public void buyItem(GoodType good) { instance.repo.buyItem(good); }

    /**
     * Sells item
     *
     * @param good sold item
     */
    public void sellItem(GoodType good) { instance.repo.sellItem(good); }
}
