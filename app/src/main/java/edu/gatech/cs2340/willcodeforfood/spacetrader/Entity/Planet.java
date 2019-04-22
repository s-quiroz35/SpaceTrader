package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.4
 */
public class Planet implements Serializable {

    //Note: Planets have same tech level and resource level as parent solar system
    private final String name;
    private final TechLevel techLevel;
    private final ResourceLevel resourceLevel;
    private Map<GoodType, Integer> market;
    private final Coordinate coordinate;

    /**
     * Initializes a random planet
     *
     * @param n name of the planet
     * @param r tech level of the planet
     * @param t resource level of the planet
     */
    public Planet(String n, TechLevel t, ResourceLevel r) {
        name = n;
        techLevel = t;
        resourceLevel = r;
        market = new HashMap<>();
        coordinate = new Coordinate();

        /* market item quantity needs to vary per planet based upon tech and resource levels,
           right now market is only set up to include the items that are allowed to be sold
         */
        Random rn = new Random();
        for (GoodType good: GoodType.values()) {
            if (good.canBuy(t)) {
                good.setPrice(techLevel, resourceLevel);
                market.put(good, rn.nextInt(21) + 1);
            }
        }
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

    /**
     * @return planet's coordinates
     */
    public Coordinate getCoordinate() { return coordinate; }

    /**
     *
     * @return x coordinate
     */
    public int getXCor() {return coordinate.getXCor(); }

    /**
     *
     * @return y coordinate
     */
    public int getYCor() {return coordinate.getYCor(); }

    /**
     * @return planet tech level
     */
    public TechLevel getTechLevel() { return techLevel; }

    /**
     *
     * @return tech level in int form
     */
    public int getTechLevelInt() { return techLevel.getTechLevel();}

    /**
     * @return planet resource level
     */
    public ResourceLevel getResourceLevel() { return resourceLevel; }

    /**
     * @return planet market
     */
    public Map<GoodType, Integer> getMarket() { return market; }

    /**
     * Sets a planet's market
     * @param market new market
     */
    public void setMarket(Map<GoodType, Integer> market) { this.market = market; }

    /**
     * Adds good to market
     *
     * @param good new good
     * @param quantity amount
     */
    public void addGood(GoodType good, int quantity) {
        if (market.get(good) == null) {
            market.put(good, quantity);
        } else {
            market.put(good, market.get(good) + quantity);
        }
    }

    /**
     * Removes good from market
     *
     * @param good new good
     * @param quantity amount
     */
    public void removeGood(GoodType good, int quantity) {
        market.put(good, market.get(good) - quantity);
        if (market.get(good) <= 0) {
            market.remove(good);
        }
    }

    @Override
    public String toString() {
        return String.format("Coordinate: %d,%d \n Resource Level: %d \n Tech Level: %d",
                coordinate.getXCor(), coordinate.getYCor(), resourceLevel.getResourceLevel(),
                techLevel.getTechLevel());
    }
}
