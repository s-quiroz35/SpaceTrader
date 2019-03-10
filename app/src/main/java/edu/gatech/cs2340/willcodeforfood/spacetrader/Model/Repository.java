package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet
 * @version 1.2
 */
class Repository {

    private Game game;

    /**
     * Initializes repo
     */
    Repository() {
        //nothing here at the moment
    }

    /**
     * Adds a new game
     *
     * @param g new game
     */
    void addGame(Game g) {
        this.game = g;
        Log.w("Add", String.format("Game created: Name: %s, Difficulty: %s, Pilot: %d, " +
                        "Fighter: %d, Trader: %d, Engineer: %d", game.getPlayer().getName()
                ,game.getDifficulty(), game.getPlayer().getSkills()[0],
                game.getPlayer().getSkills()[1], game.getPlayer().getSkills()[2],
                game.getPlayer().getSkills()[3]));
        Log.w("Add", game.getUniverse().toString());
    }

    /**
     * @return current game
     */
    Game getGame() { return game; }

    /**
     * @return ship cargo
     */
    Cargo getCargo() { return game.getPlayer().getCargo(); }
}
