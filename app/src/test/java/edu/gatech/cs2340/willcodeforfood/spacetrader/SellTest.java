package edu.gatech.cs2340.willcodeforfood.spacetrader;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Difficulty;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.TechLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Test for selling an item at planet market
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class SellTest {
    private Model testModel;
    private Player player;
    private Cargo cargo;
    private Map<GoodType, Integer> market;

    @Before
    public void setUp() {
        testModel = new Model();
        player = new Player("Matt", 16, 0, 0, 0, 0);
        Universe universe = new Universe();
        Planet planet = new Planet("TestPlanet",
                TechLevel.AGRICULTURE, ResourceLevel.POORSOIL);
        market = planet.getMarket();
        universe.setCurrentPlanet(planet);
        testModel.addGame(new Game(player, Difficulty.BEGINNER, universe));
        cargo = player.getCargo();
        cargo.add(GoodType.FOOD, 1);
        cargo.add(GoodType.WATER, 2);
        cargo.add(GoodType.ROBOTS, 3);
    }

    //Normal sell
    @Test
    public void testSell() {
        int marketWater = market.get(GoodType.WATER);
        assertTrue(testModel.sellItem(GoodType.WATER));
        assertEquals(cargo.getInventory().size(), 3);
        assertEquals(cargo.getContents(), 5);
        assertEquals(player.getCredits(), 1033);
        assertEquals((int) market.get(GoodType.WATER), marketWater + 1);
    }

    //Sell with one left of type of good
    @Test
    public void testSellOneLeft() {
        int marketFood = market.get(GoodType.FOOD);
        assertTrue(testModel.sellItem(GoodType.FOOD));
        assertEquals(cargo.getInventory().size(), 2);
        assertEquals(cargo.getContents(), 5);
        assertEquals(player.getCredits(), 1220);
        assertEquals((int) market.get(GoodType.FOOD), marketFood + 1);
    }

    //Try to sell good player does not have
    @Test
    public void testSellNoGood() {
        int marketFurs = market.get(GoodType.FURS);
        assertFalse(testModel.sellItem(GoodType.FURS));
        assertEquals(cargo.getInventory().size(), 3);
        assertEquals(cargo.getContents(), 6);
        assertEquals(player.getCredits(), 1000);
        assertEquals((int) market.get(GoodType.FURS), marketFurs);
    }

    //Try to sell good that cannot be sold on the current planet
    @Test
    public void testCannotSell() {
        assertFalse(testModel.sellItem(GoodType.ROBOTS));
        assertEquals(cargo.getInventory().size(), 3);
        assertEquals(cargo.getContents(), 6);
        assertEquals(player.getCredits(), 1000);
        assertNull(market.get(GoodType.ROBOTS));
    }
}
