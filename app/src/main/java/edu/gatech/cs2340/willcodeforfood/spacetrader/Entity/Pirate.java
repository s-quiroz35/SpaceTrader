package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Pirate
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Pirate {
    private int health;
    private WeaponType weaponType;

    private static final int BASE_HEALTH = 100;

    /**
     * Initializes a Pirate
     */
    public Pirate() {
        //this should vary eventually
        health = BASE_HEALTH;
        weaponType = WeaponType.BEAMLASERS;
    }

    /**
     * @return pirate health
     */
    public int getHealth() { return health; }

    /**
     * @return pirate weapon
     */
    public WeaponType getWeaponType() { return weaponType; }

    /**
     * Set pirate health
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
