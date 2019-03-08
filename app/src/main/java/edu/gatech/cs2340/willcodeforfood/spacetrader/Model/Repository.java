package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet
 * @version 1.1
 */
class Repository {

    private List<Game> games;

    /**
     * Initializes repo
     */
    Repository() {
        games = new ArrayList<>();
    }

    /**
     * Adds a new game
     *
     * @param game new game
     */
    void addGame(Game game) {
        games.add(game);
        Log.w("Add", String.format("Game created: Name: %s, Difficulty: %s, Pilot: %d, " +
                        "Fighter: %d, Trader: %d, Engineer: %d", game.getPlayer().getName()
                ,game.getDifficulty(), game.getPlayer().getSkills()[0],
                game.getPlayer().getSkills()[1], game.getPlayer().getSkills()[2],
                game.getPlayer().getSkills()[3]));
        Log.w("Add", game.getUniverse().toString());
    }

    /**
     * @return all games
     */
    List<Game> getGames() { return games; }
}
