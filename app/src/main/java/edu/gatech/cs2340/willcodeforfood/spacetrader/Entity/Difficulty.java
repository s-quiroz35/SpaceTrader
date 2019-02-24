package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Game Difficulty
 *
 * @author Matt Bernet
 * @version 1.0
 */
public enum Difficulty {
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    public String difficulty;

    /**
     * Constructor for Difficulty enumeration
     *
     * @param diff difficulty
     */
    Difficulty(String diff) {
        difficulty = diff;
    }

    /**
     * @return difficulty
     */
    public String getDifficulty() { return difficulty; }
}
