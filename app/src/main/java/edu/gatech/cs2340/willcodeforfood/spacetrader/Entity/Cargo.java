package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Cargo for ship
 *
 * @author Sam Quiroz and Matt Bernet
 * @version 1.1
 */
public class Cargo implements Serializable {

    private final Map<GoodType, Integer> inventory;
    private final int capacity;
    private int contents;

    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Initializes cargo with a capacity of 1000
     */
    public Cargo() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initializes cargo with custom capacity
     *
     * @param capacity how many goods can fit
     */
    private Cargo(int capacity) {
        this.capacity = capacity;
        this.contents = 0;
        inventory = new HashMap<>();
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return amount of goods currently in cargo
     */
    public int getContents() {
        return contents;
    }

    /**
     * @return the cargo's inventory
     */
    public Map<GoodType, Integer> getInventory() {
        return inventory;
    }

    /**
     * Adds good to cargo
     *
     * @param good The kind of good you want to place in cargo
     * @param quantity The amount you want to place in cargo
     */
    public void add(GoodType good, int quantity) {
        if (inventory.get(good) == null) {
            inventory.put(good, quantity);
        } else {
            inventory.put(good,  inventory.get(good) + quantity);
        }
        contents += quantity;
    }

    /**
     * Removes an amount of good to cargo
     *
     * @param good The kind of good you want to remove
     * @param quantity The amount you want to remove
     */
    public void remove(GoodType good, int quantity) {
        inventory.put(good, inventory.get(good) - quantity);
        if (inventory.get(good) <= 0) {
            inventory.remove(good);
        }
        contents -= quantity;
    }
}
