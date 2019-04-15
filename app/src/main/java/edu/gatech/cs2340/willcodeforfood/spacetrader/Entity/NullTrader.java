package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * A null kind of trader used in market adapters
 */
public class NullTrader extends Trader{

    @Override
    public boolean isNull() { return true; }
}
