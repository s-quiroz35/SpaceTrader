package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import android.util.Log;

import java.util.List;
import java.util.ArrayList;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Planet;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.SolarSystem;

/**
 * Represents total data storage
 *
 * @author Matt Bernet
 * @version 1.1
 */
public class Repository {

    private List<Game> games;

    /**
     * Initializes repo
     */
    public Repository() {
        games = new ArrayList<>();
    }

    /**
     * Adds a new game
     *
     * @param game new game
     */
    public void addGame(Game game) {
        games.add(game);
        Log.w("Add", String.format("Game created: %s, %s", game.getPlayer().getName()
                , game.getDifficulty()));
        Log.w("Add", String.format("Universe created: MaxX: %d, MaxY: %d", game.getUniverse()
                .getMaxLength(), game.getUniverse().getMaxWidth()));
        for (SolarSystem ss: game.getUniverse().getSolarSystems()) {
            Log.w("Add", String.format("Solar system created: ", ss.toString()));
            for (Planet p: ss.getPlanets()) {
                Log.w("Add", String.format("Planet created: ", p.toString()));
            }
        }
    }

    /**
     * @return all games
     */
    public List<Game> getGames() { return games; }
}
