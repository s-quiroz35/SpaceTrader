package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Business logic interface (interactor setup)
 *
 * @author Matt Bernet
 * @version 1.1
 */
public class Model {

    private Repository repo;

    private Map<String, Object> iMap;

    //creates universal access
    private static Model instance = new Model();

    /**
     * @return model instance
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * Initializes model
     */
    private Model() {
        repo = new Repository();
        iMap = new HashMap<>();
        createInteractors();
    }

    /**
     * Create interactors
     */
    private void createInteractors() {
        iMap.put("Game", new GameInteractor(repo));
    }

    /**
     * @return the game interactor
     */
    public GameInteractor getGameInteractor() {
        return (GameInteractor) iMap.get("Game");
    }

}
