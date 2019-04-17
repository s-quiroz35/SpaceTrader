package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Pirate
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Pirate {
    private int health;
    private int damage;
    private boolean isDead;

    private static final int BASE_HEALTH = 100;
    private static final int BASE_DAMAGE = 10;

    /**
     * Initializes a Pirate
     */
    public Pirate() {
        //this will vary eventually
        health = BASE_HEALTH;
        damage = BASE_DAMAGE;
        isDead = false;
    }

    /**
     * @return pirate health
     */
    public int getHealth() { return health; }

    /**
     * @return pirate damage
     */
    public int getDamage() { return damage; }

    /**
     * @return whether pirate is dead or not
     */
    public boolean getIsDead() { return isDead; }

    /**
     * Set pirate health
     *
     * @param health new health amount
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            this.health = 0;
            isDead = true;
        }
    }
}
