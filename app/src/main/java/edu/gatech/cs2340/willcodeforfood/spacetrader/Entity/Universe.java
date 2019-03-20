package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Universe
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class Universe {

    private List<SolarSystem> solarSystems;

    private final int maxX = 150;
    private final int maxY = 100;

    private SolarSystem currentSolarSystem;
    private Planet currentPlanet;

    private static final ArrayList<String> openNames = new ArrayList<>(Arrays.asList("Aldea", "Andevian", "Antedi", "Balosnee", "Baratas", "Brax", "Bretel", "Calondia",
            "Campor", "Capelle", "Carzon", "Castor", "Cestus", "Cheron", "Courteney", "Daled",  "Deneb",
            "Deneva", "Davidia", "Draylon", "Drema", "Endor", "Esmee", "Fourmi", "Helena", "Hulst",
            "Iodine", "Iralius", "Janus", "Japori", "Jarada", "Jason", "Kaylon", "Klaestron", "Korma",
            "Kravat", "Largo", "Lave", "Ligon", "Lowry", "Montor", "Mordan", "Myrthe", "Nelvana", "Nix",
            "Nyle", "Odet", "Othello", "Parade", "Penthara", "Picard", "Pollux",	  "Ran", "Rhymus",
            "Rochani", "Rubicum", "Rutia", "Sarpeidon", "Sefalla", "Seltrice", "Somari", "Stakoron", "Styris",
            "Talani", "Tamus", "Tantalos", "Tanuga", "Tarchannen", "Terosa", "Thera", "Titan", "Torin", "Triacus",
            "Turkana", "Tyrus",  "Vadera", "Vagra", "Vandor", "Ventax", "Xenon", "Xerxes", "Yew", "Zuul"));

    /**
     * Initializes a universe
     */
    public Universe() {
        Random rn = new Random();

        solarSystems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
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
        String string = "Universe Created: Width: " + maxX + ", Height: " + maxY + ", Contains the solar systems: " + "\n";
        for (SolarSystem s : solarSystems) {
            string = string + s.toString() + "\n";
        }
        return string;
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
}
