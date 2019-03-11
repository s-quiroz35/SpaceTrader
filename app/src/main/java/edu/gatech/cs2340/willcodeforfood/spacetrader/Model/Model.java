package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Market;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.MarketItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;

/**
 * Handles business logic
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
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
    public void addGame(Game game) { repo.addGame(game); }

    /**
     * @return all games
     */
    public Game getGame() { return repo.getGame(); }

    /**
     * @return player ship cargo
     */
    public Cargo getCargo() { return repo.getCargo(); }

    /**
     * @return the market of the current planet
     */
    public Market getMarket() { return this.getCurrentPlanet().getMarket(); }
    /**
     * Sells a cargo item
     *
     * @param item item to sell
     */
    public void sellItem(CargoItem item) { repo.sellItem(item); }

    /**
     * Grabs the object of the current planet
     * @return the current planet
     */
    public Planet getCurrentPlanet() { return repo.getCurrentPlanet(); }

     /** Buys a cargo item
     *
     * @param item item to buy
     */
    public void buyItem(CargoItem item) { repo.buyItem(item); }

    /**
     * Buys a market item
     *
     * @param item item to buy
     */
    public void buyItem(MarketItem item) { repo.buyItem(item); }
}
