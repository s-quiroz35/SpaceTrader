package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a market item
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class MarketItem {
    private GoodType type;
    private int price;

    /**
     * Constructor for cargo item without specified amount
     *
     * @param type type of item
     */
    public MarketItem(GoodType type) {
        this(type, 20);
    }

    /**
     * Base constructor for cargo item
     *
     * @param type type of good
     * @param price good amount
     */
    public MarketItem(GoodType type, int price) {
        this.type = type;
        this.price = price;
    }

    /**
     * @return type of good
     */
    public GoodType getType() { return type; }

    /**
     * @return price of good
     */
    public int getPrice() { return price; }
}
