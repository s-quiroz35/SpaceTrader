package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Good
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Good {

    private GoodType type;

    /**
     * Initializes a Good
     *
     * @param type type of good
     */
    public Good(GoodType type) {
        this.type = type;
    }

    /**
     * @return name of resource
     */
    public String getGoodName() { return type.getName(); }
}
