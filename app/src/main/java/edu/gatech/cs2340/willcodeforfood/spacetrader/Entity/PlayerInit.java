package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Holds general attributes for player
 */
public class PlayerInit {

    private String name;
    private int skillPoints;

    /**
     * Initializes a PlayerInit
     * @param name player's name
     */
    public PlayerInit(String name) {
        this.name = name;
        skillPoints = 16;
    }

    /**
     * @return total skill points
     */
    public int getSkillPoints() {
        return skillPoints;
    }


    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the skill points
     * @param skillPoints the number of skill points
     */
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
}
