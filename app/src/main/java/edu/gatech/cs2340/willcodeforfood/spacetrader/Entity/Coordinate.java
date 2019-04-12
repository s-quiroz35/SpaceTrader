package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Coordinates in the system
 *
 * @author Emma Chadwick and Matt Bernet
 * @version 1.2
 */
public class Coordinate implements Serializable {
    private final int xCor;
    private final int yCor;
    private final static List<Integer> xCoordinates = new ArrayList<>();
    private final static List<Integer> yCoordinates = new ArrayList<>();

    /**
     * Creates a new unique coordinate
     */
    public Coordinate() {
        Random rn = new Random();

        int x = rn.nextInt(151);
        while(xCoordinates.contains(x)) {
            x = rn.nextInt(151);
        }

        int y = rn.nextInt(101);
        while(yCoordinates.contains(y)) {
            y = rn.nextInt(101);
        }

        xCoordinates.add(x);
        yCoordinates.add(y);

        xCor = x;
        yCor = y;
    }

    /**
     * @return the x coordinate of the system
     */
    public int getXCor() { return xCor; }

    /**
     * @return the y coordinate of the system
     */
    public int getYCor() { return yCor; }
}
