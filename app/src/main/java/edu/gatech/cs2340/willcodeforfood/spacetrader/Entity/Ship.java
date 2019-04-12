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
    private int fuel;
    private final Cargo cargo;

    /**
     * Initializes a Ship
     *
     * @param type ship type
     */
    public Ship(ShipType type) {
        this.type = type;
        fuel = type.getFuelCapacity();
        cargo = new Cargo();
    }

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
