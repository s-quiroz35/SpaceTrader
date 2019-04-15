package edu.gatech.cs2340.willcodeforfood.spacetrader;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Difficulty;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Ship;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * Test for buying fuel
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class BuyFuelTest {

    private Player player;
    private Universe universe;
    private Game game;
    private Ship ship;
    private Planet currentPlanet;
    private Model model;

    /**
     * This method is used to initialize the game's data
     */
    @Before
    public void init() {
        universe = new Universe();
        player = new Player("Emma", 16, 4, 4, 4, 4);
        game = new Game(player, Difficulty.BEGINNER, universe);
        ship = player.getShip();
        currentPlanet = universe.getCurrentPlanet();
        model = Model.getInstance();
        model.addGame(game);
    }

    /**
     * Checks if buying a full gallon works
     */
    @Test
    public void gallon() {
        //set to 100 so I know it will take a full gallon
        ship.setFuel(100);

        int techLevel = currentPlanet.getTechLevelInt();
        int pricePerGallon = (int) ((.6 * techLevel) + 2) * 25;
        int credits = player.getCredits();
        int finalCredits = credits - pricePerGallon;
        int fuelAfter = ship.getFuel() + 25;


        model.buyFuel();

        assertEquals(finalCredits, player.getCredits());
        assertEquals(fuelAfter, ship.getFuel());
    }

    /**
     * Checks if buying less than a gallon works
     */
    @Test
    public void lessThanGallon() {
        // set ship to buy less than a gallon
        ship.setFuel(980);

        int techLevel = currentPlanet.getTechLevelInt();
        int pricePerGallon = (int) ((.6 * techLevel) + 2) * 20;
        int credits = player.getCredits();
        int finalCredits = credits - pricePerGallon;
        int fuelAfter = ship.getFuel() + 20;


        model.buyFuel();

        assertEquals(finalCredits, player.getCredits());
        assertEquals(fuelAfter, ship.getFuel());

    }

    /**
     * Checks if buying doesn't work if you have no money
     */
    @Test
    public void noCredits() {
        ship.setFuel(100);
        player.setCredits(0);
        int credits = player.getCredits();
        int fuelAfter = ship.getFuel();


        model.buyFuel();

        assertEquals(credits, player.getCredits());
        assertEquals(fuelAfter, ship.getFuel());

        ship.setFuel(980);
        player.setCredits(0);
        int newCredits = player.getCredits();
        int newFuelAfter = ship.getFuel();


        model.buyFuel();

        assertEquals(newCredits, player.getCredits());
        assertEquals(newFuelAfter, ship.getFuel());
    }

    /**
     * Check if you can't buy over the fuel capacity limit
     */
    @Test
    public void noMoreFuel() {
        ship.setFuel(ship.getFuelCapacity());
        player.setCredits(1000);
        int credits = player.getCredits();
        int fuelAfter = ship.getFuel();

        model.buyFuel();

        assertEquals(credits, player.getCredits());
        assertEquals(fuelAfter, ship.getFuel());
    }
}
