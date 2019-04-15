package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Trader
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Trader implements Serializable {
    private final Map<GoodType, Integer> market;
    private final TechLevel techLevel;

    /**
     * Initializes a new trader with random techLevel and resourceLevel
     */
    public Trader() {
        market = new HashMap<>();

        Random rn = new Random();

        TechLevel[] techLevels = TechLevel.values();
        techLevel = techLevels[rn.nextInt(8)];
        ResourceLevel[] resourceLevels = ResourceLevel.values();
        ResourceLevel resourceLevel = resourceLevels[rn.nextInt(13)];

        for (GoodType good: GoodType.values()) {
            if (canBuy(good, techLevel)) {
                good.setPrice(techLevel, resourceLevel);
                market.put(good, rn.nextInt(21) + 1);
            }
        }
    }

    /**
     * Returns whether the good can be bought
     *
     * @param g The goodtype to be bought
     * @param t The planet's techLevel
     * @return Can the good be bought
     */
    private boolean canBuy(GoodType g, TechLevel t) {
        return g.canBuy(t);
    }

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

    /**
     * @return this trader's market
     */
    public Map<GoodType, Integer> getMarket() {
        return market;
    }

    /**
     * @return this trader's techLevel
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     *
     * @return Whether this trader is really null
     */
    public boolean isNull() { return false; }

//    /**
//     * @return this trader's resourceLevel
//     */
//    public ResourceLevel getResourceLevel() {
//        return resourceLevel;
//    }
}
