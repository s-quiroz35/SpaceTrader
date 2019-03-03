package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Represents a Planet
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Planet {

    private String name;

    private final String[] openNames = {"Planet1, Planet2, Planet3"};

    /**
     * Initializes a random planet
     */
    public Planet() {
        Random rn = new Random();

        name = openNames[rn.nextInt(openNames.length)];
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
