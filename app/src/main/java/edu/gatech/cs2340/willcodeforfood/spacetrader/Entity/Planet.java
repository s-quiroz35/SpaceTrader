package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Planet {

    //Note: Planets have same tech level and resource level as parent solar system
    private String name;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private Map<GoodType, Integer> market;

    /**
     * Initializes a random planet
     */
    public Planet(String n, TechLevel t, ResourceLevel r) {
        name = n;
        techLevel = t;
        resourceLevel = r;
        market = new HashMap<>();

        /* market item quantity needs to vary per planet, right now market is only set up
           to include the items that are allowed to be sold
         */
        for (GoodType good: GoodType.values()) {
            if (good.canBuy(t)) {
                market.put(good, good.getPrice(techLevel, resourceLevel));
            }
        }
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

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
    public Map<GoodType, Integer> getMarket() { return market; }

    @Override
    public String toString() {
        return String.format("Name: %s", name);
    }
}
