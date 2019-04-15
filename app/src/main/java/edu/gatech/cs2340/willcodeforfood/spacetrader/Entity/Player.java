package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Represents a Player
 *
 * @author Matt Bernet
 * @version 1.4
 */
public class Player implements Serializable {

    private final PlayerInit playerInit;
    private String name;
    private int skillPoints;
    private int credits;
    private final Ship ship;
    private int[] skills;

    /**
     * Initializes a player
     *
     * @param playerInit the name and skill points
     * @param pilot pilot skill level
     * @param fighter fighter skill level
     * @param trader trader skill level
     * @param engineer engineer skill level
     */
    public Player(PlayerInit playerInit, int pilot,
                  int fighter, int trader, int engineer) {
        this.playerInit = playerInit;
        credits = 1000;
        ship = new Ship(ShipType.GNAT);
        skills = new int[]{pilot, fighter, trader, engineer};
    }

    @Override
    @NonNull
    public String toString() {
        return String.format("Name: %s, Skills: Pilot %d, Fighter %d, Trader %d, Engineer %d",
                name, skills[0], skills[1], skills[2], skills[3]);
    }

    /**
     * @return player name
     */
    public String getName() { return playerInit.getName(); }

    /**
     * Sets player name
     *
     * @param name new name
     */
    public void setName(String name) { playerInit.setName(name); }

    /**
     * @return player skill points
     */
    public int getSkillPoints() { return playerInit.getSkillPoints(); }

    /**
     * Sets player skill points
     *
     * @param skillPoints new skill point amount
     */
    public void setSkillPoints(int skillPoints) { playerInit.setSkillPoints(skillPoints); }

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
    public int[] getSkills() { return skills.clone(); }

    /**
     * Sets player skills
     *
     * @param skills new skills
     */
    public void setSkills(int[] skills) { this.skills = skills.clone(); }

    /**
     * @return ship cargo
     */
    public Cargo getCargo() { return ship.getCargo(); }
}
