package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

/**
 * Narcotics Good class
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Narcotics extends Good {

    /**
     * Narcotics constructor
     */
    public Narcotics() {
        super(5, 0, 5, 3500,
                -125, 150, ResourceLevel.WEIRDMUSHROOMS);
    }
}
