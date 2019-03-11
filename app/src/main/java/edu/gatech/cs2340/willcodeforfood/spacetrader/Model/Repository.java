package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
class Repository {

    private static Game game;

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

    /**
     * Sells a cargo item
     *
     * @param item item to sell
     */
    void sellItem(CargoItem item) { game.getPlayer().getCargo().remove(item, 1); }

    /**
     * Grabs the object of the current planet
     * @return the current planet
     */
    Planet getCurrentPlanet() { return game.getUniverse().getCurrentPlanet(); }
}
