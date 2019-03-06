package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

/**
 * Ore Good class
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Ore extends Good {

    /**
     * Ore constructor
     */
    public Ore() {
        super(2, 2, 3, 350,
                20, 10, ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR);
    }
}
