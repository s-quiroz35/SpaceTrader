package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Universe;


/**
 * Functionality for universe interaction
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class UniverseInteractor extends Interactor{

    /**
     * Initializes Universe Iteractor
     * @param repo repository
     */
    public UniverseInteractor(Repository repo) {
        super(repo);
    }

    /**
     * Adds player to system
     * @param universe new universe
     */
    public void addUniverse(Universe universe) {
        getRepo().addUniverse(universe);
    }

    /**
     *
     * @return all universes
     */
    public List<Universe> getUniverse() {
        return getRepo().getUniverse();
    }
}
