package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;

/**
 * Represents a game
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Game implements Serializable {

    private Player player;
    private Difficulty difficulty;
    private Universe universe;

    /**
     * Initializes a new game
     *
     * @param player player
     * @param diff difficulty
     * @param universe universe
     */
    public Game(Player player, Difficulty diff, Universe universe) {
        this.player = player;
        this.difficulty = diff;
        this.universe = universe;
    }

    /**
     * @return player in this game
     */
    public Player getPlayer() { return player; }

    /**
     * @return difficulty of this game
     */
    public Difficulty getDifficulty() { return difficulty; }

    /**
     * Change game difficulty
     *
     * @param diff new difficulty
     */
    public void setDifficulty(Difficulty diff) { this.difficulty = diff; }

    /**
     * @return universe of this game
     */
    public Universe getUniverse() { return universe; }
}
