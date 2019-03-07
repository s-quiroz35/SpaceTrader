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
    private int techLevel;
    private ResourceLevel resourceLevel;
    private Map<Good, Integer> inventory;
    private Cargo cargo;

    /**
     * Good constructor
     *
     * @param techLevel The system's techLevel
     * @param resourceLevel The system's resourceLevel
     */
    public Trader(int techLevel, ResourceLevel resourceLevel) {
        this.techLevel = techLevel;
        this.resourceLevel = resourceLevel;
        List<Good> allGoods = Good.theGoods();
        inventory = new HashMap<>();
        cargo = new Cargo();
        int i = 0;
        while(this.techLevel >= allGoods.get(i).getMinTechLvlUse() && i < allGoods.size()) {
            inventory.put(allGoods.get(i), this.calcPrice(allGoods.get(i)));
            cargo.put(allGoods.get(i), this.calcQuantity(allGoods.get(i)));
            i++;
        }
    }

    /**
     * Calculates the price of a good and either doubles it or
     * halves it depending on if the SolarSystem meets the resourceLevel requirements
     *
     * @return Final price of the good
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

    /**
     * Calculates how much of a good the trader has
     *
     * @return Amount of a good that the trader has
     */
    public int calcQuantity(Good good) {
        int quantity = 20 + (20 * (int) Math.random() * good.getVariance());
        if (this.techLevel == good.getTechWMostProd()) {
            quantity *= 2;
        }
        return quantity;
    }

    /**
     * @return the trader's inventory
     */
    public Map<Good, Integer> getInventory() {
        return inventory;
    }

    /**
     * @return the trader's tech level
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * @return the trader's cargo
     */
    public Cargo getCargo() {
        return cargo;
    }
}
