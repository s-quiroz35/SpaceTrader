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

    private static final int DEFAULT_CAPACITY = 15;

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
        dummyData();
    }

    /**
     * Loads dummy data into cargo for testing
     */
    private void dummyData() {
        items.add(new CargoItem(GoodType.FOOD));
        items.add(new CargoItem(GoodType.WATER));
        items.add(new CargoItem(GoodType.MEDICINE, 5));
        items.add(new CargoItem(GoodType.FIREARMS, 7));
        contents = 12;
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

    public void setContents(int c) { this.contents = c; }
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
        int index = items.indexOf(item);
        int i = 0;
        while (i < items.size()) {
            if (items.get(i).getType() == item.getType()) {
                index = i;
            }
            i++;
        }
        if (index == -1) {
            item.setAmount(quantity);
            items.add(item);
        } else {
            items.get(index).setAmount(items.get(index).getAmount() + quantity);
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
        int index = items.indexOf(item);
        if (index == -1 || quantity > items.get(index).getAmount()) {
            return false;
        } else {
            items.get(index).setAmount(item.getAmount() - quantity);
            contents -= quantity;
            return true;
        }
    }
}
