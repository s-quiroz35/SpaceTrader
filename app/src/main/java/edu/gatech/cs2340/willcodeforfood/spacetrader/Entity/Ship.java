package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Ship
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Ship {

    private String name;
    private String color;
    private int fuelCapacity;
    private int fuel;

    /**
     * Initializes a Ship
     *
     * @param name ship name
     * @param color ship color
     * @param fuelCapacity max fuel
     */
    public Ship(String name, String color, int fuelCapacity) {
        this.name = name;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
        fuel = fuelCapacity;
    }

    /**
     * @return ship name
     */
    public String getName() { return name; }

    /**
     * @return ship color
     */
    public String getColor() { return color; }

    /**
     * Sets ship color
     *
     * @param color new color
     */
    public void setColor(String color) { this.color = color; }

    /**
     * @return ship fuel capacity
     */
    public int getFuelCapacity() { return fuelCapacity; }

    /**
     * @return ship fuel
     */
    public int getFuel() { return fuel; }

    /**
     * Sets ship fuel
     *
     * @param fuel new fuel amount
     */
    public void setFuel(int fuel) { this.fuel = fuel; }
}
