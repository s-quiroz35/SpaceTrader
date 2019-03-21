package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;

/**
 * Handles business logic
 *
 * @author Matt Bernet
 * @version 1.4
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
