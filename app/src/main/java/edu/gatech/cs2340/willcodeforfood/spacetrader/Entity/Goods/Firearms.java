package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Firearms extends Good {
    public Firearms() {
        super(3, 1, 5, 1250,
                -75, 100, ResourceLevel.WARLIKE);
    }
}
