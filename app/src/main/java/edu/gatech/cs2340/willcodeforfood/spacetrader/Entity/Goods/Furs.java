package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Furs extends Good {
    public Furs() {
        super(0, 0, 0, 250,
                10, 10, ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS);
    }
}
