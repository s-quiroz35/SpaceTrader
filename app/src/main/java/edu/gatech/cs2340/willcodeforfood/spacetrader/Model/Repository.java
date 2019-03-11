package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.app.Activity;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.MarketItem;

import static java.security.AccessController.getContext;

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

    /**
     * Sells a cargo item
     *
     * @param item item to sell
     */
    void sellItem(CargoItem item) { game.getPlayer().getCargo().remove(item, 1); }

    /**
     * Buys a cargo item
     *
     * @param item item to buy
     */
    void buyItem(CargoItem item) { game.getPlayer().getCargo().put(item, 1); }


    /**
     * Buys a market item
     *
     * @param item item to buy
     */
    void buyItem(MarketItem item) {
        CargoItem cargoItem = new CargoItem(item.getType());
        if (game.getPlayer().getCredits() - item.getPrice() >= 0) {
            game.getPlayer().getCargo().put(cargoItem, 1);
            game.getPlayer().setCredits(game.getPlayer().getCredits() - item.getPrice());
            Log.v("Purchase status", "succeed");
        } else {
            Log.v("Purchase status", "failed");
        }
    }
}
