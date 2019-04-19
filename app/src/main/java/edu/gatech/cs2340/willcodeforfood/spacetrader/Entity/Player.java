package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;

/**
 * Represents a Player
 *
 * @author Matt Bernet
 * @version 1.4
 */
public class Player implements Serializable {

    private String name;
    private int skillPoints;
    private int credits;
    private final Ship ship;
    private int[] skills;
    private int wantedLevel;

    private static final int FINE_MULTIPLIER = 100;

    /**
     * Initializes a player
     *
     * @param name player name
     * @param skillPoints player skill points
     * @param pilot pilot skill level
     * @param fighter fighter skill level
     * @param trader trader skill level
     * @param engineer engineer skill level
     */
    public Player(String name, int skillPoints, int pilot,
                  int fighter, int trader, int engineer) {
        this.name = name;
        this.skillPoints = skillPoints;
        credits = 1000;
        ship = new Ship(ShipType.GNAT);
        skills = new int[]{pilot, fighter, trader, engineer};
        wantedLevel = 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Skills: Pilot %d, Fighter %d, Trader %d, Engineer %d",
                name, skills[0], skills[1], skills[2], skills[3]);
    }

    /**
     * @return player fine
     */
    public int calcFine() {
        return wantedLevel * FINE_MULTIPLIER;
    }

    /**
     * @return player name
     */
    public String getName() { return name; }

    /**
     * Sets player name
     *
     * @param name new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * @return player skill points
     */
    public int getSkillPoints() { return skillPoints; }

    /**
     * Sets player skill points
     *
     * @param skillPoints new skill point amount
     */
    public void setSkillPoints(int skillPoints) { this.skillPoints = skillPoints; }

    /**
     * @return player credits
     */
    public int getCredits() { return credits; }

    /**
     * Sets player credits
     *
     * @param credits new credit amount
     */
    public void setCredits(int credits) { this.credits = credits; }

    /**
     * @return player ship
     */
    public Ship getShip() { return ship; }

    /**
     * @return player skills
     */
    public int[] getSkills() { return skills; }

    /**
     * Sets player skills
     *
     * @param skills new skills
     */
    public void setSkills(int[] skills) { this.skills = skills; }

    /**
     * @return ship cargo
     */
    public Cargo getCargo() { return ship.getCargo(); }

    /**
     * @return player wanted level
     */
    public int getWantedLevel() { return wantedLevel; }

    /**
     * Sets player wanted level
     *
     * @param level new level
     */
    public void setWantedLevel(int level) { wantedLevel = level; }
}
