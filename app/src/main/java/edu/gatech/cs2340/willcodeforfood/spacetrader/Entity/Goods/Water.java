package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

/**
 * Water Good class
 */
public class Water extends Good {

    /**
     * Water constructor
     */
    public Water () {
        super(0, 0, 2, 30, 3,
                4, ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT);
    }
}
