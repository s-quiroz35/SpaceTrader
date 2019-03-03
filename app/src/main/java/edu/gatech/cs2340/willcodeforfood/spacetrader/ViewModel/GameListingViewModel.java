package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Game;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.GameInteractor;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for game list
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class GameListingViewModel extends AndroidViewModel {

    private GameInteractor interactor;

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public GameListingViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getGameInteractor();
    }

    /**
     * @return the games from the model
     */
    public List<Game> getGames() { return interactor.getGames(); }
}