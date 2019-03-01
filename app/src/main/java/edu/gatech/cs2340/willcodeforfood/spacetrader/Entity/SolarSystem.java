package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Solar System
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class SolarSystem {

    private String name;
    private int xCoor;
    private int yCoor;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private List<Planet> planets;

    private final String[] openNames = {"SS1", "SS2", "SS3", "SS4", "SS5"};

    /**
     * Initializes a random solar system
     */
    public SolarSystem() {
        Random rn = new Random();

        name = openNames[rn.nextInt(openNames.length)];
        xCoor = rn.nextInt(151);
        yCoor = rn.nextInt(101);
        techLevel = TechLevel.values()[rn.nextInt(8)];
        resourceLevel = ResourceLevel.values()[rn.nextInt(13)];
        planets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            planets.add(new Planet());
        }
    }

    /**
     * @return solar system name
     */
    public String getSolarSystemName() { return name; }

    /**
     * @return solar system x coordinate
     */
    public int getXCoor() { return xCoor; }

    /**
     * @return solar system y coordinate
     */
    public int getYCoor() { return yCoor; }

    /**
     * @return solar system tech level
     */
    public TechLevel getTechLevel() { return techLevel; }

    /**
     * @return solar system resource level
     */
    public ResourceLevel getResourceLevel() { return resourceLevel; }

    /**
     * @return solar system planets
     */
    public List<Planet> getPlanets() { return planets; }

    @Override
    public String toString() {
        return String.format("Name: %s, xCoor: %d, yCoor: %d, TechLevel: %d, " +
                "ResourceLevel: %d", name, xCoor, yCoor, techLevel.getTechLevel(),
                resourceLevel.getResourceLevel());
    }
}
