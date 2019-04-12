package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;

/**
 * Represents a game
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Game implements Serializable {

    private final Player player;
    private Difficulty difficulty;
    private final Universe universe;

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
     * @return universe of this game
     */
    public Universe getUniverse() { return universe; }
}
