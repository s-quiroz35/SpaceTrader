package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Solar system resource level
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum ResourceLevel {
    NOSPECIALRESOURCES(0),
    MINERALRICH(1),
    MINERALPOOR(2),
    DESERT(3),
    LOTSOFWATER(4),
    RICHSOIL(5),
    POORSOIL(6),
    RICHFAUNA(7),
    LIFELESS(8),
    WEIRDMUSHROOMS(9),
    LOTSOFHERBS(10),
    ARTISTIC(11),
    WARLIKE(12);

    private int level;

    /**
     * Constructor for ResourceLevel enumeration
     *
     * @param level resource level
     */
    ResourceLevel(int level) {
        this.level = level;
    }

    /**
     * @return resource level
     */
    public int getResourceLevel() { return level; }
}
