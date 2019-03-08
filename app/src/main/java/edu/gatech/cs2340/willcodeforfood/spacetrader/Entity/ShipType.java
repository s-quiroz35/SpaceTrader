package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Ship types
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum ShipType {
    GNAT("Gnat", 1000);

    private String type;
    private int fuelCapacity;

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
     * @return ship type
     */
    public String getType() { return type; }

    /**
     * @return ship fuel capacity
     */
    public int getFuelCapacity() { return fuelCapacity; }
}
