package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class Planet {

    private String name;
    private Map<GoodType, Integer> market;

    /**
     * Initializes a random planet
     */
    public Planet(String n) {
        name = n;
        market = new HashMap<>();
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

    /**
     * @return planet market
     */
    public Map<GoodType, Integer> getMarket() { return market; }

    @Override
    public String toString() {
        return String.format("Name: %s", name);
    }
}
