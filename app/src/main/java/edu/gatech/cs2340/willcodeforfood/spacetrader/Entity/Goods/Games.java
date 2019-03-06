package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

/**
 * Games Good class
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Games extends Good {

    /**
     * Games constructor
     */
    public Games() {
        super(3, 1, 6, 250,
                -10, 5, ResourceLevel.ARTISTIC);
    }
}
