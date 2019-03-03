package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Ship types
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum ShipType {
    GNAT("Gnat");

    private String type;

    /**
     * Constructor for ShipType enumeration
     *
     * @param type ship type
     */
    ShipType(String type) {
        this.type = type;
    }

    /**
     * @return ship type
     */
    public String getType() { return type; }
}
