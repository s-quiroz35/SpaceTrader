package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Trader class to conduct trades
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Trader {
    int techLevel;
    ResourceLevel resourceLevel;
    Map<Good, Integer> inventory;

    /**
     * Good constructor
     *
     * @param system The SolarSystem this trader is in
     */
    public Trader(SolarSystem system) {
        this.techLevel = system.getTechLevel().getTechLevel();
        this.resourceLevel = system.getResourceLevel();
        List<Good> allGoods = Good.theGoods();
        inventory = new HashMap<>();
        int i = 0;
        while(this.techLevel >= allGoods.get(i).minTechLvlMk && i < allGoods.size()) {
            inventory.put(allGoods.get(i), this.calcPrice(allGoods.get(i)));
            i++;
        }
    }

    /**
     * Calculates the price of a good and either doubles it or
     * halves it depending on if the SolarSystem meets the resourceLevel requirements
     */
    public int calcPrice(Good good) {
        int price = good.price(this.techLevel);
        if (!(this.resourceLevel.equals(ResourceLevel.NOSPECIALRESOURCES))) {
            if (this.resourceLevel.equals(good.highPriceCondition)) {
                return price * 2;
            } else if (this.resourceLevel.equals(good.lowPriceCondition)) {
                return price / 2;
            }
        }
        return price;
    }
}
