package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Planet {

    private String name;
    private Market market;
    private Coordinate coordinate;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;

    /**
     * Initializes a random planet
     */
    public Planet(String n) {
        name = n;
        market = new Market();

        Random rn = new Random();

        coordinate = new Coordinate();
        techLevel = TechLevel.values()[rn.nextInt(8)];
        resourceLevel = ResourceLevel.values()[rn.nextInt(13)];

    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

    /**
     * @return planets's coordinates
     */
    public Coordinate getCoordinates() { return coordinate; }

    /**
     * @return planet tech level
     */
    public TechLevel getTechLevel() { return techLevel; }

    /**
     * @return planet resource level
     */
    public ResourceLevel getResourceLevel() { return resourceLevel; }

    /**
     * @return planet market
     */
    public Market getMarket() { return market; }

    @Override
    public String toString() {
        return String.format("Name: %s Tech Level: %d Resource Level: %d", name, techLevel.getTechLevel(), resourceLevel.getResourceLevel());
    }
}
