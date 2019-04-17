package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Types of weapons
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum WeaponType {
    PULSELASERS("Pulse Lasers", 25),
    BEAMLASERS("Beam Lasers", 50),
    MILITARYLASERS("Military Lasers", 100);

    private final String name;
    private final int damage;

    /**
     * Constructor for Weapon enumeration
     *
     * @param name weapon name
     * @param damage weapon damage
     */
    WeaponType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    /**
     * @return weapon name
     */
    public String getWeaponName() { return name; }

    /**
     * @return weapon damage
     */
    public int getWeaponDamage() { return damage; }
}
