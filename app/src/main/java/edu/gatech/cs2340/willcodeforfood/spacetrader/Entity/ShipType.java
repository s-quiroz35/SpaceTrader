package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Ship types
 *
 * @author Matt Bernet
 * @version 1.1
 */
public enum ShipType {
    GNAT("Gnat", 1000),
    HORNET("Hornet", 1200);



    private final String type;
    private final int fuelCapacity;

    /**
     * Constructor for ShipType enumeration
     *
     * @param type ship type
     */
    ShipType(String type, int fuelCapacity) {
        this.type = type;
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * @return ship fuel capacity
     */
    public int getFuelCapacity() { return fuelCapacity; }
}
