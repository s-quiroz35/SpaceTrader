package edu.gatech.cs2340.willcodeforfood.spacetrader.Services;

/**
 * Low Point Service Call
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class LowPointService extends ErrorService {

    public LowPointService(String s) {
        super(s);
    }

    @Override
    public String callService() {
        return "You must use all skill points to create character";
    }

}
