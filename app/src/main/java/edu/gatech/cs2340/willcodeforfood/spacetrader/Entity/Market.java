package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a market
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Market {

    private Map<GoodType, Integer> inventory;

    /**
     * Initializes a market with random inventory
     */
    public Market() {
        inventory = new HashMap<>();
        //randomized inventory still needs to be implemented
        dummyData();
    }

    //temp dummy data
    void dummyData() {
        inventory.put(GoodType.FIREARMS, 4);
        inventory.put(GoodType.FOOD, 7);
        inventory.put(GoodType.GAMES, 9);
        inventory.put(GoodType.ROBOTS, 30);
    }

    /**
     * @return market inventory
     */
    public Map<GoodType, Integer> getInventory() { return inventory; }
}
