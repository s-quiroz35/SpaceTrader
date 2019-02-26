package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

/**
 * Interactor interface
 *
 * @author Matt Bernet
 * @version 1.0
 */
public abstract class Interactor {

    private Repository repo;

    /**
     * Initializes Interactor
     *
     * @param repo repository
     */
    public Interactor(Repository repo) { this.repo = repo; }

    /**
     * @return repository
     */
    public Repository getRepo() { return repo; }
}
