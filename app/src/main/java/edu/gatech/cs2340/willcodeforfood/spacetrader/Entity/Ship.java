package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * Represents a Ship
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Ship implements Serializable {

    private ShipType type;
    private String color;
    private int fuel;
    private Cargo cargo;

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
    public int getFuelCapacity() { return fuel; }

    /**
     * @return ship cargo
     */
    public Cargo getCargo() { return cargo; }

}
