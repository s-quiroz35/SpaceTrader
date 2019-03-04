package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Games extends Good {
    public Games() {
        super(3, 1, 6, 250,
                -10, 5, ResourceLevel.ARTISTIC);
    }
}
