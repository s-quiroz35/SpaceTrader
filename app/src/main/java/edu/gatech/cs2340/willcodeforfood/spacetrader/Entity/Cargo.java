package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Cargo for ship
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Cargo {

    private Map<GoodType, Integer> inventory;
    private int capacity;
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
    public Cargo(int capacity) {
        this.capacity = capacity;
        this.contents = 0;
        inventory = new HashMap<>();
        dummyData();
    }

    //temp dummy data
    void dummyData() {
        inventory.put(GoodType.FOOD, 3);
        inventory.put(GoodType.WATER, 6);
        inventory.put(GoodType.MACHINE, 1);
        inventory.put(GoodType.FURS, 20);
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
     * @return Whether there was room to add the good
     */
    public boolean put(GoodType good, int quantity) {
        if (contents + quantity > capacity) {
            return false;
        }
        if (inventory.get(good) == null) {
            inventory.put(good, quantity);
        } else {
            inventory.put(good,  inventory.get(good) + quantity);
        }
        contents += quantity;
        return true;
    }

    /**
     * Removes an amount of good to cargo
     *
     * @param good The kind of good you want to remove
     * @param quantity The amount you want to remove
     * @return Whether the remove was successful
     */
    public boolean remove(GoodType good, int quantity) {
        if (inventory.get(good) == null || quantity > inventory.get(good)) {
            return false;
        } else {
            inventory.put(good, inventory.get(good) - quantity);
            contents -= quantity;
            return true;
        }
    }
}
