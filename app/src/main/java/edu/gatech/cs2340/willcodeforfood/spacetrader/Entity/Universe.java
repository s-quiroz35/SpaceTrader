package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Universe
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.3
 */
public class Universe implements Serializable {

    private final List<SolarSystem> solarSystems;

    private SolarSystem currentSolarSystem;
    private Planet currentPlanet;
    private Planet travelPlanet;

    private static final ArrayList<String> openNames = new ArrayList<>(Arrays.asList("Aldea",
            "Andevian", "Antedi", "Balosnee", "Baratas", "Brax", "Bretel", "Calondia", "Campor",
            "Capelle", "Carzon", "Castor", "Cestus", "Cheron", "Courteney", "Daled",  "Deneb",
            "Deneva", "Davidia", "Draylon", "Drema", "Endor", "Esmee", "Fourmi", "Helena", "Hulst",
            "Iodine", "Iralius", "Janus", "Japori", "Jarada", "Jason", "Kaylon", "Klaestron",
            "Korma", "Kravat", "Largo", "Lave", "Ligon", "Lowry", "Montor", "Mordan", "Myrthe",
            "Nelvana", "Nix", "Nyle", "Odet", "Othello", "Parade", "Penthara", "Picard", "Pollux",
            "Ran", "Rhymus", "Rochani", "Rubicum", "Rutia", "Sarpeidon", "Sefalla", "Seltrice",
            "Somari", "Stakoron", "Styris", "Talani", "Tamus", "Tantalos", "Tanuga", "Tarchannen",
            "Terosa", "Thera", "Titan", "Torin", "Triacus", "Turkana", "Tyrus",  "Vadera", "Vagra",
            "Vandor", "Ventax", "Xenon", "Xerxes", "Yew", "Zuul"));

    /**
     * Initializes a universe
     */
    public Universe() {
        Random rn = new Random();

        solarSystems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int index = rn.nextInt(openNames.size());
            String name = openNames.get(index);
            openNames.remove(index);
            solarSystems.add(new SolarSystem(name));
        }

        currentSolarSystem = solarSystems.get(0);
        currentPlanet = currentSolarSystem.getPlanets().get(0);
    }

    /**
     * @return solar systems
     */
    public List<SolarSystem> getSolarSystems() { return solarSystems; }

    @Override
    public String toString() {
        String string = "Universe Created: Contains the solar systems: " + "\n";
        for (SolarSystem s : solarSystems) {
            string = string + s.toString() + "\n";
        }
        return string;
    }

    /**
     *
     * @param p planet to travel to
     * @return total gallons of gas to travel
     */
    public int gasPrice(Planet p) {
        int xDifference = p.getXCor() - currentPlanet.getXCor();
        int yDifference = p.getYCor() - currentPlanet.getYCor();
        xDifference *= xDifference;
        yDifference *= yDifference;
        int totalDistance = xDifference + yDifference;
        totalDistance = (int)(Math.sqrt(totalDistance));
        return (int)(totalDistance * 1.4);
    }

    /**
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() { return currentSolarSystem; }

    /**
     * Sets current solar system
     *
     * @param s new solar system
     */
    public void setCurrentSolarSystem(SolarSystem s) { currentSolarSystem = s; }

    /**
     * @return current planet
     */
    public Planet getCurrentPlanet() { return currentPlanet; }

    /**
     * Sets current planet
     *
     * @param p new planet
     */
    public void setCurrentPlanet(Planet p) { currentPlanet = p; }

    /**
     * @return current planet
     */
    public Planet getTravelPlanet() { return travelPlanet; }

    /**
     * Sets current planet
     *
     * @param p new planet
     */
    public void setTravelPlanet(Planet p) { travelPlanet = p; }
}
