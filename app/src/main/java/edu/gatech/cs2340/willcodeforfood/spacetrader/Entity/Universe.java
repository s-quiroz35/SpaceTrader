package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Universe
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Universe {

    private List<SolarSystem> solarSystems;

    private final int maxX = 150;
    private final int maxY = 100;

    /**
     * Initializes a universe
     */
    public Universe() {
        solarSystems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            solarSystems.add(new SolarSystem());
        }
    }

    /**
     * @return solar systems
     */
    public List<SolarSystem> getSolarSystems() { return solarSystems; }

    /**
     * @return max length
     */
    public int getMaxLength() { return maxX; }

    /**
     * @return max width
     */
    public int getMaxWidth() {return maxY; }

    @Override
    public String toString() {
        String string = "The universe at the location " + maxX + ", " + maxY + " contains the solar systems: " + "\n";
        for (SolarSystem s : solarSystems) {
            string = string + s.toString() + "\n";
        }
        return string;
    }
}
