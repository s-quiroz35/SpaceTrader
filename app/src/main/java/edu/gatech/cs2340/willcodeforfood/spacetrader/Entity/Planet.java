package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class Planet {

    private String name;

    /**
     * Initializes a random planet
     */
    public Planet(String n) {
        Random rn = new Random();
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
