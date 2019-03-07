package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Firearms;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Food;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Furs;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Games;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Machines;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Medicine;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Narcotics;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Ore;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Robots;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods.Water;

/**
 * Superclass for all goods
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Good {
    //good implementation
    private int minTechLvlMk;
    private int minTechLvlUse;
    private int techWMostProd;
    private int basePrice;
    private int priceIncPerLvl;
    private int variance;
    //int increaseEvent;
    ResourceLevel lowPriceCondition;
    ResourceLevel highPriceCondition;

    /**
     * Good constructor
     *
     * @param minTechLvlMk The minimum tech level for a trader to sell a good
     * @param minTechLvlUse The minimum tech level for a trader to buy a good
     * @param techWMostProd  The tech level that produces the most of a resource
     * @param basePrice The base price of a good
     * @param priceIncPerLvl The amount price increases per tech level
     * @param variance The price variance for traders
     * @param lowPriceCondition Condition that lowers the price
     * @param highPriceCondition Condition that raises the price
     */
    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd,int basePrice,
                int priceIncPerLvl, int variance, ResourceLevel lowPriceCondition,
                ResourceLevel highPriceCondition) {
        this.minTechLvlMk = minTechLvlMk;
        this.minTechLvlUse = minTechLvlUse;
        this.techWMostProd = techWMostProd;
        this.basePrice = basePrice;
        this.priceIncPerLvl = priceIncPerLvl;
        this.variance = variance;
        this.lowPriceCondition = lowPriceCondition;
        this.highPriceCondition = highPriceCondition;
    }

    /**
     * Good constructor without a high price condition
     *
     * @param minTechLvlMk The minimum tech level for a trader to sell a good
     * @param minTechLvlUse The minimum tech level for a trader to buy a good
     * @param techWMostProd  The tech level that produces the most of a resource
     * @param basePrice The base price of a good
     * @param priceIncPerLvl The amount price increases per tech level
     * @param variance The price variance for traders
     * @param lowPriceCondition Condition that lowers the price
     */
    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
                int priceIncPerLvl, int variance, ResourceLevel lowPriceCondition) {
        this(minTechLvlMk, minTechLvlUse, techWMostProd, basePrice, priceIncPerLvl,
                variance, lowPriceCondition, ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Good constructor without price changing conditions
     *
     * @param minTechLvlMk The minimum tech level for a trader to sell a good
     * @param minTechLvlUse The minimum tech level for a trader to buy a good
     * @param techWMostProd  The tech level that produces the most of a resource
     * @param basePrice The base price of a good
     * @param priceIncPerLvl The amount price increases per tech level
     * @param variance The price variance for traders
     */
    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
                int priceIncPerLvl, int variance) {
        this(minTechLvlMk, minTechLvlUse, techWMostProd, basePrice, priceIncPerLvl,
                variance, ResourceLevel.NOSPECIALRESOURCES, ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Makes a list of all good types. It's for trader and it's
     * dumb but it works I think.
     */
    public static List<Good> theGoods() {
       List<Good> theList = new ArrayList<>();
       theList.add(new Water());
       theList.add(new Furs());
       theList.add(new Food());
       theList.add(new Ore());
       theList.add(new Games());
       theList.add(new Firearms());
       theList.add(new Medicine());
       theList.add(new Machines());
       theList.add(new Narcotics());
       theList.add(new Robots());
       return theList;
    }

    /**
     * Calculates the price of a good
     */
    public int price(int techLvl) {
        return basePrice + priceIncPerLvl*(techLvl - minTechLvlMk)
                + (int) (Math.random() * (variance + 1));
    }

    /**
     * @return Minimum tech level for a trader to have the good
     */
    public int getMinTechLvlMk() {
        return minTechLvlMk;
    }

    /**
     * @return Minimum tech level for a trader to buy the good from player
     */
    public int getMinTechLvlUse() {
        return minTechLvlUse;
    }

    /**
     * @return The good's base price
     */
    public int getBasePrice() {
        return basePrice;
    }

}
