package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.4
 */
class Repository {

    private Game game;
    private Player player;

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
        player = game.getPlayer();
    }

    /**
     * @return current game
     */
    Game getGame() { return game; }

    /**
     * @return current player
     */
    Player getPlayer() { return player; }

    /**
     * @return current universe
     */
    Universe getUniverse() { return game.getUniverse(); }

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

    /**
     *
     * @param p planet for new current planet
     */
    void setCurrentPlanet(Planet p) { game.getUniverse().setCurrentPlanet(p);}

    /**
     * @return current planet
     */
    Planet getTravelPlanet() { return game.getUniverse().getTravelPlanet(); }

    /**
     *
     * @param p planet for new current planet
     */
    void setTravelPlanet(Planet p) { game.getUniverse().setTravelPlanet(p);}

    /**
     * @return current solar system
     */
    SolarSystem getCurrentSolarSystem() { return game.getUniverse().getCurrentSolarSystem(); }

    /**
     *
     * @param s new solar system
     */
    void setSolarSystem(SolarSystem s) { game.getUniverse().setCurrentSolarSystem(s);}

    int getFuelCapacity() { return player.getShip().getFuelCapacity(); }

    int getFuelContents() { return player.getShip().getFuel(); }

    void useFuel(int spentGas) { player.getShip().spendFuel(spentGas); }

    int fuelPrice() { return player.getShip().fuelPrice(); }

    void buyFuel() { player.getShip().buyFuel(); }

    /**
     * Buys item
     *
     * @param good bought item
     */
    void buyItem(GoodType good) {
        game.getPlayer().getCargo().add(good, 1);
        game.getUniverse().getCurrentPlanet().removeGood(good, 1);
    }

    /**
     * Sells item
     *
     * @param good sold item
     */
    void sellItem(GoodType good) {
        game.getPlayer().getCargo().remove(good, 1);
        game.getUniverse().getCurrentPlanet().addGood(good, 1);
    }
}
