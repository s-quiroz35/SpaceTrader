package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Represents a Player
 *
 * @author Matt Bernet
 * @version 1.4
 */
public class Player {

    private String name;
    private int skillPoints;
    private int credits;
    private Ship ship;
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
        credits = 1000;
        ship = new Ship(ShipType.GNAT, "black");
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
     * Sets player ship
     *
     * @param ship new ship
     */
    public void setShip(Ship ship) { this.ship = ship; }

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

//    /**
//     * Buying a good from a Trader. I have it as returning a boolean that
//     * says if the trade was successful or not, maybe Exceptions
//     * would be better for telling why a trade was unsuccessful but
//     * this should work fine.
//     *
//     * @param trader The current trader that player is interacting with
//     * @param good The good you want to buy
//     * @param quantity The amount of good you want to buy
//     * @return Whether the trade was successful or not
//     */
//    public boolean buy(Trader trader, Good good, int quantity) {
//        if (trader == null) {
//            return false;
//        }
//        if (trader.getInventory().containsKey(good)
//                    && quantity <= trader.getGoodQuantity(good)) {
//            if (credits - trader.getGoodPrice(good) * quantity < 0) {
//                return false;
//            } else {
//                credits -= trader.getGoodPrice(good) * quantity;
//                return cargo.put(good, quantity) && trader.getCargo().remove(good, quantity);
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Selling a good to a trader
//     *
//     * @param trader The current trader that player is interacting with
//     * @param good The good you want to sell
//     * @param quantity The amount of good you want to sell
//     * @return Whether the trade was successful or not
//     */
//    public boolean sell(Trader trader, Good good, int quantity) {
//        if (trader == null) {
//            return false;
//        }
//        if (trader.getTechLevel() >= good.getMinTechLvlUse()) {
//            boolean b = cargo.remove(good, quantity);
//            if (b) {
//                credits -= trader.getGoodPrice(good) * quantity;
//            }
//            return b;
//        }
//        return false;
//    }
}
