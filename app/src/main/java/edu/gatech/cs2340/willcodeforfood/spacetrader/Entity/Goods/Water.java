package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Water extends Good {
    public Water () {
        super(0, 0, 2, 30, 3,
                4, ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT);
    }
}
