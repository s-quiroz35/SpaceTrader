package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Player;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;

/**
 * Represents total data storage
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class Repository {

    private List<Player> players;
    private List<Universe> universeList;
    private List<SolarSystem> solarSystem;

    /**
     * Initializes repo
     */
    public Repository() {
        players = new ArrayList<>();
        universeList = new ArrayList<>();
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

    /**
     * Initializes Universe
     *
     * @param u new universe
     */
    public void addUniverse(Universe u) {
        universeList.add(u);
        solarSystem = u.getSolarSystems();
        for (int i = 0; i < solarSystem.size(); i++) {
            SolarSystem s = solarSystem.get(i);
            Log.w("Added", "New solar system added: " + s.toString());
        }
    }

    /**
     *
     * @return all universes
     */
    public List<Universe> getUniverse() { return universeList; }
}
