package edu.gatech.cs2340.willcodeforfood.spacetrader.Services;


/**
 * Error Service Abstract Class
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public abstract class ErrorService {

    protected String request;

    public ErrorService (String r) {
        request = r;
    }

    public abstract String callService();
}
