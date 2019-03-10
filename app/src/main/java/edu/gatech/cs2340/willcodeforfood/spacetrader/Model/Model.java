package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;

/**
 * Handles business logic
 *
 * @author Matt Bernet
 * @version 1.2
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
}
