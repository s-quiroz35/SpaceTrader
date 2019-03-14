package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.app.Activity;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.CargoItem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Market;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.MarketItem;

import static java.security.AccessController.getContext;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
class Repository {

    private static Game game;
    private Market market;

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
    void sellItem(CargoItem item) {
        if (item.getAmount() > 0) {
            if (game.getUniverse().getCurrentPlanet().getTechLevel().getTechLevel() -
                    (item.getType().getMinTechToUse()) >= 0) {
                game.getPlayer().getCargo().remove(item, 1);
                game.getPlayer().setCredits(game.getPlayer().getCredits() + item.getPrice());
                Log.v("Purchase status", "succeed");
            } else {
                Log.v("Purchase status", "failed. The tech level for the planet is too low.");
            }
        } else {
            Log.v("Purchase status", "failed. You do not have enough of the item to sell.");
        }
    }

    /**
     * Grabs the object of the current planet
     * @return the current planet
     */
    Planet getCurrentPlanet() { return game.getUniverse().getCurrentPlanet(); }

     /** Buys a cargo item
     *
     * @param item item to buy
     */
    void buyItem(CargoItem item) { game.getPlayer().getCargo().put(item, 1); }


    void createMarket() { market = new Market(); }

    Market getMarket() { return market;}

    /**
     * Buys a market item
     *
     * @param item item to buy
     */
    void buyItem(MarketItem item) {
        Cargo cargo = game.getPlayer().getCargo();
        CargoItem cargoItem = new CargoItem(item.getType());
        if (game.getPlayer().getCredits() - item.getPrice() >= 0 && (cargo.getCapacity() > cargo.getContents())) {
                cargo.put(cargoItem, 1);
                game.getPlayer().setCredits(game.getPlayer().getCredits() - item.getPrice());
                    Model.getInstance().getMarket().setNewCargoPrice(cargoItem);
                Log.v("Purchase status", "succeed");
        } else {
            Log.v("Purchase status", "failed. You do not have enough room in your cargo.");
        }
    }
}
