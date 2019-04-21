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
    private Map<GoodType, Integer> market;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;

    /**
     * Initializes a new trader with random techLevel and resourceLevel
     */
    public Trader() {
        market = new HashMap<>();

        Random rn = new Random();

        TechLevel[] techLevels = TechLevel.values();
        techLevel = techLevels[rn.nextInt(8)];
        ResourceLevel[] resourceLevels = ResourceLevel.values();
        resourceLevel = resourceLevels[rn.nextInt(13)];

        for (GoodType good: GoodType.values()) {
            if (good.canBuy(techLevel)) {
                good.setPrice(techLevel, resourceLevel);
                market.put(good, rn.nextInt(21) + 1);
            }
        }
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
     * @return this trader's resourceLevel
     */
    public ResourceLevel getResourceLevel() {
        return resourceLevel;
    }
}
