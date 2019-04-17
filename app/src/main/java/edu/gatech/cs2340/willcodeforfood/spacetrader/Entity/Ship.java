package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;


/**
 * Represents a Ship
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.4
 */
public class Ship implements Serializable {

    private ShipType type;
    private WeaponType weaponType;
    private int fuel;
    private final Cargo cargo;
    private int health;

    private static final int STARTING_HEALTH = 500;

    /**
     * Initializes a Ship
     *
     * @param type ship type
     */
    public Ship(ShipType type) {
        this.type = type;
        this.weaponType = WeaponType.PULSELASERS;
        fuel = type.getFuelCapacity();
        cargo = new Cargo();
        health = STARTING_HEALTH;
    }

    /**
     * @return ship weapon
     */
    public WeaponType getWeaponType() { return weaponType; }

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

    /**
     * @return ship health
     */
    public int getHealth() { return health; }

    /**
     * Sets ship health
     *
     * @param health new health amount
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            this.health = 0;
        }
    }
}
