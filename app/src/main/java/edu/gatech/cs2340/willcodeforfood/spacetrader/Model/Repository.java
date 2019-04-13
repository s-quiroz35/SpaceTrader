package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

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
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;

/**
 * Represents data abstraction
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.6
 */
class Repository {

    private Game game;
    private Universe universe;
    private Player player;
    private Planet currPlanet;
    private Ship ship;
    private Cargo cargo;
    /**
     * Adds a new game
     *
     * @param game new game
     */
    void addGame(Game game) {
        this.game = game;
        this.universe = game.getUniverse();
        this.player = game.getPlayer();
        this.currPlanet = universe.getCurrentPlanet();
        this.ship = player.getShip();
        this.cargo = player.getCargo();
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
            universe = game.getUniverse();
            player = game.getPlayer();
            currPlanet = universe.getCurrentPlanet();
            ship = player.getShip();
            cargo = player.getCargo();
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
    Cargo getCargo() { return player.getCargo(); }

    /**
     * @return current planet market
     */
    Map<GoodType, Integer> getMarket() { return currPlanet.getMarket(); }

    /**
     * @return current planet
     */
    Planet getCurrentPlanet() { return universe.getCurrentPlanet(); }

    /**
     *
     * @param p planet for new current planet
     */
    void setCurrentPlanet(Planet p) { universe.setCurrentPlanet(p);
    currPlanet = p;
    }

    /**
     * @return current planet
     */
    Planet getTravelPlanet() { return universe.getTravelPlanet(); }

    /**
     *
     * @param p planet for new current planet
     */
    void setTravelPlanet(Planet p) { universe.setTravelPlanet(p);}

    /**
     * @return current solar system
     */
    SolarSystem getCurrentSolarSystem() { return universe.getCurrentSolarSystem(); }

    /**
     *
     * @param s new solar system
     */
    void setSolarSystem(SolarSystem s) { universe.setCurrentSolarSystem(s);}

    int getFuelCapacity() { return ship.getFuelCapacity(); }

    int getFuelContents() { return ship.getFuel(); }

    /**
     * Uses a certain amount of fuel
     *
     * @param spentGas the amount of gas being spent
     */
    void useFuel(int spentGas) {
        int fuel = ship.getFuel() - spentGas;
        ship.setFuel(fuel);
    }

    /**
     * calculates the price of the fuel
     *
     * @return the fuel price per gallon
     */
    int fuelPrice() {
        int techLevel = currPlanet.getTechLevelInt();

        return (int) (1.6 * (techLevel + 2)) * 25;
    }

    /**
     * Buys fuel
     */
    void buyFuel() {
        int techLevel = currPlanet.getTechLevelInt();
        int fuel = ship.getFuel();

        int pricePerGallon = (int) ((.6 * techLevel) + 2);
        int fuelCapacity = this.getFuelCapacity();
        int credits = player.getCredits();
        int afterCredits;
        if ((fuel + 25) <= fuelCapacity) {
            afterCredits = credits - (25 * pricePerGallon);
            if (afterCredits >= 0) {
                ship.setFuel(fuel + 25);
                player.setCredits(credits - (25 * pricePerGallon));
            }
        } else {
            int remainingFuel = fuelCapacity - fuel;
            afterCredits = credits - (remainingFuel * pricePerGallon);
            if (afterCredits >= 0) {
                ship.setFuel(fuel + remainingFuel);
                player.setCredits(afterCredits);
            }
        }
    }

    /**
     * Buys item
     *
     * @param good bought item
     * @param trader trader if it exists
     * @return true if bought item, false otherwise
     */
    boolean buyItem(GoodType good, Trader trader) {
        if (player.getCredits() < good.getPrice()) {
            return false;
        }
        int contents = cargo.getContents();
        int capacity = cargo.getCapacity();

        if ((contents + 1) > capacity) {
            return false;
        }

        cargo.add(good, 1);
        if (trader == null) {
            currPlanet.removeGood(good, 1);
        } else {
            trader.removeGood(good, 1);
        }
        player.setCredits(player.getCredits() - good.getPrice());
        return true;
    }

    /**
     * Sells item
     *
     * @param good sold item
     * @param trader trader if it exists
     * @return true if sold item, false otherwise
     */
    boolean sellItem(GoodType good, Trader trader) {
        Map<GoodType, Integer> inventory = cargo.getInventory();
        if ((inventory.get(good) == null) || (inventory.get(good) < 1)) {
            return false;
        }

        if (trader == null) {
            if (!good.canSell(game.getUniverse().getCurrentPlanet().getTechLevel())) {
                return false;
            }
            cargo.remove(good, 1);
            currPlanet.addGood(good, 1);
        } else {
            if (!good.canSell(trader.getTechLevel())) {
                return false;
            }
            cargo.remove(good, 1);
            trader.addGood(good, 1);
        }

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
        int check = rn.nextInt(3);
        if (check == 1) {
            return "pirate";
        } else if (check == 2){
            return "trader";
        } else {
            return "nope";
        }
    }
}
