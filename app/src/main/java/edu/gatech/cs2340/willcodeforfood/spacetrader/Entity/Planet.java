package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.Random;

/**
 * Represents a Planet
 *
 * @author Matt Bernet and Emma Chadwick
 * @version 1.1
 */
public class Planet {

    private String name;

    private String[] openNames;

    /**
     * Initializes a random planet
     */
    public Planet() {
        Random rn = new Random();

        String[] array = {"Acamar", "Adahn", "Damast", "Davlos","Frolix", "Gemulon", "Guinifer", "Hades",
                "Hamlet","Og", "Omega", "Omphalos", "Orias", "Umberlee", "Utopia","Exo", "Ferris", "Festen",
                "Magrat", "Malcoria", "Mentar","Quator", "Rakhar", "Yojimbo", "Zalkon", "Sigma", "Sol",
                "Khefa", "Kira", "Klaatu", "Ichinda", "Ierus", "Veaturn", "Vasilea", "Octavia", "Geria", "Perenulia",
                "Tunusuru", "Elilax", "Parusbel", "Limaran", "Blitede", "Blitz", "Zeta", "Acisoid", "Zemoru", "Alpha",
                "Blitea", "Dawnstar", "Falkreath", "Markarth", "Morthal", "Riften", "Solitude", "Whiterun", "Windhelm",
                "Hjerim", "Helgen", "Riverwood", "Rorikstead", "Lawrence", "Seattle", "Atlanta", "Arlington", "Hillwood",
                "Shermer", "Apollo", "Opportunity", "Eerie", "Milan", "Merik", "Mintaka","Regulas", "Relva","Krios", "Laertes", };

        setOpenNames(array);

        name = openNames[rn.nextInt(openNames.length)];
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
     * @return planet name
     */
    public String getPlanetName() { return name; }
}
