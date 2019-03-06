package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;
/**
 * Furs Good Class
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class Furs extends Good {

    /**
     * Fur constructor
     */
    public Furs() {
        super(0, 0, 0, 250,
                10, 10, ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS);
    }
}
