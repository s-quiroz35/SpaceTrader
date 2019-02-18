package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;

/**
 * Represents total data storage
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Repository {

    private List<Player> players;

    /**
     * Initializes repo
     */
    public Repository() {
        players = new ArrayList<>();
    }

    /**
     * Adds a new player
     *
     * @param player new player
     */
    public void addPlayer(Player player) {
        players.add(player);
        Log.w("Add", "New player added: " + player.toString());
    }

    /**
     * @return all players
     */
    public List<Player> getPlayers() { return players; }
}
