package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class Planet {

    private String name;
    private Market market;

    /**
     * Initializes a random planet
     */
    public Planet(String n) {
        name = n;
        market = new Market();
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

    /**
     * @return planet market
     */
    public Market getMarket() { return market; }

    @Override
    public String toString() {
        return String.format("Name: %s", name);
    }
}
