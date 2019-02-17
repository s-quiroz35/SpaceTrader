package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;

/**
 * Functionality for Player interaction
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class PlayerInteractor extends Interactor {

    /**
     * Initializes Player Interactor
     *
     * @param repo repository
     */
    public PlayerInteractor(Repository repo) { super(repo); }

    /**
     * Adds player to system
     *
     * @param player new player
     */
    public void addPlayer(Player player) { getRepo().addPlayer(player); }

    /**
     * @return all players
     */
    public List<Player> getPlayers() { return getRepo().getPlayers(); }
}