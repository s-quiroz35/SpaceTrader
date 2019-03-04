package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Medicine extends Good {
    public Medicine() {
        super(4, 1, 6, 650,
                -20, 10, ResourceLevel.LOTSOFHERBS);
    }
}
