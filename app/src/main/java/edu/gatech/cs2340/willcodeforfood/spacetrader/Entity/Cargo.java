package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Cargo for ship
 *
 * @author Sam Quiroz and Matt Bernet
 * @version 1.0
 */
public class Cargo {
    //cargo implementation
    private List<CargoItem> items;
    private int capacity;
    private int contents;

    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Initializes a cargo with a capacity of 100
     */
    public Cargo() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initializes a player with custom capacity
     *
     * @param capacity how many goods can fit
     */
    public Cargo(int capacity) {
        this.capacity = capacity;
        this.contents = 0;
        items = new ArrayList<>();
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
    public List<CargoItem> getInventory() {
        return items;
    }

    /**
     * Adds good to cargo
     *
     * @param item item to add to cargo
     * @param quantity The amount you want to place in cargo
     * @return Whether there was room to add the good
     */
    public boolean put(CargoItem item, int quantity) {
        if (contents + quantity > capacity) {
            return false;
        }
        if (items.indexOf(item) == -1) {
            items.add(item);
            item.setAmount(quantity);

        } else {
            item.setAmount(item.getAmount() + quantity);
        }
        contents += quantity;
        return true;
    }

    /**
     * Removes an amount of good to cargo
     *
     * @param item item to remove
     * @param quantity The amount you want to remove
     * @return Whether the remove was successful
     */
    public boolean remove(CargoItem item, int quantity) {
        if (items.indexOf(item) == -1 || quantity > item.getAmount()) {
            return false;
        } else {
            item.setAmount(item.getAmount() - quantity);
            contents -= quantity;
            return true;
        }
    }
}
