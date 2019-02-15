package edu.gatech.cs2340.willcodeforfood.spacetrader.Model;

/**
 * Represents a Player
 *
 * @author Matt Bernet
 * @version 1.0
 */
public class Player {

    private String name;
    private int skillPoints;
    private int[] skills;

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
        skills = new int[]{pilot, fighter, trader, engineer};
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Skills: Pilot %d, Fighter %d, Trader %d, Engineer %d",
                name, skills[0], skills[1], skills[2], skills[3]);
    }

    /**
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * @return player skill points
     */
    public int getSkillPoints() {
        return skillPoints;
    }

    /**
     * Sets player skill points
     *
     * @param skillPoints new skill point amount
     */
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    /**
     * @return player skills
     */
    public int[] getSkills() {
        return skills;
    }

    /**
     * Sets player skills
     *
     * @param skills new skills
     */
    public void setSkills(int[] skills) {
        this.skills = skills;
    }
}
