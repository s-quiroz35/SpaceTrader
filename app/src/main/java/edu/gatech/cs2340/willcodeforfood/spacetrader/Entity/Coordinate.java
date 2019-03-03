package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Coordinates in the system
 *
 * @author Emma Chadwick
 * @version 1.0
 */
public class Coordinate {
    private int xCor;
    private int yCor;


    /**
     * Creates a new coordinate
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Coordinate(int x, int y) {
        xCor = x;
        yCor = y;
    }

    /**
     *
     * @return the x coordinate of the system
     */
    public int getXCor() { return xCor; }

    /**
     *
     * @return the y coordinate of the system
     */
    public int getYCor() { return yCor; }

}
