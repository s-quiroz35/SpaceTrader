package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;


/**
 * Represents a Ship
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Ship implements Serializable {

    private final ShipType type;
    private String color;
    private int fuel;
    private final Cargo cargo;

    /**
     * Initializes a Ship
     *
     * @param type ship type
     * @param color ship color
     */
    public Ship(ShipType type, String color) {
        this.type = type;
        this.color = color;
        fuel = type.getFuelCapacity();
        cargo = new Cargo();
    }

    /**
     * @return ship type
     */
    public ShipType getType() { return type; }

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
    public int getFuelCapacity() { return type.getFuelCapacity(); }

    /**
     *
     * @return ship fuel contents
     */
    public int getFuel() { return fuel;}

    /**
     * Sets the fuel contents
     * @param fuel new fuel
     */
    public void setFuel(int fuel) {this.fuel = fuel;}

    /**
     * @return ship cargo
     */
    public Cargo getCargo() { return cargo; }

}
