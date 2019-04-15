package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Type of Good
 *
 * @author Sam Quiroz and Matt Bernet
 * @version 1.1
 */
public enum GoodType {
    WATER("Water", 0, new GoodTypeInts(0, 0, 2,
            30, 3, 4),
            ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT),
    FURS("Furs", 0, new GoodTypeInts(0, 0, 0,
            250, 10, 10),
            ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS),
    FOOD("Food", 0, new GoodTypeInts(1, 0, 1,
            100, 5, 5), ResourceLevel.RICHSOIL, ResourceLevel.POORSOIL),
    ORE("Ore", 0, new GoodTypeInts(2, 2, 3, 350,
            20, 10), ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR),
    GAMES("Games", 0, new GoodTypeInts(3, 1, 6,
            250, -10, 5), ResourceLevel.ARTISTIC),
    FIREARMS("Firearms", 0, new GoodTypeInts(3, 1, 5,
            1250, -75, 100), ResourceLevel.WARLIKE),
    MEDICINE("Medicine", 0, new GoodTypeInts(4, 1, 6,
            650, -20, 10), ResourceLevel.LOTSOFHERBS),
    MACHINE("Machine", 0, new GoodTypeInts(4, 3, 5,
            900, -30, 5)),
    NARCOTICS("Narcotics", 0, new GoodTypeInts(5, 0 ,5,
            3500, -125, 150), ResourceLevel.WEIRDMUSHROOMS),
    ROBOTS("Robots", 0, new GoodTypeInts(6, 4, 7,
            5000, -150, 100));

    private final String name;
    private int planetPrice;
    private final GoodTypeInts theInts;
    private final ResourceLevel priceDecEvent;
    private final ResourceLevel priceIncEvent;

    /**
     * Constructor for no price increase or decrease events
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param theInts all integer values associated with the good's price
     */
    GoodType(String name, int planetPrice, GoodTypeInts theInts) {
        this(name, planetPrice, theInts, ResourceLevel.NOSPECIALRESOURCES,
                ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Constructor for no price increase event
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param theInts all integer values associated with the good's price
     * @param priceDecEvent when present, price of resource is unusually low
     */
    GoodType(String name, int planetPrice, GoodTypeInts theInts,
             ResourceLevel priceDecEvent) {
        this(name, planetPrice, theInts, priceDecEvent, ResourceLevel.NOSPECIALRESOURCES);
    }

    /**
     * Base constructor for Good Type
     *
     * @param name name of good
     * @param planetPrice price of good on current planet
     * @param theInts all integer values associated with price
     * @param priceDecEvent when present, price of resource is unusually low
     * @param priceIncEvent when present, price of resource is unusually expensive
     */
    GoodType(String name, int planetPrice, GoodTypeInts theInts,
             ResourceLevel priceDecEvent, ResourceLevel priceIncEvent) {
        this.name = name;
        this.planetPrice = planetPrice;
        this.theInts = theInts;
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
        int var = rn.nextInt(variance());
        var = var / 100;
        int price = basePrice() + (priceIncPerLevel() * (t.getTechLevel()
                + theInts.getMinTechToProduce())) + (basePrice() * var);
        if (getResourceLevel(r) == getResourceLevel(priceIncEvent)) {
            price *= 2;
        } else if (getResourceLevel(r) == getResourceLevel(priceDecEvent)) {
            price /= 2;
        }

        planetPrice = price;
    }

    /**
     * @return The good's base price
     */
    private int basePrice() {
        return theInts.getBasePrice();
    }

    /**
     * @return the price increase per level
     */
    private int priceIncPerLevel() {
        return theInts.getBasePrice();
    }

    /**
     * @return the good's price variance
     */
    private int variance() {
        return theInts.getVariance();
    }

    /**
     * Returns an integer representation of a ResourceLevel
     *
     * @param r The ResourceLevel
     * @return an integer resource level
     */
    private int getResourceLevel(ResourceLevel r) {
        return r.getResourceLevel();
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
    public boolean canBuy(TechLevel t) { return t.getTechLevel() >= theInts.getMinTechToProduce(); }

    /**
     * Determines whether can sell on planet
     *
     * @param t planet tech level
     * @return true if able to sell, false otherwise
     */
    public boolean canSell(TechLevel t) { return t.getTechLevel() >= theInts.getMinTechToUse(); }

    /**
     * @return name of good
     */
    public String getName() { return name; }
}
