package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Random;

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
 * @version 1.6
 */
class Repository {

    private Game game;

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
     * Saves game data
     *
     * @param file file to save data to
     * @return true if saved correctly, false otherwise
     */
    boolean saveGame(File file) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(game);
            output.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * Checks for saved game and loads it if possible
     *
     * @param file file with game data
     * @return true if load successful, false otherwise
     */
    boolean loadGame(File file) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            game = (Game) input.readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adjusts market prices when traveling to planet
     *
     * @param planet destination planet
     */
    void setMarketPrices(Planet planet) {
        for (GoodType good: planet.getMarket().keySet()) {
            good.setPrice(planet.getTechLevel(), planet.getResourceLevel());
        }
    }

    /**
     * @return current player
     */
    Player getPlayer() { return game.getPlayer(); }

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

    int getFuelCapacity() { return game.getPlayer().getShip().getFuelCapacity(); }

    int getFuelContents() { return game.getPlayer().getShip().getFuel(); }

    /**
     * Uses a certain amount of fuel
     *
     * @param spentGas the amount of gas being spent
     */
    void useFuel(int spentGas) {
        int fuel = game.getPlayer().getShip().getFuel() - spentGas;
        game.getPlayer().getShip().setFuel(fuel);
    }

    /**
     * calculates the price of the fuel
     *
     * @return the fuel price per gallon
     */
    int fuelPrice() {
        Planet currentPlanet = game.getUniverse().getCurrentPlanet();
        int techLevel = currentPlanet.getTechLevel().getTechLevel();

        return (int) (1.6 * (techLevel + 2)) * 25;
    }

    /**
     * Buys fuel
     */
    void buyFuel() {
        Planet currentPlanet = game.getUniverse().getCurrentPlanet();
        int techLevel = currentPlanet.getTechLevel().getTechLevel();
        int fuel = game.getPlayer().getShip().getFuel();

        int pricePerGallon = (int) ((.6 * techLevel) + 2);
        int fuelCapacity = this.getFuelCapacity();
        int credits = game.getPlayer().getCredits();
        int afterCredits;
        if ((fuel + 25) <= fuelCapacity) {
            afterCredits = credits - (25 * pricePerGallon);
            if (afterCredits >= 0) {
                game.getPlayer().getShip().setFuel(fuel + 25);
                game.getPlayer().setCredits(credits - (25 * pricePerGallon));
            }
        } else {
            int remainingFuel = fuelCapacity - fuel;
            afterCredits = credits - (remainingFuel * pricePerGallon);
            if (afterCredits >= 0) {
                game.getPlayer().getShip().setFuel(fuel + remainingFuel);
                game.getPlayer().setCredits(afterCredits);
            }
        }
    }

    /**
     * Buys item
     *
     * @param good bought item
     * @return true if bought item, false otherwise
     */
    boolean buyItem(GoodType good) {
        Player player = game.getPlayer();
        if (player.getCredits() < good.getPrice()) {
            return false;
        }
        int contents = player.getCargo().getContents();
        int capacity = player.getCargo().getCapacity();

        if ((contents + 1) > capacity) {
            return false;
        }

        game.getPlayer().getCargo().add(good, 1);
        game.getUniverse().getCurrentPlanet().removeGood(good, 1);
        player.setCredits(player.getCredits() - good.getPrice());
        return true;
    }

    /**
     * Sells item
     *
     * @param good sold item
     * @return true if sold item, false otherwise
     */
    boolean sellItem(GoodType good) {
        Player player = game.getPlayer();
        Map<GoodType, Integer> inventory = player.getCargo().getInventory();
        if ((inventory.get(good) == null) || (inventory.get(good) < 1)) {
            return false;
        }

        if (!good.canSell(game.getUniverse().getCurrentPlanet().getTechLevel())) {
            return false;
        }

        game.getPlayer().getCargo().remove(good, 1);
        game.getUniverse().getCurrentPlanet().addGood(good, 1);
        player.setCredits(player.getCredits() + good.getPrice());
        return true;
    }

    /**
     * Checks to see if random event occurred on travel
     *
     * @return event key
     */
    String checkForEvent() {
        Random rn = new Random();
        int check = rn.nextInt(2);
        if (check == 1) {
            Log.w("Event", "Random event occurring!");
            return "pirate";
        } else {
            Log.w("Event", "Random event did not occur!");
            return "nope";
        }
    }
}
