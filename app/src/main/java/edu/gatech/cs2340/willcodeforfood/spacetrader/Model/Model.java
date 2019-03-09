package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.List;

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
    public List<Game> getGames() { return repo.getGames(); }

}
