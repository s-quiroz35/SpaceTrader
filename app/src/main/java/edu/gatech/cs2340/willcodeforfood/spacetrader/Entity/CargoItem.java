package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a cargo item
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class CargoItem {

    private GoodType type;
    private int amount;

    /**
     * Constructor for cargo item without specified amount
     *
     * @param type type of item
     */
    public CargoItem(GoodType type) {
        this(type, 0);
    }

    /**
     * Base constructor for cargo item
     *
     * @param type type of good
     * @param amount good amount
     */
    public CargoItem(GoodType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * @return type of good
     */
    public GoodType getType() { return type; }

    /**
     * @return good amount
     */
    public int getAmount() { return amount; }

    /**
     * Sets amount to new value
     *
     * @param amount new amount
     */
    public void setAmount(int amount) { this.amount = amount; }
}
