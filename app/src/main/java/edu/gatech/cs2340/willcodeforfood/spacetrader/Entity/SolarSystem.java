package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Solar System
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class SolarSystem {

    private String name;
    private int xCoor;
    private int yCoor;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private List<Planet> planets;

    private String[] openNames;

    /**
     * Initializes a random solar system
     */
    public SolarSystem() {
        Random rn = new Random();

        String[] array = { "Aldea", "Andevian", "Antedi", "Balosnee", "Baratas", "Brax", "Bretel", "Calondia",
                "Campor", "Capelle", "Carzon", "Castor", "Cestus", "Cheron", "Courteney", "Daled",  "Deneb",
                "Deneva", "Davidia", "Draylon", "Drema", "Endor", "Esmee", "Fourmi", "Helena", "Hulst",
                "Iodine", "Iralius", "Janus", "Japori", "Jarada", "Jason", "Kaylon", "Klaestron", "Korma",
                "Kravat", "Largo", "Lave", "Ligon", "Lowry", "Montor", "Mordan", "Myrthe", "Nelvana", "Nix",
                "Nyle", "Odet", "Othello", "Parade", "Penthara", "Picard", "Pollux",	  "Ran", "Rhymus",
                "Rochani", "Rubicum", "Rutia", "Sarpeidon", "Sefalla", "Seltrice", "Somari", "Stakoron", "Styris",
                "Talani", "Tamus", "Tantalos", "Tanuga", "Tarchannen", "Terosa", "Thera", "Titan", "Torin", "Triacus",
                "Turkana", "Tyrus",  "Vadera", "Vagra", "Vandor", "Ventax", "Xenon", "Xerxes", "Yew", "Zuul"};

        setOpenNames(array);

        name = openNames[rn.nextInt(openNames.length)];
        xCoor = rn.nextInt(151);
        yCoor = rn.nextInt(101);
        techLevel = TechLevel.values()[rn.nextInt(8)];
        resourceLevel = ResourceLevel.values()[rn.nextInt(13)];
        planets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            planets.add(new Planet());
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s XCoor: %d YCoor: %d techLevel: %d resourcelevel: %d", name,
                xCoor, yCoor, techLevel.getTechLevel(), resourceLevel.getResourceLevel());
    }
    /**
     * Sets the open names for solar systems and planets
     *
     * @param names array of names
     */
    public void setOpenNames(String[] names) {
        this.openNames = names;
    }

    /**
     * @return solar system name
     */
    public String getSolarSystemName() { return name; }

    /**
     * @return solar system x coordinate
     */
    public int getXCoor() { return xCoor; }

    /**
     * @return solar system y coordinate
     */
    public int getYCoor() { return yCoor; }

    /**
     * @return solar system tech level
     */
    public TechLevel getTechLevel() { return techLevel; }

    /**
     * @return solar system resource level
     */
    public ResourceLevel getResourceLevel() { return resourceLevel; }

    /**
     * @return solar system planets
     */
    public List<Planet> getPlanets() { return planets; }
}
