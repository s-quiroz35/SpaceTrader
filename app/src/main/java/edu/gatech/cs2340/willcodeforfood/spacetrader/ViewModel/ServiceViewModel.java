package edu.gatech.cs2340.willcodeforfood.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Services.ErrorService;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Services.LowPointService;


/**
 * Service View Model
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class ServiceViewModel extends AndroidViewModel {

    public ServiceViewModel (@NonNull Application application) { super(application); }

    public String makeLowPointRequest(String request) {
        ErrorService lowPoint = new LowPointService(request);
        return lowPoint.callService();
    }
}
