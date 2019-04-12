package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Tech level
 *
 * @author Matt Bernet
 * @version 1.1
 */
public enum TechLevel {
    PREAGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLYINDUSTRIAL(4),
    INDUSTRIAL(5),
    POSTINDUSTRIAL(6),
    HITECH(7);

    private final int level;

    /**
     * Constructor for TechLevel enumeration
     *
     * @param level tech level
     */
    TechLevel(int level) {
        this.level = level;
    }

    /**
     * @return difficulty
     */
    public int getTechLevel() { return level; }
}
