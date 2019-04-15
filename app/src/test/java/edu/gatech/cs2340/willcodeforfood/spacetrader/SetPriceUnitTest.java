package edu.gatech.cs2340.willcodeforfood.spacetrader;

import org.junit.Test;

import java.util.Random;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.GoodType;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.ResourceLevel;
import edu.gatech.cs2340.willcodeforfood.spacetrader.Entity.TechLevel;

import static org.junit.Assert.assertEquals;

/**
 * Set Price Test
 *
 * @author Sam Quiroz
 * @version 1.0
 */
public class SetPriceUnitTest {

    @Test
    public void testSetPrice() {

        GoodType good = GoodType.FOOD;
        Random rn = new Random((long) 2);
        int randomInt = rn.nextInt(good.variance());
        randomInt = randomInt / 100;
        good.setPrice(TechLevel.MEDIEVAL, ResourceLevel.NOSPECIALRESOURCES);
        assertEquals(115 + (100 * randomInt), good.getPrice());
        good.setPrice(TechLevel.MEDIEVAL, ResourceLevel.POORSOIL);
        assertEquals(230 + 200 * randomInt, good.getPrice());
        good.setPrice(TechLevel.MEDIEVAL, ResourceLevel.RICHSOIL);
        assertEquals((115 + 100 * randomInt) / 2, good.getPrice());

    }

}
