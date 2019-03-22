package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

/**
 * Represents a Ship
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Ship {

    private ShipType type;
    private String color;
    private int fuel;
    private Cargo cargo;

    /**
     * Initializes a Ship
     *
     * @param type ship type
     * @param color ship color
     */
    public Ship(ShipType type, String color) {
        this.type = type;
        this.color = color;
        fuel = type.getFuelCapacity();
        cargo = new Cargo();
    }

    /**
     * @return ship type
     */
    public ShipType getType() { return type; }

    /**
     * @return ship color
     */
    public String getColor() { return color; }

    /**
     * Sets ship color
     *
     * @param color new color
     */
    public void setColor(String color) { this.color = color; }

    /**
     * @return ship fuel capacity
     */
    public int getFuelCapacity() { return type.getFuelCapacity(); }

    /**
     * @return ship fuel
     */
    public int getFuel() { return fuel; }

    /**
     * Sets ship fuel
     *
     * @param fuel new fuel amount
     */
    public void setFuel(int fuel) { this.fuel = fuel; }

    public void spendFuel(int fuelCost) { fuel = fuel - fuelCost;}

    public int fuelPrice() {
        Planet currentPlanet = Model.getInstance().getCurrentPlanet();
        int techLevel = currentPlanet.getTechLevel().getTechLevel();

        return (int) (.6 * (techLevel + 2)) * 25;
    }

    public void buyFuel() {
        Planet currentPlanet = Model.getInstance().getCurrentPlanet();
        int techLevel = currentPlanet.getTechLevel().getTechLevel();

        int pricePerGallon = (int) ((.6 * techLevel) + 2);
        int fuelCapacity = this.getFuelCapacity();
        int credits = Model.getInstance().getPlayer().getCredits();
        int afterCredits = 0;
        if ((fuel + 25) <= fuelCapacity) {
            afterCredits = credits - (25 * pricePerGallon);
            if (afterCredits >= 0) {
                fuel += 25;
                Model.getInstance().getPlayer().setCredits(credits - (25 * pricePerGallon));
            }
        } else {
            int remainingFuel = fuelCapacity - fuel;
            afterCredits = credits - (remainingFuel * pricePerGallon);
            if (afterCredits >= 0) {
                fuel += remainingFuel;
                Model.getInstance().getPlayer().setCredits(afterCredits);
            }
        }
    }
    /**
     * @return ship cargo
     */
    public Cargo getCargo() { return cargo; }

}
