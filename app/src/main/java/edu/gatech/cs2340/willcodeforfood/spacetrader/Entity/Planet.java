package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import android.support.annotation.NonNull;

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
    private final Map<GoodType, Integer> market;
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
            if (canBuy(good, t)) {
                good.setPrice(techLevel, resourceLevel);
                market.put(good, rn.nextInt(21) + 1);
            }
        }
    }

    /**
     * Returns whether the good can be bought
     *
     * @param g The good type to be bought
     * @param t The planet's techLevel
     * @return Can the good be bought
     */
    private boolean canBuy(GoodType g, TechLevel t) {
        return g.canBuy(t);
    }

    /**
     * @return planet name
     */
    public String getPlanetName() { return name; }

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
    @NonNull
    public String toString() {
        return String.format("Coordinates: %d,%d \n Resource Level: %d \n Tech Level: %d",
                coordinate.getXCor(), coordinate.getYCor(), resourceLevel.getResourceLevel(),
                techLevel.getTechLevel());
    }
}
