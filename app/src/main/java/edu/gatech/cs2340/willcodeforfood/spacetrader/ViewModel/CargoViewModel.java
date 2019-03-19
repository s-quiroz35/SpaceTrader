package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Cargo;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * View model for cargo
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class CargoViewModel extends AndroidViewModel {

    /**
     * Initializes the view model
     *
     * @param application the application
     */
    public CargoViewModel(@NonNull Application application) {
        super(application);
    }

    public Cargo getCargo() { return Model.getInstance().getCargo(); }
}
