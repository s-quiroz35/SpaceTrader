package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class Planet {

    private String name;
    private Trader trader;

    /**
     * Initializes a random planet
     */
    public Planet(String n, Trader t) {
        trader = t;
        name = n;
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

    @Override
    public String toString() {
        return String.format("Name: %s", name);
    }
}
