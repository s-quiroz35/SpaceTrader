package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Solar system tech level
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum TechLevel {
    PREAGRICULTURE("Pre-Agriculture", 0),
    AGRICULTURE("Agriculture", 1),
    MEDIEVAL("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLYINDUSTRIAL("Early Industrial", 4),
    INDUSTRIAL("Industrial", 5),
    POSTINDUSTRIAL("Post-Industrial", 6),
    HITECH("High Tech", 7);

    private String name;
    private int level;

    /**
     * Constructor for TechLevel enumeration
     *
     * @param level tech level
     */
    TechLevel(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * @return difficulty
     */
    public int getTechLevel() { return level; }

    public String getName() { return name; }
}
