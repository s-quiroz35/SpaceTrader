package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

class GoodTypeTechLevelVars {

    private final int minTechToProduce;
    private final int minTechToUse;
    private final int techMostProduce;

    /**
     * Initializes a GoodTypeTechLevelVars
     *
     * @param minTechToProduce min tech level to produce resource
     * @param minTechToUse min tech level to use resource
     * @param techMostProduce tech level that produces most of resource
     */
    public GoodTypeTechLevelVars(int minTechToProduce, int minTechToUse, int techMostProduce) {
        this.minTechToProduce = minTechToProduce;
        this.minTechToUse = minTechToUse;
        this.techMostProduce = techMostProduce;
    }

    /**
     * @return tech that produces the most of a good
     */
    public int getTechMostProduce() {
        return techMostProduce;
    }

    /**
     * @return minimum tech level to use
     */
    public int getMinTechToUse() {
        return minTechToUse;
    }

    /**
     * @return minimum tech level to produce
     */
    public int getMinTechToProduce() {
        return minTechToProduce;
    }
}
