package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;

/**
 * Functionality for Game interaction
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class GameInteractor extends Interactor {

    /**
     * Initializes Game Interactor
     *
     * @param repo repository
     */
    public GameInteractor(Repository repo) { super(repo); }

    /**
     * Adds game to system
     *
     * @param game new game
     */
    public void addGame(Game game) { getRepo().addGame(game); }

    /**
     * @return all games
     */
    public List<Game> getGames() { return getRepo().getGames(); }
}
