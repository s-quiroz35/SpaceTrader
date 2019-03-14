package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * Represents a cargo item
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class CargoItem {

    private GoodType type;
    private int amount;
    private int price;

    /**
     * Constructor for cargo item without specified amount
     *
     * @param type type of item
     */
    public CargoItem(GoodType type) {
        this(type, 0, 0);
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
     * Base constructor for cargo item
     *
     * @param type type of good
     * @param amount good amount
     */
    public CargoItem(GoodType type, int amount, int price) {
        this.type = type;
        this.amount = amount;
        this.price = price;
    }

    /**
     * @return type of good
     */
    public GoodType getType() { return type; }

    public int getPrice() { return price; }
    /**
     * @return good amount
     */
    public int getAmount() { return amount; }

    public void setPrice(int price) { this.price = price; }

    /**
     * Sets amount to new value
     *
     * @param amount new amount
     */
    public void setAmount(int amount) { this.amount = amount; }
}
