package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Goods;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.Good;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;

public class Food extends Good {
    public Food() {
        super(1, 0, 1, 100,
                5, 5, ResourceLevel.RICHSOIL, ResourceLevel.POORSOIL);
    }
}
