package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


/**
 * Good enum
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public enum Good {

    WATER(0, 0, 2, 30, 3, 4, ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT),
    FURS(0, 0, 0, 250, 10, 10, ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS),
    FOOD(1, 0, 1, 100, 5, 5, ResourceLevel.RICHSOIL, ResourceLevel.POORSOIL),
    ORE(2, 2, 3, 350, 20, 10, ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR),
    GAMES(3, 1, 6, 250, -10, 5, ResourceLevel.ARTISTIC),
    FIREARMS(3, 1, 5, 1250, -75, 100, ResourceLevel.WARLIKE),
    MEDICINE(4, 1, 6, 650, -20, 10, ResourceLevel.LOTSOFHERBS),
    MACHINES(4, 3, 5, 900, -30, 5),
    NARCOTICS(5, 0, 5, 3500, -125, 150, ResourceLevel.WEIRDMUSHROOMS),
    ROBOTS(6, 4, 7, 5000, -150, 100);


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
    Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd,int basePrice,
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
    Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
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
    Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
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
       for (Good g : Good.values()) {
           theList.add(g);
       }
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

    /**
     * @return the good's variance for price and quantity for traders
     */
    public int getVariance() {
        return variance;
    }

    /**
     * @return the tech level with the most production of this good
     */
    public int getTechWMostProd() {
        return techWMostProd;
    }
}
