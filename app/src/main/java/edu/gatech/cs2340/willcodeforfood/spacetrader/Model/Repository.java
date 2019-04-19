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

/**
 * Stores data and manages game
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.7
 */
class Repository {

    private Game game;

    //if adding another event, increase this seed by one
    private static final int EVENT_SEED = 3;

    /**
     * Adds a new game
     *
     * @param game new game
     */
    void addGame(Game game) {
        this.game = game;
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
        Map<GoodType, Integer> market = planet.getMarket();
        for (GoodType good: market.keySet()) {
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
     * @return player ship
     */
    Ship getShip() { return game.getPlayer().getShip(); }

    /**
     * @return current planet market
     */
    Map<GoodType, Integer> getMarket() { return this.getCurrentPlanet().getMarket(); }

    /**
     * @return current planet
     */
    Planet getCurrentPlanet() { return game.getUniverse().getCurrentPlanet(); }

    /**
     * Sets current planet
     *
     * @param p planet for new current planet
     */
    void setCurrentPlanet(Planet p) { game.getUniverse().setCurrentPlanet(p); }

    /**
     * @return current planet
     */
    Planet getTravelPlanet() { return game.getUniverse().getTravelPlanet(); }

    /**
     * Sets destination planet
     *
     * @param p planet for new current planet
     */
    void setTravelPlanet(Planet p) { game.getUniverse().setTravelPlanet(p);}

    /**
     * @return current solar system
     */
    SolarSystem getCurrentSolarSystem() { return game.getUniverse().getCurrentSolarSystem(); }

    /**
     * Sets current solar system
     *
     * @param s new solar system
     */
    void setSolarSystem(SolarSystem s) { game.getUniverse().setCurrentSolarSystem(s); }

    /**
     * @return ship fuel capacity
     */
    int getFuelCapacity() { return this.getShip().getFuelCapacity(); }

    /**
     * @return ship fuel level
     */
    int getFuelContents() { return this.getShip().getFuel(); }

    /**
     * Uses a certain amount of fuel
     *
     * @param spentGas the amount of gas being spent
     */
    void useFuel(int spentGas) {
        int fuel = this.getFuelContents() - spentGas;
        this.getShip().setFuel(fuel);
    }

    /**
     * calculates the price of the fuel
     *
     * @return the fuel price per gallon
     */
    int fuelPrice() {
        int techLevel = this.getCurrentPlanet().getTechLevelInt();

        return (int) (1.6 * (techLevel + 2)) * 25;
    }

    /**
     * Buys fuel
     */
    void buyFuel() {
        int techLevel = this.getCurrentPlanet().getTechLevelInt();
        int fuel = this.getFuelContents();

        int pricePerGallon = (int) ((.6 * techLevel) + 2);
        int fuelCapacity = this.getFuelCapacity();
        int credits = game.getPlayer().getCredits();
        int afterCredits;
        if ((fuel + 25) <= fuelCapacity) {
            afterCredits = credits - (25 * pricePerGallon);
            if (afterCredits >= 0) {
                this.getShip().setFuel(fuel + 25);
                game.getPlayer().setCredits(credits - (25 * pricePerGallon));
            }
        } else {
            int remainingFuel = fuelCapacity - fuel;
            afterCredits = credits - (remainingFuel * pricePerGallon);
            if (afterCredits >= 0) {
                this.getShip().setFuel(fuel + remainingFuel);
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
        if (game.getPlayer().getCredits() < good.getPrice()) {
            return false;
        }
        int contents = this.getCargo().getContents();
        int capacity = this.getCargo().getCapacity();

        if ((contents + 1) > capacity) {
            return false;
        }

        this.getCargo().add(good, 1);
        this.getCurrentPlanet().removeGood(good, 1);
        game.getPlayer().setCredits(game.getPlayer().getCredits() - good.getPrice());
        return true;
    }

    /**
     * Sells item
     *
     * @param good sold item
     * @return true if sold item, false otherwise
     */
    boolean sellItem(GoodType good) {
        Map<GoodType, Integer> inventory = this.getCargo().getInventory();
        if ((inventory.get(good) == null)) {
            return false;
        }

        if (!good.canSell(this.getCurrentPlanet().getTechLevel())) {
            return false;
        }

        this.getCargo().remove(good, 1);
        this.getCurrentPlanet().addGood(good, 1);
        game.getPlayer().setCredits(game.getPlayer().getCredits() + good.getPrice());
        return true;
    }

    /**
     * Checks to see if random event occurred on travel
     *
     * @return event key
     */
    String checkForEvent() {
        Random rn = new Random();
        int check = rn.nextInt(EVENT_SEED) + 1;
        switch(check) {
            case 1:
                return "pirate";
            case 2:
                return "police";
            default:
                return "";
        }
    }
}
