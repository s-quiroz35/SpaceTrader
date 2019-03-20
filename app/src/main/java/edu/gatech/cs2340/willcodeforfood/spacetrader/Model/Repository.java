package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet
 * @version 1.3
 */
class Repository {

    private Game game;

    /**
     * Initializes repo
     */
    Repository() {
        //nothing for now
    }

    /**
     * Adds a new game
     *
     * @param game new game
     */
    void addGame(Game game) {
        this.game = game;
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
     * @return player cargo
     */
    Cargo getCargo() { return game.getPlayer().getCargo(); }

    /**
     * @return current planet market
     */
    Map<GoodType, Integer> getMarket() { return game.getUniverse().getCurrentPlanet().getMarket(); }

    /**
     * @return current planet
     */
    Planet getCurrentPlanet() { return game.getUniverse().getCurrentPlanet(); }
}
