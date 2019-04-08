package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Type of Good
 *
 * @author Sam Quiroz and Matt Bernet
 * @version 1.0
 */
public enum GoodType {
    WATER("Water", 0, 0, 0, 2, 30, 3, 4, ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT),
    FURS("Furs", 0, 0, 0, 0, 250, 10, 10, ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS),
    FOOD("Food", 0, 1, 0, 1, 100, 5, 5, ResourceLevel.RICHSOIL, ResourceLevel.POORSOIL),
    ORE("Ore", 0, 2, 2, 3, 350, 20, 10, ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR),
    GAMES("Games", 0, 3, 1, 6, 250, -10, 5, ResourceLevel.ARTISTIC),
    FIREARMS("Firearms", 0, 3, 1, 5, 1250, -75, 100, ResourceLevel.WARLIKE),
    MEDICINE("Medicine", 0, 4, 1, 6, 650, -20, 10, ResourceLevel.LOTSOFHERBS),
    MACHINE("Machine", 0, 4, 3, 5, 900, -30, 5),
    NARCOTICS("Narcotics", 0, 5, 0 ,5, 3500, -125, 150, ResourceLevel.WEIRDMUSHROOMS),
    ROBOTS("Robots", 0, 6, 4, 7, 5000, -150, 100);

    private String name;
    private int planetPrice;
    private int minTechToProduce;
    private int minTechToUse;
    private int techMostProduce;
    private int basePrice;
    private int priceIncPerLevel;
    private int variance;
    private ResourceLevel priceDecEvent;
    private ResourceLevel priceIncEvent;

    /**
     * Constructor for no price increase or decrease events
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param minTechToProduce min tech level to produce resource
     * @param minTechToUse min tech level to use resource
     * @param techMostProduce tech level that produces most of resource
     * @param basePrice base price of resource
     * @param priceIncPerLevel price increase per tech level
     * @param variance max percentage price can vary above or below base
     */
    GoodType(String name, int planetPrice, int minTechToProduce, int minTechToUse,
             int techMostProduce, int basePrice, int priceIncPerLevel, int variance) {
        this(name, planetPrice, minTechToProduce, minTechToUse, techMostProduce, basePrice,
                priceIncPerLevel, variance, ResourceLevel.NOSPECIALRESOURCES,
                ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Constructor for no price increase event
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param minTechToProduce min tech level to produce resource
     * @param minTechToUse min tech level to use resource
     * @param techMostProduce tech level that produces most of resource
     * @param basePrice base price of resource
     * @param priceIncPerLevel price increase per tech level
     * @param variance max percentage price can vary above or below base
     * @param priceDecEvent when present, price of resource is unusually low
     */
    GoodType(String name, int planetPrice, int minTechToProduce, int minTechToUse,
             int techMostProduce, int basePrice, int priceIncPerLevel, int variance,
             ResourceLevel priceDecEvent) {
        this(name, planetPrice, minTechToProduce, minTechToUse, techMostProduce, basePrice,
                priceIncPerLevel, variance, priceDecEvent, ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Base constructor for Good Type
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param minTechToProduce min tech level to produce resource
     * @param minTechToUse min tech level to use resource
     * @param techMostProduce tech level that produces most of resource
     * @param basePrice base price of resource
     * @param priceIncPerLevel price increase per tech level
     * @param variance max percentage price can vary above or below base
     * @param priceDecEvent when present, price of resource is unusually low
     * @param priceIncEvent when present, price of resource is unusually expensive
     */
    GoodType(String name, int planetPrice, int minTechToProduce, int minTechToUse,
             int techMostProduce, int basePrice, int priceIncPerLevel, int variance,
             ResourceLevel priceDecEvent, ResourceLevel priceIncEvent) {
        this.name = name;
        this.planetPrice = planetPrice;
        this.minTechToProduce = minTechToProduce;
        this.minTechToUse = minTechToUse;
        this.techMostProduce = techMostProduce;
        this.basePrice = basePrice;
        this.priceIncPerLevel = priceIncPerLevel;
        this.variance = variance;
        this.priceDecEvent = priceDecEvent;
        this.priceIncEvent = priceIncEvent;
    }

    /**
     * Sets current planet price of good
     *
     * @param t current tech level
     * @param r current resource level
     */
    public void setPrice(TechLevel t, ResourceLevel r) {
        Random rn = new Random();
        int var = rn.nextInt(variance);
        var = var / 100;
        int price = basePrice + (priceIncPerLevel * (t.getTechLevel()
                + minTechToProduce)) + (basePrice * var);
        if (r.getResourceLevel() == priceIncEvent.getResourceLevel()) {
            price *= 2;
        } else if (r.getResourceLevel() == priceDecEvent.getResourceLevel()) {
            price /= 2;
        }

        planetPrice = price;
    }

    /**
     * @return price of good on current planet
     */
    public int getPrice() { return planetPrice; }

    /**
     * Determines whether can buy on planet
     *
     * @param t planet tech level
     * @return true if able to buy, false otherwise
     */
    public boolean canBuy(TechLevel t) { return t.getTechLevel() >= minTechToProduce; }

    /**
     * Determines whether can sell on planet
     *
     * @param t planet tech level
     * @return true if able to sell, false otherwise
     */
    public boolean canSell(TechLevel t) { return t.getTechLevel() >= minTechToUse; }

    /**
     * @return name of good
     */
    public String getName() { return name; }

    /**
     * @return min tech level to produce resource
     */
    public int getMinTechToProduce() { return minTechToProduce; }

    /**
     * @return min tech level to use resource
     */
    public int getMinTechToUse() { return minTechToUse; }

    /**
     * @return tech level that produces most of resource
     */
    public int getTechMostProduce() { return techMostProduce; }

    /**
     * @return base price of resource
     */
    public int getBasePrice() { return basePrice; }

    /**
     * @return price increase per tech level
     */
    public int getPriceIncPerLevel() { return priceIncPerLevel; }

    /**
     * @return max percentage price can vary above or below base
     */
    public int getVariance() { return variance; }

    /**
     * @return when present, price of resource is unusually low
     */
    public ResourceLevel getPriceDecEvent() { return priceDecEvent; }

    /**
     * @return when present, price of resource is unusually expensive
     */
    public ResourceLevel getPriceIncEvent() { return priceIncEvent; }
}
