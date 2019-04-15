package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Random;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.TechLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Trader;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
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
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream(file));
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
            Map<GoodType, Integer> market = planet.getMarket();
            for (GoodType good: market.keySet()) {
                good.setPrice(getPlanetTechLevel(planet), getPlanetResourceLevel(planet));
            }
        }

    /**
     *
     * @param p the player
     * @return the player's credits
     */
    private int getPlayerCredits(Player p) { return p.getCredits(); }
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
     * @param p planet
     * @return planet's tech level
     */
    private TechLevel getPlanetTechLevel(Planet p) { return p.getTechLevel(); }

    /**
     *
     * @param p planet
     * @return planet's resource level
     */
    private ResourceLevel getPlanetResourceLevel(Planet p) { return p.getResourceLevel(); }
    /**
     *
     * @param p planet for new current planet
     */
    void setCurrentPlanet(Planet p) { universe.setCurrentPlanet(p);
        currPlanet = p;
    }
    Planet getCurrentPlanet() {return universe.getCurrentPlanet();}
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

    /**
     *
     * @return the fuel capacity
     */
    int getFuelCapacity() { return ship.getFuelCapacity(); }

    /**
     *
     * @return the fuel capacity
     */
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
        int fuel = getShipFuel(ship);
        int pricePerGallon = (int) ((.6 * techLevel) + 2);
        int fuelCapacity = this.getFuelCapacity();
        int credits = getPlayerCredits(player);
        int afterCredits;
        if ((fuel + 25) <= fuelCapacity) {
            afterCredits = credits - (25 * pricePerGallon);
            if (afterCredits >= 0) {
                setShipFuel(ship, fuel + 25);
                player.setCredits(credits - (25 * pricePerGallon));
            }
        } else {
            int remainingFuel = fuelCapacity - fuel;
            afterCredits = credits - (remainingFuel * pricePerGallon);
            if (afterCredits >= 0) {
                setShipFuel(ship, fuel + remainingFuel);
                player.setCredits(afterCredits);
            }
        }
    }

    /**
     * @param s the ship
     * @return current fuel
     */
    private int getShipFuel(Ship s) { return s.getFuel(); }

    /**
     * sets the ship's fuel
     * @param s ship
     * @param i new fuel amount
     */
    private void setShipFuel(Ship s, int i) { s.setFuel(i); }

    /**
     * Buys item
     *
     * @param good bought item
     * @param trader the trader if it exists
     * @return true if bought item, false otherwise
     */
    boolean buyItem(GoodType good, Trader trader) {
        if (getPlayerCredits(player) < good.getPrice()) {
            return false;
        }
        int contents = cargo.getContents();
        int capacity = cargo.getCapacity();
        if ((contents + 1) > capacity) {
            return false;
        }

        if (getGoodMarket(currPlanet.getMarket(), good) == null) {
            return false;
        }

        addCargoGood(cargo, good);

        if (trader.isNull()) {
            currPlanet.removeGood(good, 1);
        } else {
            trader.removeGood(good, 1);
        }

        player.setCredits(getPlayerCredits(player) - good.getPrice());
        return true;
    }

    /**
     * returns the amount of good in a market
     * @param market the market
     * @param good the good
     * @return how much of the good is in the market
     */
    private Integer getGoodMarket(Map<GoodType, Integer> market, GoodType good) {
        return market.get(good);
    }

    /**
     * adds a good to cargo
     * @param c cargo
     * @param g good to be added
     */
    private void addCargoGood(Cargo c, GoodType g) {
        c.add(g, 1);
    }

    /**
     * removes a good from cargo
     * @param c cargo
     * @param g good to be removed
     */
    private void removeCargoGood(Cargo c, GoodType g) {
        c.remove(g, 1);
    }

    /**
     * Sells item
     *
     * @param good sold item
     * @param trader the trader if it exists
     * @return true if sold item, false otherwise
     */
    boolean sellItem(GoodType good, Trader trader) {
        Map<GoodType, Integer> inventory = cargo.getInventory();
        if ((inventory.get(good) == null)) {
            return false;
        }
        if (isTraderNull(trader)) {
            if (good.canSell(currPlanet.getTechLevel())) {
                return false;
            }
            removeCargoGood(cargo, good);
            currPlanet.addGood(good, 1);
        } else {
            if (good.canSell(trader.getTechLevel())) {
                return false;
            }
            removeCargoGood(cargo, good);
            trader.addGood(good, 1);
        }
        player.setCredits(player.getCredits() + getGoodPrice(good));
        return true;
    }

    /**
     *
     * @param t trader
     * @return if the trader is null
     */
    private boolean isTraderNull(Trader t) { return t.isNull(); }

    /**
     *
     * @param g the good
     * @return the good's price
     */
    private int getGoodPrice(GoodType g) { return g.getPrice(); }

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
        } else if (check ==2) {
            return "trader";
        } else {
            return "nope";
        }
    }
}
