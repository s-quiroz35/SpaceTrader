package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Solar System
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.2
 */
public class SolarSystem {

    private String name;
    private Coordinate coordinates;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private List<Planet> planets;
    private ArrayList<Coordinate> coordinateList;

    private final ArrayList<String> openNames = new ArrayList<>(Arrays.asList("Acamar", "Adahn", "Damast", "Davlos","Frolix", "Gemulon", "Guinifer", "Hades",
            "Hamlet","Og", "Omega", "Omphalos", "Orias", "Umberlee", "Utopia","Exo", "Ferris", "Festen",
            "Magrat", "Malcoria", "Mentar","Quator", "Rakhar", "Yojimbo", "Zalkon", "Sigma", "Sol",
            "Khefa", "Kira", "Klaatu", "Ichinda", "Ierus", "Veaturn", "Vasilea", "Octavia", "Geria", "Perenulia",
            "Tunusuru", "Elilax", "Parusbel", "Limaran", "Blitede", "Blitz", "Zeta", "Acisoid", "Zemoru", "Alpha",
            "Blitea", "Dawnstar", "Falkreath", "Markarth", "Morthal", "Riften", "Solitude", "Whiterun", "Windhelm",
            "Hjerim", "Helgen", "Riverwood", "Rorikstead", "Lawrence", "Seattle", "Atlanta", "Arlington", "Hillwood",
            "Shermer", "Apollo", "Opportunity", "Eerie", "Milan", "Merik", "Mintaka","Regulas", "Relva","Krios", "Laertes"));

    /**
     * Initializes a random solar system
     */
    public SolarSystem(String n) {
        Random rn = new Random();

        name = n;
        coordinateList = new ArrayList<>();
        coordinates = createCoordinates();
        techLevel = TechLevel.values()[rn.nextInt(8)];
        resourceLevel = ResourceLevel.values()[rn.nextInt(13)];

        planets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int index = rn.nextInt(openNames.size());
            String name = openNames.get(index);
            openNames.remove(index);
            planets.add(new Planet(name));
        }
    }

    private Coordinate createCoordinates() {
        Random rn = new Random();

        int x = rn.nextInt(151);
        int y = rn.nextInt(101);

        Coordinate c = new Coordinate(x, y);
        if (!coordinateList.contains(c)) {
            coordinateList.add(c);
            return c;
        } else {
            createCoordinates();
        }
        return null;
    }

    /**
     * @return solar system name
     */
    public String getSolarSystemName() { return name; }

    /**
     * @return solar system's coordinates
     */
    public Coordinate getCoordinates() { return coordinates; }

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

    @Override
    public String toString() {
        String string = String.format("Name: %s, xCoor: %d, yCoor: %d, TechLevel: %d, " +
                        "ResourceLevel: %d . With the following planets", name, coordinates.getXCor(),
                coordinates.getYCor(), techLevel.getTechLevel(),
                resourceLevel.getResourceLevel());
        for (Planet p : planets) {
            string = string + " " + p.toString();
        }
        return string;
    }
}
