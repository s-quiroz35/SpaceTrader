package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Ore extends Good {
    public Ore() {
        super(2, 2, 3, 350,
                20, 10, ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR);
    }
}
