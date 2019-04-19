package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents Police officer
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Police {
    //Exact same as pirate right now, but separate entity to support additions in future
    private int health;
    private WeaponType weaponType;

    private static final int BASE_HEALTH = 500;

    /**
     * Initializes a police officer
     */
    Police() {
        //this should vary eventually
        health = BASE_HEALTH;
        weaponType = WeaponType.MILITARYLASERS;
    }

    /**
     * @return police health
     */
    public int getHealth() { return health; }

    /**
     * @return police weapon
     */
    public WeaponType getWeaponType() { return weaponType; }

    /**
     * Set police health
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
