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

    private String[] openNames;

    /**
     * Initializes a random planet
     */
    public Planet() {
        Random rn = new Random();

        name = openNames[rn.nextInt(openNames.length)];
    }

    /**
     * Sets the open names for solar systems and planets
     *
     * @param names array of names
     */
    public void setOpenNames(String[] names) {
        this.openNames = names;
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }
}
