package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

/**
 * Firearms Good class
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Firearms extends Good {

    /**
     * Firearms constructor
     */
    public Firearms() {
        super(3, 1, 5, 1250,
                -75, 100, ResourceLevel.WARLIKE);
    }
}
